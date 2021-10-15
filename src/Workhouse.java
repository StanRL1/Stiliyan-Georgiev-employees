import Config.FileInputCollector;
import Reader.RecordingReader;
import models.EmployeeTeam;
import models.Recording;
import service.EmployeeTeamService;

import java.util.ArrayList;
import java.util.List;

public class Workhouse implements Runnable {

    private final String FILE_PATH =".\\src\\resources\\employees.txt";

    private final EmployeeTeamService employeeTeamService;
    private final FileInputCollector fileInputCollector;

    public Workhouse(EmployeeTeamService employeeTeamService, FileInputCollector fileInputCollector) {
        this.employeeTeamService = employeeTeamService;
        this.fileInputCollector = fileInputCollector;
    }

    @Override
    public void run() {
        List<Recording> recordings=new ArrayList<>();
        System.out.println();
        List<String> lines=this.fileInputCollector.read(FILE_PATH);
        for (String str:lines) {
            Recording recording= RecordingReader.create(str);
            recordings.add(recording);
        }
        System.out.println();
        this.employeeTeamService.addEmployeeRecordings(recordings);


        List<EmployeeTeam> employeeTeams =
                employeeTeamService.allTeamsThatWorkedTogether();

        EmployeeTeam recordHolder;
        if(!employeeTeams.isEmpty()) {
            recordHolder = employeeTeams.get(0);

            for (EmployeeTeam e : employeeTeams) {
                if(recordHolder.getDurationOfProject()<e.getDurationOfProject()){
                    recordHolder=e;
                }
            }
            System.out.println("First employee id :" + recordHolder.getFirstEmployeeID()+" and second employee :"+recordHolder.getSecondEmployeeID()
                    +" worked together for "+recordHolder.getDurationOfProject()+" which is a company record !");

        }else{
            System.out.println("Somethings wrong");
        }


    }
}
