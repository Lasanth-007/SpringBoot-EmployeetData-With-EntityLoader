package learn.employee.employerprofile;

import learn.employee.employees.Employee;
import learn.employee.employees.EmployeeRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper{

    public Profile toProfile (ProfileDto profileDto);

    @Mapping(source = "employeeId", target = "employee")
    default Profile toProfileWithEmployee(ProfileDto profileDto, @Context EmployeeRepository repository){
        Profile profile = toProfile(profileDto);
        System.out.println("first pass: "+profileDto.employeeId());

        if(profileDto.employeeId()!=null){
            Employee employee = repository.findById(profileDto.employeeId())
                    .orElseThrow(()->new IllegalArgumentException("Employee id not found"+profileDto.employeeId()));
            profile.setEmployee(employee);
        }
        return profile;
    }

    @Mapping(source = "employee.id", target = "employeeId")
    public ProfileDto toProfileDto(Profile profile);

    @Mapping(source = "employee.Id",target = "employeeId")
    public List<ProfileDto> toDtoList(List<Profile> profiles);
}
