package learn.employee.employees;

import learn.employee.team.Team;
import learn.employee.team.TeamRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "Spring")
public interface EmployeeMapper {


    Employee toEmployee(EmployeeDto employeeDto);

    @Mapping(target = "team", source = "teamId")
    default Employee toEmployeeWithTeam(EmployeeDto dto, @Context TeamRepository repository){
        Employee employee = toEmployee(dto);

        if(dto.teamId()!=null){
            Team team = repository.findById(dto.teamId())
                    .orElseThrow(()-> new IllegalArgumentException("Team not found: "+dto.teamId()));
            employee.setTeam(team);
        }
        return employee;
    }

    @Mapping(target = "teamId", source = "team.id")
    EmployeeDto toEmployeeDto(Employee employee);
}
