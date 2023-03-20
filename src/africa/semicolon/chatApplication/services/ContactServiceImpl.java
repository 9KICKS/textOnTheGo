package africa.semicolon.chatApplication.services;

import africa.semicolon.chatApplication.data.models.Contact;
import africa.semicolon.chatApplication.data.repositories.ContactRepository;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.addContact(contact);
    }

    @Override
    public Contact getContactByName(String name) {
        return contactRepository.getContactByName(name);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Override
    public void deleteContact(String name) {
        contactRepository.deleteContact(name);
    }

    @Override
    public void updateContact(String name, String phoneNumber) {
        contactRepository.updateContact(name, phoneNumber);
    }
}