package service;

import Repository.RecordingRepository;
import models.EmployeeTeam;
import models.Recording;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTeamServiceImpl implements EmployeeTeamService {

    private RecordingRepository recordingRepository;

    public EmployeeTeamServiceImpl(RecordingRepository recordingRepository) {
        this.recordingRepository = recordingRepository;
    }

    @Override
    public void addEmployeeRecordings(List<Recording> recordings) {
        this.recordingRepository.saveAll(recordings);
    }

    @Override
    public void addEmployeeRecording(Recording recording) {
        this.recordingRepository.save(recording);
    }

    @Override
    public List<EmployeeTeam> allTeamsThatWorkedTogether() {
        List<Recording> recordings = this.recordingRepository.getAll();

        List<EmployeeTeam> employeeTeams=new ArrayList<>();

        for (int i = 0; i < recordings.size()-1; i++) {

            for (int j = i+1; j <recordings.size() ; j++) {
                Recording recordingA=recordings.get(i);
                Recording recordingB=recordings.get(j);

                if(recordingA.getProjectID()==recordingB.getProjectID()
                        && workedTogether(recordingA,recordingB)
                        && !recordingA.getEmployeeID().equals(recordingB.getEmployeeID())){
                    long lengthOfWork= daysWorkedTogether(recordingA,recordingB);

                        update(employeeTeams,recordingA,recordingB,lengthOfWork);

                }



            }
        }

        return employeeTeams;
    }
    //finding if the pair has already worked together and adding the new days count / if not creating it
    private void update(List<EmployeeTeam> employeeTeams, Recording recordingA, Recording recordingB, long lengthOfWork) {

        boolean exist=false;

        for (EmployeeTeam t:employeeTeams) {

            if(exists(t,recordingA.getEmployeeID(),recordingB.getEmployeeID())){
                exist=true;
                t.setDurationOfProject(t.getDurationOfProject()+lengthOfWork);
            }

        }

        if(!exist){
            employeeTeams.add(new EmployeeTeam(recordingA.getEmployeeID(),recordingB.getEmployeeID(),lengthOfWork));
        }



    }
    //calculating how much they have worked together
    private long daysWorkedTogether(Recording recordingA, Recording recordingB) {

        LocalDate startedWorkingTogether;
        LocalDate stoppedWorkingTogether;

        if(recordingA.getStartDate().isBefore(recordingB.getStartDate())){
            startedWorkingTogether=recordingB.getStartDate();
        }else{
            startedWorkingTogether=recordingA.getStartDate();
        }

        if(recordingA.getEndDate().isBefore(recordingB.getEndDate())){
            stoppedWorkingTogether=recordingA.getEndDate();
        }else{
            stoppedWorkingTogether=recordingB.getEndDate();
        }


        return Math.abs(ChronoUnit.DAYS.between(startedWorkingTogether, stoppedWorkingTogether));
    }
    //checking if the employees have worked together (if the dates are the same)
    private boolean workedTogether(Recording firstRecording, Recording secondRecording){
        if(firstRecording.getStartDate().isBefore(secondRecording.getEndDate())||
                firstRecording.getStartDate().isEqual(secondRecording.getEndDate())
        && (firstRecording.getEndDate().isAfter(secondRecording.getStartDate())||
                        firstRecording.getEndDate().isEqual(secondRecording.getStartDate()))){
            return  true;
        }
        return false;
    }
    //checking if the team exists already
    public boolean exists(EmployeeTeam team,long firstEmployeeID,long secondEmployeeID){
        return (team.getFirstEmployeeID()==firstEmployeeID
                && team.getSecondEmployeeID()==secondEmployeeID
        ||(team.getSecondEmployeeID()==firstEmployeeID
                &&team.getFirstEmployeeID()==secondEmployeeID));
    }



}
