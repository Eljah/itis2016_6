package ru.itis2016.login;
import java.io.Serializable;
import java.security.Principal;

/**
 * @author semika
 *
 */
public class JAASPasswordPrincipal implements Principal, Serializable {

    private String name;

    /**
     * @param name
     */
    public JAASPasswordPrincipal(String name) {
        if (name == null) {
            throw new NullPointerException("NULL password.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JAASPasswordPrincipal other = (JAASPasswordPrincipal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "JAASPasswordPrincipal [name=" + name + "]";
    }

}