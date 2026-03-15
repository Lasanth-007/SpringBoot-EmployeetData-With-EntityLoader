package learn.employee.employerprofile;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileServices profileServices;


    @PostMapping
    public ResponseEntity<ProfileDto> addProfile(
            @RequestBody ProfileDto profileDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileServices.addProfile(profileDto));
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        return ResponseEntity.ok(profileServices.getAllProfiles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(
            @PathVariable Long id
    ){
        profileServices.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();

    }
}
