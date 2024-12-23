package com.anto.learning.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO model information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "First Name"
    )
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    @Schema(
            description = "Last Name"
    )
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;


}