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
        if (login == null || login.isEmpty() || login.isBlank())
        // если  null, пусто, содержит только пробелы
        {
            new RuntimeException("Login must not be empty, null or contain only spaces");
        }
        if ((login != null && !login.isEmpty() && !login.isBlank()) && Pattern.matches("\\w{5,10}", login))
        // если соответствует шаблону: это слово из 6-11 либо латинских букв нижнего или верхнего регистра , либо арабских цифр
        {
            this.login = login;

        } else {
            throw new IllegalArgumentException("Login entered incorrectly"+ login);
        }
        if ((email != null && !email.isEmpty() && !email.isBlank()) && Pattern.matches("((\\w+[\\.-]?\\w+)+@(\\w+[\\-.]?\\w+)+[\\.]{1}[a-z]{2,4})", email)) {
//если не null, не пусто, не содержит только пробелы и соответствует шаблону:
//Состоять из двух частей, разделённых символом “@”.
//Левая часть должна состоять из английских букв или цифр, может содержать точки и тире, притом после точки или тире обязательно должна следовать как минимум одна буква.
//Правая часть должна содержать хотя бы одну точку в конце, после которой должны следовать от двух до четырёх букв.
//Начинаться обе части должны с буквенных символов.
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email entered incorrectly");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if ((email != null && !email.isEmpty() && !email.isBlank()) && Pattern.matches("((\\w+[\\.-]?\\w+)+@(\\w+[\\-.]?\\w+)+[\\.]{1}[a-z]{2,4})", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email entered incorrectly");
        }
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty() || login.isBlank())
        // если  null, пусто, содержит только пробелы
        {
            new RuntimeException("Login must not be empty, null or contain only spaces");
        }
        if ((login != null && !login.isEmpty() && !login.isBlank()) && Pattern.matches("\\w{5,10}", login))
        // если соответствует шаблону: это слово из 6-11 либо латинских букв нижнего или верхнего регистра , либо арабских цифр
        {
            this.login = login;

        } else {
            throw new IllegalArgumentException("Login entered incorrectly"+ login);
    }
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
