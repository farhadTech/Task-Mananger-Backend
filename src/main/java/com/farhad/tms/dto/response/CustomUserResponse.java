package com.farhad.tms.dto.response;

import com.farhad.tms.model.status;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomUserResponse {
    Long getId();
    String getFirstName();
    String getLastName();
    String getUsername();
    String getEmail();
    String getPassword();

    List<TaskInfo> getTask();

    interface TaskInfo {
        Long getId();
        String getTitle();
        status getTaskStatus();
        LocalDateTime getStartTime();
        LocalDateTime getEndTime();
    }
}
