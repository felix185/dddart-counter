package de.riefel.dartcounter.player.management.ports.incoming;

import de.riefel.dartcounter.player.management.ports.model.commands.CreatePlayerCommand;

/**
 * Interface for the use case to create a new Player.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public interface CreatePlayerUseCase {

    /**
     * Handles the command to create a new player.
     *
     * @param createPlayerCommand the command to create a new player with the included information.
     * @return the id of the created player.
     */
    long handle(final CreatePlayerCommand createPlayerCommand);
}
