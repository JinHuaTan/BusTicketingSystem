package BUSCONTROL;

import BUSDA.PaymenttypeDA;
import BUSDOMAIN.Paymenttype;
import java.io.IOException;
import java.sql.SQLException;

public class MaintainPaymenttypeControl {

    private PaymenttypeDA paymenttypeDA;

    public MaintainPaymenttypeControl() {
        paymenttypeDA = new PaymenttypeDA();
    }

    public Paymenttype selectRecord(String id) {
        return paymenttypeDA.getRecord(id);
    }
    public Paymenttype selectRecordbyPayment(String id) {
        return paymenttypeDA.getRecordbyPayment(id);
    }

    public void addRecord(Paymenttype s) {
        paymenttypeDA.addRecord(s);
    }

    public void deleteRecord(Paymenttype s) {
        paymenttypeDA.deleteRecord(s);
    }

    public void updateRecord(Paymenttype s) throws SQLException, IOException {
        paymenttypeDA.updateRecord(s);
    }
}
