/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainRouteControl;
import BUSDOMAIN.Route;
import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

public class ViewRoute extends JFrame {

    private JScrollPane jinfo;
    private JPanel jpinfo = new JPanel();

    public ViewRoute(String id) {
        MaintainRouteControl mrc = new MaintainRouteControl();
        Route route = mrc.selectRecord(id);
        jpinfo.add(new JLabel(route.toString()));
        jinfo = new JScrollPane(jpinfo);
        add(jinfo);
        jpinfo.setBackground(new Color(250, 250, 250));

        setTitle("GoToMalaysia - Route Information");
        setSize(520, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ViewRoute frame = new ViewRoute("BS0001");

    }

}
