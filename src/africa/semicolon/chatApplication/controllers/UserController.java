package africa.semicolon.chatApplication.controllers;

import africa.semicolon.chatApplication.dtos.requests.LoginUserRequest;
import africa.semicolon.chatApplication.dtos.requests.RegisterUserRequest;
import africa.semicolon.chatApplication.dtos.responses.LoginUserResponse;
import africa.semicolon.chatApplication.dtos.responses.RegisterUserResponse;

public class UserController {
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        return new RegisterUserResponse("User successfully registered.");
    }

    public LoginUserResponse loginUser(LoginUserRequest request) {
        return new LoginUserResponse("User successfully logged in.");
    }
}