package learn.employee.team;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamServices teamServices;


    @PostMapping
    public ResponseEntity<TeamDto> addTeam(
            @RequestBody TeamDto teamDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teamServices.addTeam(teamDto));
    }



}
