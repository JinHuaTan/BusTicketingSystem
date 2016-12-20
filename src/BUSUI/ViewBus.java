/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainBusControl;
import BUSDOMAIN.Bus;
import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

public class ViewBus extends JFrame {

    private JScrollPane jinfo;
    private JPanel jpinfo = new JPanel();

    public ViewBus(String id) {
        MaintainBusControl mbc = new MaintainBusControl();
        Bus bus = mbc.selectRecord(id);
        jpinfo.add(new JLabel(bus.toString()));
        jinfo = new JScrollPane(jpinfo);
        add(jinfo);
        jpinfo.setBackground(new Color(250, 250, 250));

        setTitle("GoToMalaysia - Bus Information");
        setSize(520, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ViewBus frame = new ViewBus("BS0001");

    }

}
