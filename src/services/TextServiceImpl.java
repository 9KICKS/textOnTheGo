package services;

import data.models.Text;
import data.models.User;
import data.repositories.TextRepository;
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

    public List<Text> getAllTexts() {
        return textRepository.getAllTexts();
    }
}