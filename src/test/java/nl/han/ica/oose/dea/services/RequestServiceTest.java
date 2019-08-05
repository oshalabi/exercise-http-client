package nl.han.ica.oose.dea.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RequestServiceTest {

    private static final String README_START_STRING = "<!--- 37 --->";
    private RequestService requestService;

    @BeforeEach
    void setup() {
        this.requestService = new RequestService();
    }

    @Test
    void getReadmeReturnsTheCorrectReadme() {
        // Arrange

        // Act
        String readme = requestService.getReadme();

        // Assert
        Assertions.assertTrue(readme.startsWith(README_START_STRING));
    }
}
