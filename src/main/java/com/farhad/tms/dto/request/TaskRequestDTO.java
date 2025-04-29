package com.farhad.tms.dto.request;

import com.farhad.tms.model.status;

import java.io.Serializable;
import java.time.LocalDateTime;

public record TaskRequestDTO(
        String title,
        status taskStatus,
        LocalDateTime startTime,
        LocalDateTime endTime,

        Long userId
) implements Serializable {
}
