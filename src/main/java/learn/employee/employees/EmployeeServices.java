package learn.employee.employees;

import learn.employee.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final TeamRepository teamRepository;

    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        Employee employee = employeeMapper.toEmployeeWithTeam(employeeDto,teamRepository);
        System.out.println(" begin name is: "+employee.getName());
        Employee savedEmployee = employeeRepository.save(employee);
        System.out.println(" saved name is: "+savedEmployee.getName());
        return employeeMapper.toEmployeeDto(savedEmployee);

    }

    public void deleteEmployeeByID(Long id){
        employeeRepository.deleteById(id);
    }
}
