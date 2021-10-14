package service;

import models.EmployeeTeam;
import models.Recording;

import java.util.List;

public interface EmployeeTeamService {

    void addEmployeeRecordings(List<Recording> recordings);

    void addEmployeeRecording(Recording recording);

    List<EmployeeTeam> allTeamsThatWorkedTogether();

}
