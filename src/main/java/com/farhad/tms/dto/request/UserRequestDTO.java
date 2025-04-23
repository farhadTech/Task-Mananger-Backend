package com.farhad.tms.dto.request;

public record UserRequestDTO(
        Long id,
        String firstName,
        String lastName,
        String username,
        String email,
        String password,

        Long task_id
) {
}
