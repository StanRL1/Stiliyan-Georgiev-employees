package Reader;

import models.Recording;

import java.time.LocalDate;

public class RecordingReader {

    public static Recording create(String info){

        String[] args=info.split(", ");

        Long id = Long.parseLong(args[0]);
        int projectID=Integer.parseInt(args[1]);
        LocalDate startDate= LocalDate.parse(args[2]);
        LocalDate endDate;
        if(args[3].equals("NULL")){
            endDate= LocalDate.now();
        }else{
            endDate = LocalDate.parse(args[3]);
        }

        return new Recording(id,projectID,startDate,endDate);
    }


}
