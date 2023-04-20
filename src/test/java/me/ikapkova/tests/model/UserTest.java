package me.ikapkova.tests.model;

import org.junit.jupiter.api.*;

import static me.ikapkova.tests.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);

    @Test
    @DisplayName("Проверка просмотра логина на корректность")
    void testGetUserLogin() {
        Assertions.assertEquals(CORRECT_LOGIN, user.getLogin());
    }

    @Test
    @DisplayName("Тест конструктора с двумя параметрами")
    void createUserTest() {
        assertNotNull(user);
    }


    @Test
    @DisplayName("Тест пустого конструктора")
    void testUserEmptyConstructor() {
        User user1 = new User();
        assertNull(user1.getLogin());
        assertNull(user1.getEmail());
    }

    @Test
    void checkCorrectMailTest() {
        assertDoesNotThrow(() -> new User(CORRECT_LOGIN, CORRECT_EMAIL));
    }


    @Test
    @DisplayName("Проверка неравности email и логина")
    void doesNotEqualsLoginAndEmail() {
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }



    @Test
    @DisplayName("Проверка email на корректность при просмотре")
    void testGetUserEmail() {
        Assertions.assertEquals("Ivan@mail.ru", user.getEmail());
    }


   @Test
   @DisplayName("Проверка логина на корректность при изменении")
    void testSetUserLogin() {
        assertThrows(IllegalArgumentException.class,
                () -> user.setLogin(INVALID_LOGIN)
        );
    }
    @Test
    @DisplayName("Проверка email на корректность при изменении")
    void testSetUserEmailCorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> user.setEmail(WRONG_EMAIL)
        );
    }
}



