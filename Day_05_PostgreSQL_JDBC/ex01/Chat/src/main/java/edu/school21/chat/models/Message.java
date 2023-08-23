package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    public Message ( Long id, User user, Chatroom chatroom, String textMessage, Timestamp dateTime ) {
        this.id = id;
        this.user = user;
        this.chatroom = chatroom;
        this.textMessage = textMessage;
        this.dateTime = dateTime;
    }

    private Long id;
    private User user;
    private Chatroom chatroom;
    private String textMessage;
    private Timestamp dateTime;

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public User getUser ( ) {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public Chatroom getChatroom ( ) {
        return chatroom;
    }

    public void setChatroom ( Chatroom chatroom ) {
        this.chatroom = chatroom;
    }

    public String getTextMessage ( ) {
        return textMessage;
    }

    public void setTextMessage ( String textMessage ) {
        this.textMessage = textMessage;
    }

    public Timestamp getDateTime ( ) {
        return dateTime;
    }

    public void setDateTime ( Timestamp dateTime ) {
        this.dateTime = dateTime;
    }


    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(user, message.user) && Objects.equals(chatroom, message.chatroom) && Objects.equals(textMessage, message.textMessage) && Objects.equals(dateTime, message.dateTime);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, user, chatroom, textMessage, dateTime);
    }

    @Override
    public String toString ( ) {
        return "Message : {\n" +
                "id=" + id +
                ",\n user=" + user +
                ",\n chatroom=" + chatroom +
                ",\n textMessage='" + textMessage + '\'' +
                ",\n dateTime=" + dateTime + '\n' +
                '}';
    }
}
