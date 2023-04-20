package me.ikapkova.tests.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor

public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        this.login = specifyLogin(login);
        this.email = specifyEmail(email);
    }

    public String specifyEmail(String email) {
        if ((email != null && !email.isEmpty() && !email.isBlank())
                && Pattern.matches("((\\w+[\\.-]?\\w+)+@(\\w+[\\-.]?\\w+)+[\\.]{1}[a-z]{2,4})", email)) {
           return this.email = email;
        } else {
            throw new IllegalArgumentException("Email entered incorrectly");
        }
    }

    public String specifyLogin(String login) {
        if ((login != null && !login.isEmpty() && !login.isBlank()) && Pattern.matches("\\w{5,10}", login)) {
           return this.login = login;
        } else {
            throw new IllegalArgumentException("Login entered incorrectly" + login);
        }
    }

    public void setEmail(String email) {
        this.email = specifyEmail(email);
    }

    public void setLogin(String login) {
        this.login = specifyLogin(login);
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
