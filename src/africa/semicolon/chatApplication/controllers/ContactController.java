package africa.semicolon.chatApplication.controllers;

import africa.semicolon.chatApplication.dtos.requests.AddContactRequest;
import africa.semicolon.chatApplication.dtos.responses.AddContactResponse;

public class ContactController {
    public AddContactResponse addContact(AddContactRequest request) {
        String message = "Contact added successfully.";
        return new AddContactResponse(message);
    }
}