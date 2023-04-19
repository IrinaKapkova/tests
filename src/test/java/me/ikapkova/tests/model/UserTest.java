package me.ikapkova.tests.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.ikapkova.tests.constants.TestConstants.*;

class UserTest {


    User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);

    @Test
    @DisplayName("Тест конструктора с двумя параметрами")
    void createUserTest() {
        Assertions.assertNotNull(user);
    }


    @Test
    @DisplayName("Тест пустого конструктора")
    void testUserEmptyConstructor() {
        User user1 = new User();
        Assertions.assertNull(user1.getLogin());
        Assertions.assertNull(user1.getEmail());
    }

    @Test
    void checkCorrectMailTest() {
        Assertions.assertDoesNotThrow(() -> new User(CORRECT_LOGIN, CORRECT_EMAIL));
    }


    @Test
    @DisplayName("Проверка неравности email и логина")
    void doesNotEqualsLoginAndEmail() {
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }

    @Test
    @DisplayName("Проверка просмотра логина на корректность")
    void testGetUserLogin() {
        Assertions.assertEquals("Ivan1976", user.getLogin());
    }

    @Test
    @DisplayName("Проверка email на корректность при просмотре")
    void testGetUserEmail() {
        Assertions.assertEquals("Ivan@mail.ru", user.getEmail());
    }


   @Test
   @DisplayName("Проверка логина на корректность при изменении")
    void testSetUserLogin() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> user.setLogin(INVALID_LOGIN)
        );
    }
    @Test
    @DisplayName("Проверка email на корректность при изменении")
    void testSetUserEmailCorrect() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> user.setEmail(WRONG_EMAIL)
        );
    }
}



