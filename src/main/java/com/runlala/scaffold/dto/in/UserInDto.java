package com.runlala.scaffold.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserInDto {
    @Size(min = 3, max = 20, message = "name length must be between 3 and 20")
    private String name;

    @Email(message = "email format is not correct")
    private String email;

    @Size(min = 6, max = 20)
    private String password;
}