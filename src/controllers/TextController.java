package controllers;

import dtos.requests.SendMessageRequest;
import dtos.responses.SendMessageResponse;

public class TextController {
    public SendMessageResponse sendMessage(SendMessageRequest request) {
        String status = "Success.";
        String message = "Message sent successfully.";
        return new SendMessageResponse(status, message);
    }
}