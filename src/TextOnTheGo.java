import controllers.ContactController;
import controllers.TextController;
import controllers.UserController;
import dtos.requests.AddContactRequest;
import dtos.requests.LoginUserRequest;
import dtos.requests.RegisterUserRequest;
import dtos.requests.SendMessageRequest;
import dtos.responses.AddContactResponse;
import dtos.responses.LoginUserResponse;
import dtos.responses.RegisterUserResponse;
import dtos.responses.SendMessageResponse;
import javax.swing.*;

public class TextOnTheGo {
    private final UserController userController;
    private final ContactController contactController;
    private final TextController textController;

    public TextOnTheGo() {
        this.userController = new UserController();
        this.contactController = new ContactController();
        this.textController = new TextController();
    }

    public static void main(String[] args) {
        TextOnTheGo chatApp = new TextOnTheGo();
        chatApp.start();
    }

    public void start() {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to TextOnTheGo!", "TextOnTheGo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                register();
            } else if (choice == 1) {
                login();
            } else {
                System.exit(0);
            }
        }
    }

    private void register() {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        RegisterUserRequest request = new RegisterUserRequest(firstName, lastName, age, username, password);
        RegisterUserResponse response = userController.registerUser(request);
        JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.PLAIN_MESSAGE);
    }

    private void login() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        LoginUserRequest request = new LoginUserRequest(username, password);
        LoginUserResponse response = userController.loginUser(request);
        if (response.isSuccessful()) {
            showMainChatroom();
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showMainChatroom() {
        String[] options = {"Send Message", "Add Contact", "Change Profile Picture", "Logout"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Main Chatroom", "TextOnTheGo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                sendMessage();
            } else if (choice == 1) {
                addContact();
            } else if (choice == 2) {
                changeProfilePicture();
            } else {
                return;
            }
        }
    }

    private void sendMessage() {
        String message = JOptionPane.showInputDialog("Enter message:");
        String[] contacts = {"Contact 1", "Contact 2", "Contact 3"};
        String selectedContact = (String) JOptionPane.showInputDialog(null, "Select contact:",
                "Send Message", JOptionPane.QUESTION_MESSAGE, null, contacts, contacts[0]);
        SendMessageRequest request = new SendMessageRequest(selectedContact, message);
        SendMessageResponse response = textController.sendMessage(request);
        JOptionPane.showMessageDialog(null, response.getMessage(), "Send Message", JOptionPane.PLAIN_MESSAGE);
    }

    private void addContact() {
        String contactName = JOptionPane.showInputDialog("Enter contact name:");
        String phoneNumber = JOptionPane.showInputDialog("Enter contact phone number:");
        AddContactRequest request = new AddContactRequest(contactName, phoneNumber);
        AddContactResponse response = contactController.addContact(request);
        JOptionPane.showMessageDialog(null, response.getMessage(), "Add Contact", JOptionPane.PLAIN_MESSAGE);
    }

    private void changeProfilePicture() {
    }
}