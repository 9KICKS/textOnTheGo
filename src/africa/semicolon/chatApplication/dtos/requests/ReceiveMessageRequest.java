package africa.semicolon.chatApplication.dtos.requests;

import africa.semicolon.chatApplication.data.models.User;

public class ReceiveMessageRequest {
    private User recipient;

    public ReceiveMessageRequest(User recipient) {
        this.recipient = recipient;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}