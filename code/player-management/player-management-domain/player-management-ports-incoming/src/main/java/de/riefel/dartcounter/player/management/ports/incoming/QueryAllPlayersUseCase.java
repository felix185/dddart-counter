package de.riefel.dartcounter.player.management.ports.incoming;

import de.riefel.dartcounter.player.management.ports.model.types.PlayerTO;

import java.util.List;

/**
 * Interface for the use case to query all players.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public interface QueryAllPlayersUseCase {

    /**
     * Handles the query to get all players.
     *
     * @return an <b>unmodifiable</b> {@link List} of all players as {@link PlayerTO}.
     */
    List<PlayerTO> handle();
}
