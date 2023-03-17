package dtos.responses;

public class AddContactResponse {
    private String message;

    public AddContactResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}