package com.example;

import com.example.model.User;
import com.example.service.RegistrationService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RegistrationServiceTest {
    @Test
    public void testRegisterUser() {
        RegistrationService registrationService = new RegistrationService();
        User user = new User("Test User", "Test Country");

        assertDoesNotThrow(() -> registrationService.registerUser(user));
    }
}
