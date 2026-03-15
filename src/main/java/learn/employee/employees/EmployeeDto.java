package learn.employee.employees;

import jakarta.validation.constraints.NotEmpty;

public record EmployeeDto(
        @NotEmpty(message = "name can't be empty")
        String name,
        Long teamId
) {
}
