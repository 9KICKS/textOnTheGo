package africa.semicolon.chatApplication.services;

import africa.semicolon.chatApplication.data.models.Text;
import africa.semicolon.chatApplication.data.models.User;
import africa.semicolon.chatApplication.data.repositories.TextRepository;
import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {
    private final TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public void sendText(User senderName, User receiverNumber, String message) {
        Text text = new Text(senderName, receiverNumber, message);
        textRepository.addText(text);
    }

    @Override
    public List<String> receiveTexts(User recipient) {
        List<String> messages = new ArrayList<>();
        List<Text> texts = textRepository.getAllTexts();
        for (Text text : texts) {
            if (text.getRecipient().equals(recipient)) {
                messages.add(text.getSender().getUsername() + ": " + text.getMessage());
            }
        }
        return messages;
    }

    public List<Text> getAllTexts() {
        return textRepository.getAllTexts();
    }
}