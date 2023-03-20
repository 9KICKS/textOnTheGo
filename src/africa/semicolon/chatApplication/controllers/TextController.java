package africa.semicolon.chatApplication.controllers;

import africa.semicolon.chatApplication.data.models.Text;
import africa.semicolon.chatApplication.data.repositories.TextRepository;
import africa.semicolon.chatApplication.dtos.requests.ReceiveMessageRequest;
import africa.semicolon.chatApplication.dtos.requests.SendMessageRequest;
import africa.semicolon.chatApplication.dtos.responses.ReceiveMessageResponse;
import africa.semicolon.chatApplication.dtos.responses.SendMessageResponse;
import africa.semicolon.chatApplication.services.TextService;
import java.util.List;

public class TextController {
    private final TextService textService;
    private final TextRepository textRepository;

    public TextController(TextService textService, TextRepository textRepository) {
        this.textService = textService;
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