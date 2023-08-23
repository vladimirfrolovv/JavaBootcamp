package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    public User ( Long id, String login, String password, List<Chatroom> listCreatesChatroom, List<Chatroom> listUserChatroom ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.listCreatesChatroom = listCreatesChatroom;
        this.listUserChatroom = listUserChatroom;
    }

    private Long id;
    private String login;
    private String password;
    private List<Chatroom> listCreatesChatroom;
    private List<Chatroom> listUserChatroom;

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
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

    public List<Chatroom> getListCreatesChatroom ( ) {
        return listCreatesChatroom;
    }

    public void setListCreatesChatroom ( List<Chatroom> listCreatesChatroom ) {
        this.listCreatesChatroom = listCreatesChatroom;
    }

    public List<Chatroom> getListUserChatroom ( ) {
        return listUserChatroom;
    }

    public void setListUserChatroom ( List<Chatroom> listUserChatroom ) {
        this.listUserChatroom = listUserChatroom;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(listCreatesChatroom, user.listCreatesChatroom) && Objects.equals(listUserChatroom, user.listUserChatroom);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, login, password, listCreatesChatroom, listUserChatroom);
    }

    @Override
    public String toString ( ) {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", listCreatesChatroom=" + listCreatesChatroom +
                ", listUserChatroom=" + listUserChatroom +
                '}';
    }
}
