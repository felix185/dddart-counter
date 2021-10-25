package de.riefel.dartcounter.common.events;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base interface for events.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public interface IEvent extends Serializable {

    /**
     * {@link Instant} containing the creation timestamp.
     *
     * @return the creation timestamp of this {@link IEvent} as {@link Instant}.
     */
    Instant getTimestamp();
}
