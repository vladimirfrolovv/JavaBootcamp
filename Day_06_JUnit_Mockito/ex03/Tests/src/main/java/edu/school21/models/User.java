package edu.school21.models;

import java.util.Objects;

public class User {
    private Integer id;
    private String login;
    private String password;
    private Boolean authenticated;

    public User ( Integer id, String login, String password, Boolean authenticated ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authenticated = authenticated;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getLogin ( ) {
        return login;
    }

    public void setLogin ( String login ) {
        this.login = login;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public Boolean getStatusAuth ( ) {
        return authenticated;
    }

    public void setStatusAuth ( Boolean statusAuth ) {
        this.authenticated = statusAuth;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(authenticated, user.authenticated);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, login, password, authenticated);
    }

    @Override
    public String toString ( ) {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", statusAuth=" + authenticated +
                '}';
    }
}
