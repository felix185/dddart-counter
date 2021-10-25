package de.riefel.player.management.core;

import de.riefel.dartcounter.common.logging.ILogger;
import de.riefel.dartcounter.player.management.ports.model.events.NewPlayerCreatedEvent;
import de.riefel.dartcounter.player.management.ports.outgoing.PlayerManagementEventPublisher;

/**
 * Player management event publisher adapter which logs the occurring events.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
class PlayerManagementEventPublisherLoggerAdapter implements PlayerManagementEventPublisher {

    private static final ILogger LOG = ILogger.getLogger(PlayerManagementEventPublisherLoggerAdapter.class);

    @Override
    public void publish(NewPlayerCreatedEvent newPlayerCreatedEvent) {
        LOG.info("New Player Event: {}", newPlayerCreatedEvent);
    }
}
