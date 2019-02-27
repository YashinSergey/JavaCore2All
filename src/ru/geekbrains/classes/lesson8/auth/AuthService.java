package ru.geekbrains.lesson8.auth;

public interface AuthService {
    boolean authUser(String username, String password);
}
