package com.example.xportfolio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {
    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),

    // Writer :
    WRITER_NOT_FOUND(5, HttpStatus.NOT_FOUND, "writer.not.found"),
    // About
    ABOUT_NOT_FOUND(5, HttpStatus.NOT_FOUND, "about.not.found"),
    // SKILLS
    SKILLS_NOT_FOUND(5, HttpStatus.NOT_FOUND, "skills.not.found"),
    // ADDRESS
    ADDRESS_NOT_FOUND(5, HttpStatus.NOT_FOUND, "address.not.found"),
    // CONTACT
    CONTACT_NOT_FOUND(5, HttpStatus.NOT_FOUND, "contact.not.found"),
    // FORMATION
    FORMATION_NOT_FOUND(5, HttpStatus.NOT_FOUND, "formation.not.found"),
    // LANGUAGE
    LANGUAGE_NOT_FOUND(5, HttpStatus.NOT_FOUND, "language.not.found");


    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
