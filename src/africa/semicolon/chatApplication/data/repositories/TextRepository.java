package africa.semicolon.chatApplication.data.repositories;

import africa.semicolon.chatApplication.data.models.Text;
import africa.semicolon.chatApplication.data.models.User;
import java.util.List;

public interface TextRepository {
    void addText(Text text);
    List<Text> getTextsBySender(String sender);
    List<Text> getTextsByRecipient(User recipient);
    List<Text> getAllTexts();
}