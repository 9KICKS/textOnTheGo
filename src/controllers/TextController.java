package controllers;

import data.models.Text;
import data.repositories.TextRepository;
import dtos.requests.ReceiveMessageRequest;
import dtos.requests.SendMessageRequest;
import dtos.responses.ReceiveMessageResponse;
import dtos.responses.SendMessageResponse;
import java.util.List;

public class TextController {
    private final TextRepository textRepository;

    public TextController(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public SendMessageResponse sendMessage(SendMessageRequest request) {
        Text text = new Text(request.getSender(), request.getRecipient(), request.getMessage());
        textRepository.addText(text);
        return new SendMessageResponse("success", "Message sent successfully.");
    }

    public ReceiveMessageResponse receiveMessages(ReceiveMessageRequest request) {
        List<Text> texts = textRepository.getTextsByRecipient(request.getRecipient());
        if (texts.isEmpty()) {
            return new ReceiveMessageResponse(null, "No messages found.");
        } else {
            return new ReceiveMessageResponse(texts, "Messages retrieved successfully.");
        }
    }
}