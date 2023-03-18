import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import controllers.ContactController;
import controllers.TextController;
import controllers.UserController;
import data.repositories.TextRepository;
import data.repositories.TextRepositoryImpl;
import dtos.requests.AddContactRequest;
import dtos.requests.LoginUserRequest;
import dtos.requests.RegisterUserRequest;
import dtos.requests.ReceiveMessageRequest;
import dtos.requests.SendMessageRequest;
import dtos.responses.*;
import services.TextService;
import services.TextServiceImpl;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextOnTheGo {
    private final UserController userController;
    private final TextController textController;
    private final ContactController contactController;
    private TextService textService;
    private String loggedInUser;
    private String appTheme;
    private String appLanguage;

    public TextOnTheGo() {
        TextRepository textRepository = new TextRepositoryImpl();
        this.textService = new TextServiceImpl(textRepository);
        this.userController = new UserController();
        this.textController = new TextController((TextRepository) this.textService);
        this.contactController = new ContactController();
        this.loggedInUser = null;
        this.appTheme = "Default";
        this.appLanguage = "English";
    }

    public void run() {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to TextOnTheGo!", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                register();
            } else if (choice == 1) {
                if (login()) {
                    mainMenu();
                }
            } else {
                System.exit(0);
            }
        }
    }

    private void register() {
        String firstName = JOptionPane.showInputDialog(null, "Enter your first name:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Enter your last name:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE));
        String username = JOptionPane.showInputDialog(null, "Enter your username:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "Create password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        String confirmPassword = JOptionPane.showInputDialog(null, "Confirm password:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        if (password.equals(confirmPassword)) {
            RegisterUserRequest request = new RegisterUserRequest(firstName, lastName, age, username, password);
            RegisterUserResponse response = this.userController.registerUser(request);
            JOptionPane.showMessageDialog(null, response.getMessage());
        } else {
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean login() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "Enter your password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        LoginUserRequest request = new LoginUserRequest(username, password);
        LoginUserResponse response = this.userController.loginUser(request);
        if (response.isSuccessful()) {
            this.loggedInUser = username;
            JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private void mainMenu() {
        while (true) {
            String[] options = {"Add Contact", "Send Messages", "Receive Messages", "Change Profile Picture", "Customize", "Logout"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome " + this.loggedInUser + "!", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                addContact();
            } else if (choice == 1) {
                sendMessage();
            } else if (choice == 2) {
                receiveMessage();
            } else if (choice == 3) {
                changeProfilePicture();
            } else if (choice == 4) {
                customize();
            } else {
                this.loggedInUser = null;
                JOptionPane.showMessageDialog(null, "You have successfully logged out.", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    private void customize() {
        String[] options = {"O.S Default", "Dark Mode", "Light Mode"};
        int themeChoice = JOptionPane.showOptionDialog(null, "Select TextOnTheGo theme:", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (themeChoice) {
            case 0 -> this.appTheme = "O.S Default";
            case 1 -> this.appTheme = "Dark Mode";
            case 2 -> this.appTheme = "Light Mode";
        }
        options = new String[]{"English", "Spanish", "French"};
        int languageChoice = JOptionPane.showOptionDialog(null, "Select TextOnTheGo language:", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (languageChoice) {
            case 0 -> this.appLanguage = "English";
            case 1 -> this.appLanguage = "Spanish";
            case 2 -> this.appLanguage = "French";
        }
        JOptionPane.showMessageDialog(null, "TextOnTheGo customized successfully.");
    }

    private void receiveMessage() {
//        ReceiveMessageRequest request = new ReceiveMessageRequest(this.loggedInUser);
//        ReceiveMessageResponse response = this.textController.receiveMessages(request);
//        JOptionPane.showMessageDialog(null, response.getMessage());
    }
//
    private void sendMessage() {
//        String recipient = JOptionPane.showInputDialog(null, "Enter recipient username:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
//        String message = JOptionPane.showInputDialog(null, "Enter message:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
//        SendMessageRequest request = new SendMessageRequest(this.loggedInUser, recipient, message);
//        SendMessageResponse response = this.textController.sendMessage(request);
//        JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addContact() {
        String contactName = JOptionPane.showInputDialog(null, "Enter contact name:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        String phoneNumber = JOptionPane.showInputDialog(null, "Enter contact phone number:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        AddContactRequest request = new AddContactRequest(contactName, phoneNumber);
        AddContactResponse response = this.contactController.addContact(request);
        JOptionPane.showMessageDialog(null, response.getMessage());
    }

    private void changeProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Image profilePicture = ImageIO.read(selectedFile);
                JLabel profilePictureLabel = new JLabel(new ImageIcon(profilePicture));
                JOptionPane.showMessageDialog(null, profilePictureLabel, "Profile Picture", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error loading profile picture", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}