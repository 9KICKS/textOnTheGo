package controllers;

import dtos.requests.AddContactRequest;
import dtos.responses.AddContactResponse;

public class ContactController {
    public AddContactResponse addContact(AddContactRequest request) {
        String message = "Contact added successfully.";
        return new AddContactResponse(message);
    }
}