package learn.employee.employerprofile;

import learn.employee.employees.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServices {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final EmployeeRepository employeeRepository;


    public ProfileDto addProfile(ProfileDto profileDto){
         Profile profile = profileRepository.save(profileMapper.toProfileWithEmployee(profileDto,employeeRepository));
         return profileMapper.toProfileDto(profile);
    }

    public List<ProfileDto> getAllProfiles(){
        return profileMapper.toDtoList(profileRepository.findAll());
    }

    public void deleteById(Long id){
        profileRepository.deleteById(id);
    }
}
