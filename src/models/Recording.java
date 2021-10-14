package models;

import java.time.LocalDate;

public class Recording {

    private long employeeID;
    private int projectID;
    private LocalDate startDate;
    private LocalDate endDate;

    public Recording(Long employeeID, int projectID, LocalDate startDate, LocalDate endDate) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
