package africa.semicolon.chatApplication.dtos.responses;

public class LoginUserResponse {
    private boolean success;
    private String message;

    public LoginUserResponse(String message) {
        this.success = true;
        this.message = message;
    }

    public boolean isSuccessful() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}