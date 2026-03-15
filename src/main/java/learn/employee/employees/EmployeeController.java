package learn.employee.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(
            @RequestBody EmployeeDto employeeDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeServices.addEmployee(employeeDto));
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeByID(
            @PathVariable("id") Long empId
    ){
      employeeServices.deleteEmployeeByID(empId);
      ResponseEntity.status(HttpStatus.GONE).build();
    }

}
