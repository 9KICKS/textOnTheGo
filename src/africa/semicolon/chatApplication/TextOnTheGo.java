package africa.semicolon.chatApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import africa.semicolon.chatApplication.controllers.ContactController;
import africa.semicolon.chatApplication.controllers.TextController;
import africa.semicolon.chatApplication.controllers.UserController;
import africa.semicolon.chatApplication.data.repositories.TextRepository;
import africa.semicolon.chatApplication.data.repositories.TextRepositoryImpl;
import africa.semicolon.chatApplication.dtos.requests.AddContactRequest;
import africa.semicolon.chatApplication.dtos.requests.LoginUserRequest;
import africa.semicolon.chatApplication.dtos.requests.RegisterUserRequest;
import africa.semicolon.chatApplication.dtos.responses.*;
import africa.semicolon.chatApplication.services.TextService;
import africa.semicolon.chatApplication.services.TextServiceImpl;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class TextOnTheGo {
    private static UserController userController;
    private static TextController textController;
    private static ContactController contactController;
    private static TextService textService;
    private static String loggedInUser;
    private static String appTheme;
    private static String appLanguage;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        TextRepository textRepository = new TextRepositoryImpl();
        textService = new TextServiceImpl(textRepository);
        userController = new UserController();
        textController = new TextController(textService, textRepository);
        contactController = new ContactController();
        loggedInUser = null;
        appTheme = "Default";
        appLanguage = "English";
        run();
    }

    private static void run() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to africa.semicolon.chatApplication.TextOnTheGo!", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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

    private static void register() {
        String firstName = JOptionPane.showInputDialog(null, "Enter your first name:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Enter your last name:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE));
        String username = JOptionPane.showInputDialog(null, "Enter your username:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "Create password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        JPasswordField passwordField2 = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "Confirm password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] passwordChars2 = passwordField2.getPassword();
        String confirmPassword = new String(passwordChars2);
        if (password.equals(confirmPassword)) {
            RegisterUserRequest request = new RegisterUserRequest(firstName, lastName, age, username, password);
            RegisterUserResponse response = userController.registerUser(request);
            JOptionPane.showMessageDialog(null, response.getMessage());
        } else {
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean login() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "Enter your password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        LoginUserRequest request = new LoginUserRequest(username, password);
        LoginUserResponse response = userController.loginUser(request);
        if (response.isSuccessful()) {
            loggedInUser = response.getMessage();
            JOptionPane.showMessageDialog(null, "Welcome to TextOnTheGo!", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "TextOnTheGo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private static void mainMenu() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        while (true) {
            String[] options = {"Add Contact", "Send Messages", "Receive Messages", "Change Profile Picture", "Customize", "Logout"};
            int choice = JOptionPane.showOptionDialog(null, "CHAT ROOM", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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
                JOptionPane.showMessageDialog(null, "You have successfully logged out.", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    private static void customize() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] themeOptions = {"O.S Default", "Dark Mode", "Light Mode"};
        int themeChoice = JOptionPane.showOptionDialog(null, "Select TextOnTheGo theme:", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, themeOptions, themeOptions[0]);
        switch (themeChoice) {
            case 0 -> UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            case 1 -> {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException e) {JOptionPane.showMessageDialog(null, "Unable to set the Dark Mode theme. Using the default theme instead.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case 2 -> {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, "Unable to set the Light Mode theme. Using the default theme instead.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String[] languageOptions = {"English", "Spanish", "French"};
        int languageChoice = JOptionPane.showOptionDialog(null, "Select TextOnTheGo language:", "TextOnTheGo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, languageOptions, languageOptions[0]);
        switch (languageChoice) {
            case 0 -> Locale.setDefault(Locale.ENGLISH);
            case 1 -> Locale.setDefault(new Locale("es"));
            case 2 -> Locale.setDefault(Locale.FRENCH);
        }
        JOptionPane.showMessageDialog(null, "TextOnTheGo customized successfully.");
    }

    private static void receiveMessage() {
//        ReceiveMessageRequest request = new ReceiveMessageRequest(this.loggedInUser);
//        ReceiveMessageResponse response = this.textController.receiveMessages(request);
//        JOptionPane.showMessageDialog(null, response.getMessage());
    }
//
    private static void sendMessage() {
//        String recipient = JOptionPane.showInputDialog(null, "Enter recipient username:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
//        String message = JOptionPane.showInputDialog(null, "Enter message:", "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
//        SendMessageRequest request = new SendMessageRequest(this.loggedInUser, recipient, message);
//        SendMessageResponse response = this.textController.sendMessage(request);
//        JOptionPane.showMessageDialog(null, response.getMessage(), "africa.semicolon.chatApplication.TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addContact() {
        String contactName = JOptionPane.showInputDialog(null, "Enter contact name:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        String phoneNumber = JOptionPane.showInputDialog(null, "Enter contact phone number:", "TextOnTheGo", JOptionPane.INFORMATION_MESSAGE);
        AddContactRequest request = new AddContactRequest(contactName, phoneNumber);
        AddContactResponse response = contactController.addContact(request);
        JOptionPane.showMessageDialog(null, response.getMessage());
    }

    private static void changeProfilePicture() {
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