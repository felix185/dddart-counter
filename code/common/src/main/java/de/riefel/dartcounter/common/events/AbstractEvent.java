package de.riefel.dartcounter.common.events;

import java.time.Instant;

/**
 * Abstract base class for events.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public abstract class AbstractEvent implements IEvent {

    private static final long serialVersionUID = 8457851295093427009L;

    protected final Instant timestamp;

    protected AbstractEvent() {
        this.timestamp = Instant.now();
    }

    @Override
    public Instant getTimestamp() {
        return this.timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEvent)) {
            return false;
        }

        AbstractEvent that = (AbstractEvent) o;

        return this.timestamp != null ? this.timestamp.equals(that.timestamp) : that.timestamp == null;
    }

    @Override
    public int hashCode() {
        return this.timestamp != null ? this.timestamp.hashCode() : 0;
    }
}
