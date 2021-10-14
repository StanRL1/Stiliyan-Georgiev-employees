package models;

public class EmployeeTeam {

    private long firstEmployeeID;
    private long secondEmployeeID;
    private long durationOfProject;

    public EmployeeTeam(Long firstEmployeeID, Long secondEmployeeID, long durationOfProject) {
        this.firstEmployeeID = firstEmployeeID;
        this.secondEmployeeID = secondEmployeeID;
        this.durationOfProject = durationOfProject;
    }

    public Long getFirstEmployeeID() {
        return firstEmployeeID;
    }

    public void setFirstEmployeeID(Long firstEmployeeID) {
        this.firstEmployeeID = firstEmployeeID;
    }

    public Long getSecondEmployeeID() {
        return secondEmployeeID;
    }

    public void setSecondEmployeeID(Long secondEmployeeID) {
        this.secondEmployeeID = secondEmployeeID;
    }

    public long getDurationOfProject() {
        return durationOfProject;
    }

    public void setDurationOfProject(long durationOfProject) {
        this.durationOfProject = durationOfProject;
    }
}
