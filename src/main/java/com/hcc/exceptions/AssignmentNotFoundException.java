package com.hcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AssignmentNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AssignmentNotFoundException(String noAssignmentFound) {
        super(noAssignmentFound);
    }
}