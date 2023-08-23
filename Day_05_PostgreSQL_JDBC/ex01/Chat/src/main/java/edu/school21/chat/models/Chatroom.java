package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    public Chatroom ( Long id, String nameChatroom, User creatorChatroom, List<Message> listMessages ) {
        this.id = id;
        this.nameChatroom = nameChatroom;
        this.creatorChatroom = creatorChatroom;
        this.listMessages = listMessages;
    }

    private Long id;
    private String nameChatroom;
    private User creatorChatroom;
    private List<Message> listMessages;

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getNameChatroom ( ) {
        return nameChatroom;
    }

    public void setNameChatroom ( String nameChatroom ) {
        this.nameChatroom = nameChatroom;
    }

    public User getCreatorChatroom ( ) {
        return creatorChatroom;
    }

    public void setCreatorChatroom ( User creatorChatroom ) {
        this.creatorChatroom = creatorChatroom;
    }

    public List<Message> getListMessages ( ) {
        return listMessages;
    }

    public void setListMessages ( List<Message> listMessages ) {
        this.listMessages = listMessages;
    }

    @Override
    public String toString ( ) {
        return "Chatroom{" +
                "id=" + id +
                ", nameChatroom='" + nameChatroom + '\'' +
                ", creatorChatroom=" + creatorChatroom +
                ", listMessages=" + listMessages +
                '}';
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(id, chatroom.id) && Objects.equals(nameChatroom, chatroom.nameChatroom) && Objects.equals(creatorChatroom, chatroom.creatorChatroom) && Objects.equals(listMessages, chatroom.listMessages);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, nameChatroom, creatorChatroom, listMessages);
    }
}
