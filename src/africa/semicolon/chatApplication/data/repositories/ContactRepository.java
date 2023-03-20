package africa.semicolon.chatApplication.data.repositories;

import africa.semicolon.chatApplication.data.models.Contact;
import java.util.List;

public interface ContactRepository {
    void addContact(Contact contact);
    Contact getContactByName(String name);
    List<Contact> getAllContacts();
    void deleteContact(String name);
    void updateContact(String name, String phoneNumber);
}