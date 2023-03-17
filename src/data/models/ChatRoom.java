package data.models;

import java.util.List;

public class ChatRoom {
    private List<User> users;
    private List<Text> texts;

    public ChatRoom(List<User> users, List<Text> texts) {
        this.users = users;
        this.texts = texts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void addMessage(Text message) {
        this.texts.add(message);
    }
}