package services;

import data.models.User;

public interface TextService {
    void sendText(User senderName, User receiverNumber, String message);
}