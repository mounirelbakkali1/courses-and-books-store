package com.pluralsight.dto;

import com.pluralsight.models.Role;

public record UserDTO(
        String username,
        String email,
        Role role
) {
}
