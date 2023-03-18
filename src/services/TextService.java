package services;

import data.models.User;

import java.util.List;

public interface TextService {
    void sendText(User senderName, User receiverNumber, String message);
    List<String> receiveTexts(User receiver);
}