package de.riefel.dartcounter.player.management.ports.outgoing;

import de.riefel.dartcounter.player.management.ports.model.events.NewPlayerCreatedEvent;

/**
 * Publishes the events of the player management bounded context.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public interface PlayerManagementEventPublisher {

    /**
     * Publishes the {@link NewPlayerCreatedEvent}.
     *
     * @param newPlayerCreatedEvent the {@link NewPlayerCreatedEvent} to be published.
     */
    void publish(final NewPlayerCreatedEvent newPlayerCreatedEvent);
}
