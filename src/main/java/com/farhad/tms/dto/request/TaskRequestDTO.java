package com.farhad.tms.dto.request;

import com.farhad.tms.model.status;

import java.io.Serializable;
import java.time.LocalDateTime;

public record TaskRequestDTO(
        Long id,
        String title,
        status taskStatus,
        LocalDateTime startTime,
        LocalDateTime endTime,

        Long user_id
) implements Serializable {
}
