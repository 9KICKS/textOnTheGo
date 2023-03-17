package services;

import data.models.Contact;
import java.util.List;

public interface ContactService {
    void addContact(Contact contact);
    Contact getContactByName(String name);
    List<Contact> getAllContacts();
    void deleteContact(String name);
    void updateContact(String name, String phoneNumber);
}