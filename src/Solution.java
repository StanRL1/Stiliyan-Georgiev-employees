import Config.FileInputCollector;
import Config.FileInputCollectorImpl;
import Repository.RecordingRepository;
import service.EmployeeTeamService;
import service.EmployeeTeamServiceImpl;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        FileInputCollector fileIO = new FileInputCollectorImpl();
        RecordingRepository repo = new RecordingRepository();
        EmployeeTeamService service = new EmployeeTeamServiceImpl(repo);

        Workhouse engine = new Workhouse(service, fileIO);
        engine.run();
    }



}
