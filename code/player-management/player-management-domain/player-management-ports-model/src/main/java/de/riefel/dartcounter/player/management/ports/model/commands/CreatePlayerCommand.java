package de.riefel.dartcounter.player.management.ports.model.commands;

/**
 * Command to create a Player.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 25 Okt 2021
 */
public class CreatePlayerCommand {

    private final String nickname;
    private final String name;
    private final String firstname;

    public CreatePlayerCommand(final String nickname, final String name, final String firstname) {
        this.firstname = firstname;
        this.name = name;
        this.nickname = nickname;
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
     * Get name
     *
     * @return value of name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get firstname
     *
     * @return value of firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreatePlayerCommand)) {
            return false;
        }

        CreatePlayerCommand that = (CreatePlayerCommand) o;

        if (this.nickname != null ? !this.nickname.equals(that.nickname) : that.nickname != null) {
            return false;
        }
        if (this.name != null ? !this.name.equals(that.name) : that.name != null) {
            return false;
        }
        return this.firstname != null ? this.firstname.equals(that.firstname) : that.firstname == null;
    }

    @Override
    public int hashCode() {
        int result = this.nickname != null ? this.nickname.hashCode() : 0;
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        result = 31 * result + (this.firstname != null ? this.firstname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreatePlayerCommand{" +
                        "nickname='" + this.nickname + '\'' +
                        ", name='" + this.name + '\'' +
                        ", firstname='" + this.firstname + '\'' +
                        '}';
    }
}
