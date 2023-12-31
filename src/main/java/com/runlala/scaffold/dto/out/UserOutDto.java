package com.runlala.scaffold.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class UserOutDto {
    Long id;
    String username;
    String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String updatedAt;
}