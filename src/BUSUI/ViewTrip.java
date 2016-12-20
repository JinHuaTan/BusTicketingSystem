/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainTripControl;
import BUSDOMAIN.Trip;
import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

public class ViewTrip extends JFrame {

    private JScrollPane jinfo;
    private JPanel jpinfo = new JPanel();

    public ViewTrip(String id) {
        MaintainTripControl mrc = new MaintainTripControl();
        Trip trip = mrc.selectRecord(id);
        jpinfo.add(new JLabel(trip.toString()));
        jinfo = new JScrollPane(jpinfo);
        add(jinfo);
        jpinfo.setBackground(new Color(250, 250, 250));

        setTitle("GoToMalaysia - Trip Information");
        setSize(520, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ViewTrip frame = new ViewTrip("BS0001");

    }

}
