package learn.employee.team;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team toTeam(TeamDto teamDto);
    TeamDto toTeamDto(Team team);
}
