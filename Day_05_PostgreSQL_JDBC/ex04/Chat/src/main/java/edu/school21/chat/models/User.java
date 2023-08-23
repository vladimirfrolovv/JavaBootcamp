package edu.school21.chat.models;

import java.util.*;

public class User {
    public User ( Long id, String login, String password, List<Chatroom> listCreatesChatroom, List<Chatroom> listUserChatroom ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.listUserChatroom = new HashSet<>();
        this.listCreatesChatroom = new HashSet<>();
        if (listCreatesChatroom != null) {
            this.listCreatesChatroom.addAll(listCreatesChatroom);
        }
        if (listUserChatroom != null) {
            this.listUserChatroom.addAll(listUserChatroom);
        }


    }

    private Long id;
    private String login;
    private String password;
    private Set<Chatroom> listCreatesChatroom;
    private Set<Chatroom> listUserChatroom;

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
        List<Chatroom> res = new ArrayList<>();
        res.addAll(listCreatesChatroom);
        return res;
    }

    public void setListCreatesChatroom ( List<Chatroom> listCreatesChatroom ) {
        this.listCreatesChatroom.addAll(listCreatesChatroom);
    }
    public void addCreateRoom ( Chatroom listCreatesChatroom ) {
        this.listCreatesChatroom.add(listCreatesChatroom);
    }
    public void addUsRoom ( Chatroom listCreatesChatroom ) {
        this.listUserChatroom.add(listCreatesChatroom);
    }

    public List<Chatroom> getListUserChatroom ( ) {
        List<Chatroom> res = new ArrayList<>();
        res.addAll(listUserChatroom);
        return res;
    }

    public void setListUserChatroom ( List<Chatroom> listUserChatroom ) {
        this.listUserChatroom.addAll(listUserChatroom);
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
                ", listCreatesChatroom=" + String.format("%s",listCreatesChatroom) +
                ", listUserChatroom=" +  String.format("%s",listUserChatroom ) +
                '}';
    }
}
