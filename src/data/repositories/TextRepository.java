package data.repositories;

import data.models.Text;
import java.util.List;

public interface TextRepository {
    void addText(Text text);
    List<Text> getTextsBySender(String sender);
    List<Text> getTextsByRecipient(String recipient);
    List<Text> getAllTexts();
}