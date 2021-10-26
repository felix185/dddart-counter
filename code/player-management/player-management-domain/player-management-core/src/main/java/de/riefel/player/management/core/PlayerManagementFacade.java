package de.riefel.player.management.core;

import de.riefel.dartcounter.common.errorhandling.ErrorCode;
import de.riefel.dartcounter.common.errorhandling.exception.BusinessException;
import de.riefel.dartcounter.player.management.ports.incoming.CreatePlayerUseCase;
import de.riefel.dartcounter.player.management.ports.incoming.QueryAllPlayersUseCase;
import de.riefel.dartcounter.player.management.ports.model.commands.CreatePlayerCommand;
import de.riefel.dartcounter.player.management.ports.model.events.NewPlayerCreatedEvent;
import de.riefel.dartcounter.player.management.ports.model.types.PlayerTO;
import de.riefel.dartcounter.player.management.ports.outgoing.PlayerManagementEventPublisher;
import de.riefel.dartcounter.player.management.ports.outgoing.PlayerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Facade of the player management domain. Implements use cases.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public class PlayerManagementFacade implements CreatePlayerUseCase, QueryAllPlayersUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerManagementEventPublisher playerManagementEventPublisher;

    public PlayerManagementFacade(final PlayerRepository playerRepository, final PlayerManagementEventPublisher playerManagementEventPublisher) {
        this.playerRepository = playerRepository;
        this.playerManagementEventPublisher = playerManagementEventPublisher;
    }

    @Override
    public long createPlayer(final CreatePlayerCommand createPlayerCommand) {
        final Optional<PlayerTO> optionalExistingPlayerWithNickname = this.playerRepository.findPlayerByNickname(createPlayerCommand.getNickname());
        if (optionalExistingPlayerWithNickname.isPresent()) {
            throw new BusinessException(ErrorCode.ALREADY_EXISTING, "Player with nickname is already existing", createPlayerCommand.getNickname());
        } else {
            final PlayerTO toBeCreated = new PlayerTO(createPlayerCommand.getNickname(), createPlayerCommand.getFirstname(), createPlayerCommand.getName());
            final PlayerTO created = this.playerRepository.save(toBeCreated);
            this.playerManagementEventPublisher.publish(new NewPlayerCreatedEvent(created.getId(), created.getNickname()));
            return created.getId();
        }
    }

    @Override
    public List<PlayerTO> getAllPlayers() {
        return Collections.unmodifiableList(this.playerRepository.findAllPlayers());
    }
}
