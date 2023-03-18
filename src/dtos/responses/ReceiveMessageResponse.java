package dtos.responses;

import data.models.Text;

import java.util.List;

public class ReceiveMessageResponse {
    private List<Text> texts;
    private String message;

    public ReceiveMessageResponse(List<Text> texts, String message) {
        this.texts = texts;
        this.message = message;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}