package controllers;

import dtos.requests.LoginUserRequest;
import dtos.requests.RegisterUserRequest;
import dtos.responses.LoginUserResponse;
import dtos.responses.RegisterUserResponse;

public class UserController {
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        return new RegisterUserResponse("User successfully registered.");
    }

    public LoginUserResponse loginUser(LoginUserRequest request) {
        return new LoginUserResponse("User successfully logged in.");
    }
}