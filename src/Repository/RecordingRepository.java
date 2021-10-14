package Repository;

import models.Recording;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordingRepository {
    private List<Recording> recordings;

    public RecordingRepository() {
        this.recordings = new ArrayList<>();
    }

    public void saveAll(List<Recording> recordings){
        this.recordings.addAll(recordings);
    }

    public void save(Recording recording){
        this.recordings.add(recording);
    }

    public List<Recording> getAll(){
        return recordings;
    }

}
