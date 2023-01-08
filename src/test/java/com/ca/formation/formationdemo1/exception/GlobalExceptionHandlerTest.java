package com.ca.formation.formationdemo1.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void globalExceptionHandler() {
        WebRequest request = mock(WebRequest.class);
        ResourceNotFoundException exception = mock(ResourceNotFoundException.class);

        ResponseEntity<ErrorResponse> response =
                globalExceptionHandler.globalExceptionHandler(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }



    @Test
    void resourceNotFoundException() {
        String message = "Resource not found";
        WebRequest request = mock(WebRequest.class);
        ResourceNotFoundException resourceNotFoundException =
                new ResourceNotFoundException(message);

        ResponseEntity<ErrorResponse> responseEntity =
                globalExceptionHandler.resourceNotFoundException(
                        resourceNotFoundException, request);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(responseEntity.getBody().getMessage(), message);
    }
}