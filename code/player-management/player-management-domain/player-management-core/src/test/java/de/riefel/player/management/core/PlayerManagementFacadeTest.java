package de.riefel.player.management.core;

import de.riefel.dartcounter.common.errorhandling.exception.BusinessException;
import de.riefel.dartcounter.player.management.ports.model.commands.CreatePlayerCommand;
import de.riefel.dartcounter.player.management.ports.model.types.PlayerTO;
import de.riefel.dartcounter.player.management.ports.outgoing.PlayerManagementEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerManagementFacadeTest {

    private final PlayerRepositoryInMemoryAdapter playerRepository = new PlayerRepositoryInMemoryAdapter();
    private final PlayerManagementEventPublisher playerManagementEventPublisher = new PlayerManagementEventPublisherLoggerAdapter();
    private final PlayerManagementFacade underTest = new PlayerManagementFacade(playerRepository, playerManagementEventPublisher);

    @BeforeEach
    void clearDatabase() {
        this.playerRepository.clear();
    }

    @Test
    void findAll_noPlayers_shouldReturnEmptyList() {
        final List<PlayerTO> actual = underTest.handle();
        assertTrue(actual.isEmpty());
    }

    @Test
    void findAll_existingPlayers_shouldReturnListWithAvailablePlayers() {
        final PlayerTO player1 = playerRepository.save(new PlayerTO("Player 1", "Player", "One"));
        final PlayerTO player2 = playerRepository.save(new PlayerTO("Player 2", "Player", "Two"));

        final List<PlayerTO> expected = Arrays.asList(player1, player2);
        final List<PlayerTO> actual = underTest.handle();
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void createNew_notExisting_shouldCreateNewPlayerAndPublishEvent() {
        final String nickname = "Nickname";
        final String firstname = "Firstname";
        final String name = "Name";
        underTest.handle(new CreatePlayerCommand(nickname, name, firstname));

        final List<PlayerTO> existingPlayers = playerRepository.findAllPlayers();
        assertFalse(existingPlayers.isEmpty());
        final PlayerTO actual = existingPlayers.get(0);
        assertEquals(nickname, actual.getNickname());
        assertEquals(firstname, actual.getFirstname());
        assertEquals(name, actual.getName());
    }

    @Test
    void createNew_alreadyExisting_shouldThrowException() {
        final String nickname = "Nickname";
        final String firstname = "Firstname";
        final String name = "Name";

        playerRepository.save(new PlayerTO(nickname, "Other Firstname", "Other Name"));

        final BusinessException bEx = assertThrows(BusinessException.class, () -> underTest.handle(new CreatePlayerCommand(nickname, name, firstname)));
        assertTrue(bEx.getMessage().contains("Player with nickname is already existing"));
        assertEquals(1, bEx.getParameters().length);
        assertEquals("Nickname", bEx.getParameters()[0]);
    }
}