package data.repositories;

import data.models.Text;
import java.util.ArrayList;
import java.util.List;

public class TextRepositoryImpl implements TextRepository {
    private List<Text> texts = new ArrayList<>();

    @Override
    public void addText(Text text) {
        texts.add(text);
    }

    @Override
    public List<Text> getTextsBySender(String sender) {
        List<Text> result = new ArrayList<>();
        for (Text text : texts) {
            if (text.getSender().equals(sender)) {
                result.add(text);
            }
        }
        return result;
    }

    @Override
    public List<Text> getTextsByRecipient(String recipient) {
        List<Text> result = new ArrayList<>();
        for (Text text : texts) {
            if (text.getRecipient().equals(recipient)) {
                result.add(text);
            }
        }
        return result;
    }

    @Override
    public List<Text> getAllTexts() {
        return texts;
    }
}