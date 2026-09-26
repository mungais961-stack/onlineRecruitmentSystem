package com.mungai.dev.onlineRecruitmentSystem.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
 private final UUID employee_id;
    public UUID getId() {
        return employee_id;
    }
    public UserNotFoundException(UUID employee_id) {

        this.employee_id = employee_id;
        super(String.format("User with id %s not found", employee_id));
    }
}
