package de.riefel.dartcounter.player.management.ports.model.events;

import de.riefel.dartcounter.common.events.AbstractEvent;

/**
 * Event to be fired when a new player is created.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public class NewPlayerCreatedEvent extends AbstractEvent {

    private static final long serialVersionUID = -8685252889641791567L;

    private final long playerId;
    private final String nickname;

    public NewPlayerCreatedEvent(final long playerId, final String nickname) {
        super();
        this.playerId = playerId;
        this.nickname = nickname;
    }

    /**
     * Get playerId
     *
     * @return value of playerId
     */
    public long getPlayerId() {
        return this.playerId;
    }

    /**
     * Get nickname
     *
     * @return value of nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NewPlayerCreatedEvent)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        NewPlayerCreatedEvent that = (NewPlayerCreatedEvent) o;

        if (this.playerId != that.playerId) {
            return false;
        }
        return this.nickname != null ? this.nickname.equals(that.nickname) : that.nickname == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (this.playerId ^ (this.playerId >>> 32));
        result = 31 * result + (this.nickname != null ? this.nickname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewPlayerCreatedEvent{" +
                        "playerId=" + this.playerId +
                        ", nickname='" + this.nickname + '\'' +
                        ", timestamp=" + this.timestamp +
                        '}';
    }
}
