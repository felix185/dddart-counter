package de.riefel.dartcounter.player.management.ports.outgoing;

import de.riefel.dartcounter.player.management.ports.model.types.PlayerTO;

import java.util.List;
import java.util.Optional;

/**
 * Interface to access and manage players from a repository.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public interface PlayerRepository {

    /**
     * Persists a player in the repository.
     *
     * @param player the {@link PlayerTO} to be persisted.
     * @return the persisted player as {@link PlayerTO}.
     */
    PlayerTO save(final PlayerTO player);

    /**
     * Find all players from the repository.
     *
     * @return a {@link List} with all available players as {@link PlayerTO}.
     */
    List<PlayerTO> findAllPlayers();

    /**
     * Finds a player by his/her nickname.
     *
     * @param nickname the nickname of the player to be found.
     * @return an {@link Optional} with the existing player as {@link PlayerTO} or {@code null} if no player with this nickname is existing.
     */
    Optional<PlayerTO> findPlayerByNickname(final String nickname);
}
