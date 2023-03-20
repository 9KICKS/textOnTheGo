package africa.semicolon.chatApplication.dtos.requests;

import africa.semicolon.chatApplication.data.models.User;

public class SendMessageRequest {
    private User sender;
    private User recipient;
    private String message;

    public SendMessageRequest(User sender, User recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}