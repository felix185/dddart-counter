package de.riefel.player.management.core;

import de.riefel.dartcounter.player.management.ports.model.types.PlayerTO;
import de.riefel.dartcounter.player.management.ports.outgoing.PlayerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An in-memory player repository implementation for tests.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
class PlayerRepositoryInMemoryAdapter implements PlayerRepository {

    private final Map<Long, PlayerTO> playerMap = new HashMap<>();

    void clear() {
        this.playerMap.clear();
    }

    @Override
    public PlayerTO save(PlayerTO player) {
        final long createdId = UUID.randomUUID().getMostSignificantBits();
        final PlayerTO createdPlayer = new PlayerTO(createdId, 1, player.getNickname(), player.getFirstname(), player.getName());
        this.playerMap.put(createdId, createdPlayer);
        return createdPlayer;
    }

    @Override
    public List<PlayerTO> findAllPlayers() {
        return new ArrayList<>(this.playerMap.values());
    }

    @Override
    public Optional<PlayerTO> findPlayerByNickname(String nickname) {
        return this.playerMap.values().stream().filter(p -> p.getNickname().equals(nickname)).findFirst();
    }
}
