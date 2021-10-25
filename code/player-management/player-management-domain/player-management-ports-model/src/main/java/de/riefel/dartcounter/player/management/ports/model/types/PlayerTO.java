package de.riefel.dartcounter.player.management.ports.model.types;

import de.riefel.dartcounter.common.events.AbstractEvent;
import de.riefel.dartcounter.common.types.AbstractTO;

import java.io.Serializable;

/**
 * Transport object for a player.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public class PlayerTO extends AbstractTO {
    private static final long serialVersionUID = -7205096574215537838L;

    private final String nickname;
    private final String firstname;
    private final String name;

    public PlayerTO(final long id, final int version, final String nickname, final String firstname, final String name) {
        super(id, version);
        this.nickname=nickname;
        this.firstname=firstname;
        this.name=name;
    }

    /**
     * Get nickname
     *
     * @return value of nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Get firstname
     *
     * @return value of firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Get name
     *
     * @return value of name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerTO)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        PlayerTO playerTO = (PlayerTO) o;

        if (this.nickname != null ? !this.nickname.equals(playerTO.nickname) : playerTO.nickname != null) {
            return false;
        }
        if (this.firstname != null ? !this.firstname.equals(playerTO.firstname) : playerTO.firstname != null) {
            return false;
        }
        return this.name != null ? this.name.equals(playerTO.name) : playerTO.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.nickname != null ? this.nickname.hashCode() : 0);
        result = 31 * result + (this.firstname != null ? this.firstname.hashCode() : 0);
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlayerTO{" +
                        "id=" + this.id +
                        ", version=" + this.version +
                        ", nickname='" + this.nickname + '\'' +
                        ", firstname='" + this.firstname + '\'' +
                        ", name='" + this.name + '\'' +
                        '}';
    }
}
