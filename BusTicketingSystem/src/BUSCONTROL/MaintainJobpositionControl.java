package BUSCONTROL;

import BUSDA.JobpositionDA;
import BUSDOMAIN.Jobposition;
import java.io.IOException;
import java.sql.SQLException;

public class MaintainJobpositionControl {

    private JobpositionDA jobpositionDA;

    public MaintainJobpositionControl() {
        jobpositionDA = new JobpositionDA();
    }

    public Jobposition selectRecord(String id) {
        return jobpositionDA.getRecord(id);
    }
    public Jobposition selectRecordbyJob(String id) {
        return jobpositionDA.getRecordbyJob(id);
    }
    public void addRecord(Jobposition s) {
        jobpositionDA.addRecord(s);
    }

    public void deleteRecord(Jobposition s) {
        jobpositionDA.deleteRecord(s);
    }

    public void updateRecord(Jobposition s) throws SQLException, IOException {
        jobpositionDA.updateRecord(s);
    }
}
