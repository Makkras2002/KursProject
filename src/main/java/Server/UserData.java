package Server;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {
    private String login;
    private String password;
    private static final long serialVersionUID = 1L;

    public UserData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserData() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(login, userData.login) && Objects.equals(password, userData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
