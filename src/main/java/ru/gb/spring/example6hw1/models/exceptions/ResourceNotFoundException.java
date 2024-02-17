package ru.gb.spring.example6hw1.models.exceptions;

/**
 * Исключение при отсутствии данных в БД.
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
