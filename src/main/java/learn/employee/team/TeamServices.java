package learn.employee.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServices {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamDto addTeam(TeamDto teamDto){
        Team savedteam = teamRepository.save(teamMapper.toTeam(teamDto));
        return teamMapper.toTeamDto(savedteam);
    }

    public List<TeamDto> GetTeams(){
        return teamMapper.toTeamDtoList(teamRepository.findAll());
    }
}
