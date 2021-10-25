package de.riefel.dartcounter.common.types;

import java.io.Serializable;

/**
 * Abstract base class for transport objects.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public abstract class AbstractTO implements Serializable {
    private static final long serialVersionUID = -3655303776948216574L;

    protected final long id;
    protected final int version;

    protected AbstractTO(final long id, final int version) {
        this.id = id;
        this.version = version;
    }

    /**
     * Get id
     *
     * @return value of id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get version
     *
     * @return value of version
     */
    public int getVersion() {
        return this.version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractTO)) {
            return false;
        }

        AbstractTO that = (AbstractTO) o;

        if (this.id != that.id) {
            return false;
        }
        return this.version == that.version;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.id ^ (this.id >>> 32));
        result = 31 * result + this.version;
        return result;
    }

    @Override
    public abstract String toString();
}
