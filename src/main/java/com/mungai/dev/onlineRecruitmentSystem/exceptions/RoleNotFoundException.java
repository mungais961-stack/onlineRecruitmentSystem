package com.mungai.dev.onlineRecruitmentSystem.exceptions;

import java.util.UUID;

public class RoleNotFoundException extends RuntimeException {
    private final UUID role_Id;

    public UUID getRole_Id() {
        return role_Id;
    }
    public RoleNotFoundException(UUID role_Id) {
        this.role_Id = role_Id;
        super(String.format("Role with id %s not found", role_Id));
    }
}
