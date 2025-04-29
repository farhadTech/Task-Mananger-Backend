package com.farhad.tms.dto.request;

import java.util.Set;

public record UserRequestDTO(
        String firstName,
        String lastName,
        String username,
        String email,
        String password,

        
        Set<Long> taskIds
) {
}
