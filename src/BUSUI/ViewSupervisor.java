/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainStaffControl;
import BUSDOMAIN.Staff;
import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

public class ViewSupervisor extends JFrame {

    private JScrollPane jinfo;
    private JPanel jpinfo = new JPanel();

    public ViewSupervisor(String id) {
        MaintainStaffControl msc = new MaintainStaffControl();
        Staff staff = msc.selectRecord(id);
        jpinfo.add(new JLabel(staff.toString()));
        jinfo = new JScrollPane(jpinfo);
        add(jinfo);
        jpinfo.setBackground(new Color(250, 250, 250));

        setTitle("GoToMalaysia - Staff Information");
        setSize(520, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ViewSupervisor frame = new ViewSupervisor("S00001");

    }

}
