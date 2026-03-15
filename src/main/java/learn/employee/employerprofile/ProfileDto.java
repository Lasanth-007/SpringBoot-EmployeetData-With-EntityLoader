package learn.employee.employerprofile;

import jakarta.validation.constraints.*;

public record ProfileDto(
        @NotEmpty(message = "first name can't be empty")
        String firstName,
        @NotEmpty(message = "last name can't be empty")
        String lastName,
        @Positive(message = "age can't be negative")
        @Min(value = 16,message = "age should be minimum 16")
        int age,
        @Email(message = "email formate is not valid")
        String email,
        String bio,
        Long employeeId

) {
}
