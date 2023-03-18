package dtos.requests;

import data.models.User;

public class ReceiveMessageRequest {
    private User recipient;

    public ReceiveMessageRequest(User recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}