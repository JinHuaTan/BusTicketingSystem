/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainBusControl;
import BUSCONTROL.MaintainDriverlistControl;
import BUSCONTROL.MaintainRouteControl;
import BUSCONTROL.MaintainTicketControl;
import BUSCONTROL.MaintainTripControl;
import BUSDOMAIN.Bus;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Driverlist;
import BUSDOMAIN.Route;
import BUSDOMAIN.Staff;
import BUSDOMAIN.Trip;
import static BUSUI.CRUDRoute.createImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CRUDTrip extends JFrame {

    private JPanel jpContentHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));//header
    private JPanel jpContentCenter = new JPanel(new BorderLayout(30, 30));//content
    private JPanel jpLeft;//form
    private JPanel jpRight;//form
    private JPanel jpTable;
    private JPanel jpContent;
    private JScrollPane JSPane;
    private JPanel jpBg = new JPanel(new BorderLayout());

    private ArrayList<Trip> tripInPanel;
    private MaintainTripControl mtc;
    private MaintainBusControl mbc;
    private MaintainRouteControl mrc;
    private MaintainDriverlistControl mdvc;
    private MaintainTicketControl mtcc;
    private NumberFormat percentFormat;
    private JButton jbtLeft = new JButton("<");
    private JButton jbtRight = new JButton(">");
    private JComboBox[] comboBox = new JComboBox[16];
    private JButton[] jbtExtra = new JButton[4];
    private JFormattedTextField jtfFare = new JFormattedTextField();
    private DefaultComboBoxModel tripModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel ddayModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dmonthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dyearModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dhour = new DefaultComboBoxModel();
    private DefaultComboBoxModel dminute = new DefaultComboBoxModel();
    private DefaultComboBoxModel dampm = new DefaultComboBoxModel();
    private DefaultComboBoxModel adayModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel amonthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel ayearModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel ahour = new DefaultComboBoxModel();
    private DefaultComboBoxModel aminute = new DefaultComboBoxModel();
    private DefaultComboBoxModel aampm = new DefaultComboBoxModel();
    private DefaultComboBoxModel busModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel routeModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel driverlistModel = new DefaultComboBoxModel();
    private Image imgBg;
    private String departDate = "";
    private String arrDate = "";

    public CRUDTrip(Counter ds, Staff s) {
        mtc = new MaintainTripControl();
        mbc = new MaintainBusControl();
        mrc = new MaintainRouteControl();
        mdvc = new MaintainDriverlistControl();
        mtcc = new MaintainTicketControl();
        tripInPanel = mtc.getAllRecord();

        design();
        crudField();

        try {
            imgBg = ImageIO.read(this.getClass().getResource("../images/background/bg54.jpg"));;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Background image of CRUDTrip  cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        jpContent = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                Graphics2D g2 = (Graphics2D) g;
                g2.fill(new Rectangle(0, 0, d.width, d.height));
                g.drawImage(imgBg, 0, 0, d.width, d.height, null);
            }
        };
        jpContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jpContent.add(jpContentHeader, BorderLayout.NORTH);
        jpContent.add(jpContentCenter, BorderLayout.CENTER);
        designPanel(ds, s);
        add(jpBg);

        setTitle("GoToMalaysia - CRUD of Trip");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void design() {
        jpContentHeader.setPreferredSize(new Dimension(getWidth(), 50));
        ImageIcon icon = createImageIcon("../images/CRUD/trip.png", 30, 30);
        JButton jlHeader = new JButton(" Manage Trip", icon);
        jlHeader.setBackground(new Color(0, 0, 0, 0));
        jlHeader.setOpaque(false);
        jlHeader.setBorder(null);
        jlHeader.setAlignmentX(LEFT_ALIGNMENT);
        jlHeader.setFont(new Font("Arial", Font.BOLD, 32));
        jlHeader.setForeground(Color.WHITE);
        jpContentHeader.add(jlHeader);

        jpContentHeader.setBackground(new Color(0, 0, 0, 0));
        jpContentHeader.setOpaque(false);
        jpContentHeader.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        jpContentCenter.setBackground(new Color(0, 0, 0, 0));
        jpContentCenter.setOpaque(false);
        jpContentCenter.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        jpLeft = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(50, 50);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.WHITE);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border}
            }
        };
        jpLeft.setOpaque(false);
        jpLeft.setBackground(new Color(0, 0, 0, 0));
        jpLeft.setBorder(BorderFactory.createEmptyBorder(10, 20, 25, 20));

        JPanel jpHeaNorth = new JPanel();
        jpHeaNorth.setBackground(new Color(0, 0, 0, 0));
        jpHeaNorth.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jpHeaNorth.setLayout(new BoxLayout(jpHeaNorth, BoxLayout.X_AXIS));
        DefaultComboBoxModel chooseModel = new DefaultComboBoxModel();
        ArrayList<String> columnName = mtc.getAllColumnName();
        for (String l : columnName) {
            chooseModel.addElement(l);
        }
        JComboBox comboBox = new JComboBox(chooseModel);
        comboBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(comboBox);
        JTextField jtfSearch = new JTextField();
        jtfSearch.setUI(new PlaceholderUI("Press Enter To Search", true));
        jtfSearch.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(jtfSearch);
        jtfSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tripInPanel = mtc.searchRecordByColumn((String) comboBox.getSelectedItem(), jtfSearch.getText());
                CreateButtonsInPanel(tripInPanel);
            }
        });
        ImageIcon imgClearT = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgClearT);
        jbtClear.setBackground(Color.BLUE);
        jbtClear.setForeground(Color.WHITE);
        jpHeaNorth.add(jbtClear);
        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mtc = new MaintainTripControl();
                tripInPanel = mtc.getAllRecord();
                CreateButtonsInPanel(tripInPanel);
                jtfSearch.setText("");
            }
        });

        jpTable = new JPanel();
        jpTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpTable.setBackground(Color.WHITE);
        CreateButtonsInPanel(tripInPanel);
        JScrollPane jsPane = new JScrollPane(jpTable);
        jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jpLeft.add(jpHeaNorth, BorderLayout.NORTH);
        jpLeft.add(jsPane, BorderLayout.CENTER);

        jpRight = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(50, 50);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.WHITE);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border}
            }
        };
        jpRight.setOpaque(false);
        jpRight.setBackground(new Color(0, 0, 0, 0));
        jpRight.setBorder(BorderFactory.createEmptyBorder(30, 20, 25, 20));
        jpRight.setPreferredSize(new Dimension(700, getHeight()));
        jpContentCenter.add(jpLeft, BorderLayout.CENTER);
        jpContentCenter.add(jpRight, BorderLayout.EAST);
    }

    public void crudField() {
        percentFormat = NumberFormat.getNumberInstance();
        percentFormat.setMinimumFractionDigits(2);

        JPanel jpInfo = new JPanel(new SpringLayout());
        jpInfo.setBackground(new Color(0, 0, 0, 0));
        jpInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JPanel jpButtons = new JPanel(new GridLayout(1, 6, 5, 5));
        jpButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jpButtons.setBackground(new Color(0, 0, 0, 0));
        jpButtons.setPreferredSize(new Dimension(getWidth(), 60));

        JLabel[] jlSide = new JLabel[7];
        JButton jbtAdd = new JButton("Add/ Update");
        ImageIcon imgRetrieve = createImageIcon("../images/crud/search.png", 18, 18);
        JButton jbtRetrieve = new JButton(imgRetrieve);
        ImageIcon imgDelete = createImageIcon("../images/crud/delete.png", 18, 18);
        JButton jbtDelete = new JButton(imgDelete);
        ImageIcon imgRefresh = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgRefresh);

        jtfFare.setPreferredSize(new Dimension(150, 40));
        jtfFare.setFont(new Font("Arial", Font.PLAIN, 15));
        jbtLeft.setBackground(new Color(142, 68, 173));
        jbtLeft.setForeground(Color.WHITE);
        jbtRight.setBackground(new Color(142, 68, 173));
        jbtRight.setForeground(Color.WHITE);
        jbtRetrieve.setBackground(new Color(46, 204, 113));
        jbtRetrieve.setForeground(Color.WHITE);
        jbtAdd.setBackground(new Color(72, 133, 237));
        jbtAdd.setForeground(Color.WHITE);
        jbtDelete.setBackground(new Color(219, 50, 54));
        jbtDelete.setForeground(Color.WHITE);
        jbtClear.setBackground(new Color(244, 115, 33));
        jbtClear.setForeground(Color.WHITE);

        for (int i = 0; i < mtc.getAllRecord().size(); i++) {
            tripModel.addElement(mtc.getAllRecord().get(i).getTripid());
        }

        for (int i = 0; i < mbc.getAllRecord().size(); i++) {
            busModel.addElement(mbc.getAllRecord().get(i).getBusid());
        }
        for (int i = 0; i < mrc.getAllRecord().size(); i++) {
            routeModel.addElement(mrc.getAllRecord().get(i).getRouteid());
        }

        driverlistModel.addElement("Haven't Decided yet");
        for (int i = 0; i < mdvc.getAllRecord().size(); i++) {
            driverlistModel.addElement(mdvc.getAllRecord().get(i).getDriid());
        }

        for (int i = 1; i <= 31; i++) {
            adayModel.addElement(String.format("%02d", i) + "");
            ddayModel.addElement(String.format("%02d", i) + "");
        }

        for (int i = 1; i <= 12; i++) {
            amonthModel.addElement(String.format("%02d", i) + "");
            dmonthModel.addElement(String.format("%02d", i) + "");
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = year; i <= year + 5; i++) {
            ayearModel.addElement(String.format("%04d", i) + "");
            dyearModel.addElement(String.format("%04d", i) + "");
        }

        for (int i = 1; i <= 12; i++) {
            ahour.addElement(String.format("%02d", i) + "");
            dhour.addElement(String.format("%02d", i) + "");
        }

        for (int i = 0; i <= 59; i++) {
            aminute.addElement(String.format("%02d", i) + "");
            dminute.addElement(String.format("%02d", i) + "");
        }

        aampm.addElement("AM");
        aampm.addElement("PM");
        dampm.addElement("AM");
        dampm.addElement("PM");

        jlSide[0] = new JLabel("TripID", JLabel.TRAILING);
        jpInfo.add(jlSide[0]);
        JPanel jp = new JPanel(new BorderLayout());
        jlSide[0].setLabelFor(jp);
        comboBox[0] = new JComboBox(tripModel);
        jp.add(comboBox[0], BorderLayout.CENTER);
        jbtExtra[0] = new JButton(" Add ");
        jp.add(jbtExtra[0], BorderLayout.EAST);
        jpInfo.add(jp);
        jbtExtra[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTripID = JOptionPane.showInputDialog("Enter new tripID that starts with R and follows by 5 digits:\n (The ID will be deleted if this trip is not added to database)");
                Pattern p = Pattern.compile("^[tT][rR][0-9]{4}$");
                Matcher m = p.matcher(newTripID);
                while (!m.find()) {
                    newTripID = "";
                    String nTripID;
                    nTripID = JOptionPane.showInputDialog("Please enter new tripID that starts with R and follows by 5 digits:");
                    if (nTripID == null) {
                        break;
                    } else {
                        newTripID = nTripID;
                        m = p.matcher(newTripID);
                    }
                }
                if (!newTripID.equals("")) {
                    tripModel.addElement(newTripID.toUpperCase());
                    comboBox[0].setSelectedItem(newTripID.toUpperCase());
                }
            }
        });

        jlSide[1] = new JLabel("Depart Date & Time", JLabel.TRAILING);
        jpInfo.add(jlSide[1]);
        JPanel jp1 = new JPanel(new GridLayout(1, 6));
        jlSide[1].setLabelFor(jp1);
        comboBox[1] = new JComboBox(ddayModel);
        jp1.add(comboBox[1]);
        comboBox[2] = new JComboBox(dmonthModel);
        jp1.add(comboBox[2]);
        comboBox[3] = new JComboBox(dyearModel);
        jp1.add(comboBox[3]);
        comboBox[4] = new JComboBox(dhour);
        jp1.add(comboBox[4]);
        comboBox[5] = new JComboBox(dminute);
        jp1.add(comboBox[5]);
        comboBox[6] = new JComboBox(dampm);
        jp1.add(comboBox[6]);
        jpInfo.add(jp1);

        jlSide[2] = new JLabel("Arrival Date & Time", JLabel.TRAILING);
        jpInfo.add(jlSide[2]);
        JPanel jp2 = new JPanel(new GridLayout(1, 6));
        jlSide[2].setLabelFor(jp2);
        comboBox[7] = new JComboBox(adayModel);
        jp2.add(comboBox[7]);
        comboBox[8] = new JComboBox(amonthModel);
        jp2.add(comboBox[8]);
        comboBox[9] = new JComboBox(ayearModel);
        jp2.add(comboBox[9]);
        comboBox[10] = new JComboBox(ahour);
        jp2.add(comboBox[10]);
        comboBox[11] = new JComboBox(aminute);
        jp2.add(comboBox[11]);
        comboBox[12] = new JComboBox(aampm);
        jp2.add(comboBox[12]);
        jpInfo.add(jp2);

        jlSide[3] = new JLabel("Fare Per Ticket", JLabel.TRAILING);
        jpInfo.add(jlSide[3]);
        jlSide[3].setLabelFor(jtfFare);
        jpInfo.add(jtfFare);

        jlSide[4] = new JLabel("Bus ID", JLabel.TRAILING);
        jpInfo.add(jlSide[4]);
        JPanel jp3 = new JPanel(new BorderLayout());
        jlSide[4].setLabelFor(jp3);
        comboBox[13] = new JComboBox(busModel);
        jp3.add(comboBox[13], BorderLayout.CENTER);
        jbtExtra[1] = new JButton("View");
        jp3.add(jbtExtra[1], BorderLayout.EAST);
        jpInfo.add(jp3);
        jbtExtra[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBus frame = new ViewBus(comboBox[13].getSelectedItem().toString());
            }
        });

        jlSide[5] = new JLabel("Route ID", JLabel.TRAILING);
        jpInfo.add(jlSide[5]);
        JPanel jp4 = new JPanel(new BorderLayout());
        jlSide[5].setLabelFor(jp4);
        comboBox[14] = new JComboBox(routeModel);
        jp4.add(comboBox[14], BorderLayout.CENTER);
        jbtExtra[2] = new JButton("View");
        jp4.add(jbtExtra[2], BorderLayout.EAST);
        jpInfo.add(jp4);
        jbtExtra[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRoute frame = new ViewRoute(comboBox[14].getSelectedItem().toString());
            }
        });
        jlSide[6] = new JLabel("Driver ID", JLabel.TRAILING);
        jpInfo.add(jlSide[6]);
        JPanel jp5 = new JPanel(new BorderLayout());
        jlSide[6].setLabelFor(jp5);
        comboBox[15] = new JComboBox(driverlistModel);
        jp5.add(comboBox[15], BorderLayout.CENTER);
        jbtExtra[3] = new JButton("View");
        jp5.add(jbtExtra[3], BorderLayout.EAST);
        jpInfo.add(jp5);
        jbtExtra[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox[15].getSelectedIndex() != 0) {
                    Driverlist d = mdvc.selectRecord(comboBox[15].getSelectedItem().toString());
                    ViewSupervisor frame = new ViewSupervisor(d.getDriverid().getStaffid());
                } else {
                    JOptionPane.showMessageDialog(null, "Driver has not been selected.");
                }
            }
        });

        for (int l = 0; l < 7; l++) {
            jlSide[l].setFont(new Font("Arial", Font.BOLD, 17));
            jlSide[l].setForeground(Color.WHITE);

        }

        for (int l = 0; l < 4; l++) {
            jbtExtra[l].setForeground(Color.WHITE);
            jbtExtra[l].setBackground(new Color(60, 186, 84));
        }

        SpringUtilities.makeCompactGrid(jpInfo,
                7, 2, //rows, cols
                2, 2, //initX, initY
                5, 5);       //xPad, yrgb(46, 204, 113)Pad

        jpButtons.add(jbtLeft);
        jpButtons.add(jbtAdd);
        jpButtons.add(jbtRetrieve);
        jpButtons.add(jbtDelete);
        jpButtons.add(jbtClear);
        jpButtons.add(jbtRight);

        ButtonListener listener = new ButtonListener();
        jbtLeft.addActionListener(listener);
        jbtRight.addActionListener(listener);

        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tripid = comboBox[0].getSelectedItem().toString();
                departDate = comboBox[1].getSelectedItem().toString() + "-" + comboBox[2].getSelectedItem().toString()
                        + "-" + comboBox[3].getSelectedItem().toString() + " " + comboBox[4].getSelectedItem().toString()
                        + ":" + comboBox[5].getSelectedItem().toString()
                        + " " + comboBox[6].getSelectedItem().toString();
                arrDate = comboBox[7].getSelectedItem().toString() + "-" + comboBox[8].getSelectedItem().toString()
                        + "-" + comboBox[9].getSelectedItem().toString() + " " + comboBox[10].getSelectedItem().toString()
                        + ":" + comboBox[11].getSelectedItem().toString()
                        + " " + comboBox[12].getSelectedItem().toString();
                String busid = comboBox[13].getSelectedItem().toString();
                String routeid = comboBox[14].getSelectedItem().toString();
                String driid = comboBox[15].getSelectedItem().toString();

                Bus bus = mbc.selectRecord(busid);
                Route r = mrc.selectRecord(routeid);
                Driverlist s;
                if (driid.equals("Haven't Decided yet")) {
                    s = null;
                } else {
                    s = mdvc.selectRecord(comboBox[15].getSelectedItem().toString());
                }
                Double farePerTicket;
                try {
                    farePerTicket = Double.parseDouble(jtfFare.getText());
                } catch (Exception ex) {
                    farePerTicket = 0.00;
                }
                if (farePerTicket == 0.00) {
                    JOptionPane.showMessageDialog(null, "Please fill in the fare per ticket.", "Error in CRUD Trip", JOptionPane.ERROR_MESSAGE);

                } else {
                    Trip trip = mtc.selectRecord(tripid);
                    if (trip != null) {
                        try {
                            if (!trip.getBusid().equals(bus)) {
                                mtcc.deleteBunchTickets(trip);
                                mtcc.createBunchTickets(trip);
                            }
                            trip.setDepartdate(departDate);
                            trip.setArrivaldate(arrDate);
                            trip.setFareperticket(farePerTicket);
                            trip.setBusid(bus);
                            trip.setRouteid(r);
                            trip.setDriverlistid(s);
                            mtc.updateRecord(trip);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "update listener Error: " + ex.getMessage(), "Error in CRUD Trip", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        try {
                            trip = new Trip(tripid, departDate, arrDate, farePerTicket, bus, r, s);
                            mtc.addRecord(trip);
                            mtcc.createBunchTickets(trip);
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(null, "add listener Error: " + exc.getMessage(), "Error in CRUD Trip", JOptionPane.ERROR_MESSAGE);
                        }
                        trip = mtc.selectRecord(tripid);
                        if (trip != null) {
                            JOptionPane.showMessageDialog(null, tripid + " is inserted Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        jbtRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = ((String) comboBox[0].getSelectedItem()).toUpperCase();
                clear();
                retrieveTrip(mtc.selectRecord(ID));
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = comboBox[0].getSelectedItem().toString();
                Trip c = mtc.selectRecord(id);
                if (c != null) {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        mtcc.deleteBunchTickets(c);
                        mtc.deleteRecord(c);
                        clear();
                        JOptionPane.showMessageDialog(null, id + " is deleted Successful.\n", "Deleted Successful", JOptionPane.INFORMATION_MESSAGE);
                        retrieveTrip(mtc.displayRecord('L'));
                    }
                } else {
                    clear();
                }
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        JLabel jlEast = new JLabel("View Trip");
        jlEast.setForeground(new Color(29, 53, 101));
        jlEast.setFont(new Font("Arial", Font.BOLD, 32));
        jpRight.add(jlEast, BorderLayout.NORTH);
        jpRight.add(jpInfo, BorderLayout.CENTER);
        jpRight.add(jpButtons, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtLeft) {
                retrieveTrip(mtc.displayRecord('L'));
            } else if (e.getSource() == jbtRight) {
                retrieveTrip(mtc.displayRecord('R'));
            }
        }
    }

    public void retrieveTrip(Trip c) {
        if (c != null) {
            comboBox[0].setSelectedItem(c.getTripid());
            comboBox[1].setSelectedItem(c.getDepartdate().charAt(0) + "" + c.getDepartdate().charAt(1));
            comboBox[2].setSelectedItem(c.getDepartdate().charAt(3) + "" + c.getDepartdate().charAt(4));
            comboBox[3].setSelectedItem(c.getDepartdate().charAt(6) + "" + c.getDepartdate().charAt(7) + "" + c.getDepartdate().charAt(8) + "" + c.getDepartdate().charAt(9));
            comboBox[4].setSelectedItem(c.getDepartdate().charAt(11) + "" + c.getDepartdate().charAt(12));
            comboBox[5].setSelectedItem(c.getDepartdate().charAt(14) + "" + c.getDepartdate().charAt(15));
            comboBox[6].setSelectedItem(c.getDepartdate().charAt(17) + "" + c.getDepartdate().charAt(18));
            comboBox[7].setSelectedItem(c.getArrivaldate().charAt(0) + "" + c.getArrivaldate().charAt(1));
            comboBox[8].setSelectedItem(c.getArrivaldate().charAt(3) + "" + c.getArrivaldate().charAt(4));
            comboBox[9].setSelectedItem(c.getArrivaldate().charAt(6) + "" + c.getArrivaldate().charAt(7) + "" + c.getArrivaldate().charAt(8) + "" + c.getArrivaldate().charAt(9));
            comboBox[10].setSelectedItem(c.getArrivaldate().charAt(11) + "" + c.getArrivaldate().charAt(12));
            comboBox[11].setSelectedItem(c.getArrivaldate().charAt(14) + "" + c.getArrivaldate().charAt(15));
            comboBox[12].setSelectedItem(c.getArrivaldate().charAt(17) + "" + c.getArrivaldate().charAt(18));
            comboBox[13].setSelectedItem(c.getBusid().getBusid());
            comboBox[14].setSelectedItem(c.getRouteid().getRouteid());
            if (c.getDriverlistid() != null) {
                comboBox[15].setSelectedItem(c.getDriverlistid().getDriid());
            } else {
                comboBox[15].setSelectedIndex(0);
            }

            jtfFare.setText(c.getFareperticket() + "");
        }
    }

    public void clear() {
        for (JComboBox j : comboBox) {
            j.setSelectedIndex(0);
        }
        jtfFare.setText("");

        mtc = new MaintainTripControl();
        mbc = new MaintainBusControl();
        mrc = new MaintainRouteControl();
        mdvc = new MaintainDriverlistControl();

        tripModel.removeAllElements();
        busModel.removeAllElements();
        routeModel.removeAllElements();
        driverlistModel.removeAllElements();

        for (int i = 0; i < mtc.getAllRecord().size(); i++) {
            tripModel.addElement(mtc.getAllRecord().get(i).getTripid());
        }

        for (int i = 0; i < mbc.getAllRecord().size(); i++) {
            busModel.addElement(mbc.getAllRecord().get(i).getBusid());
        }
        for (int i = 0; i < mrc.getAllRecord().size(); i++) {
            routeModel.addElement(mrc.getAllRecord().get(i).getRouteid());
        }

        driverlistModel.addElement("Haven't Decided yet");
        for (int i = 0; i < mdvc.getAllRecord().size(); i++) {
            driverlistModel.addElement(mdvc.getAllRecord().get(i).getDriid());
        }
    }

    public void CreateButtonsInPanel(ArrayList<Trip> busList) {
        jpTable.removeAll();
        jpTable.revalidate();
        jpTable.repaint();
        jpTable.setLayout(new GridLayout(busList.size(), 1));

        int count = 1, y = 1;
        ImageIcon imgJbt = createImageIcon("../images/crud/trip.png", 30, 30);

        if (busList.size() < 1) {
            JLabel jlTable = new JLabel("No trip to be displayed.");
            jpTable.add(jlTable);
        } else {
            for (Trip c : busList) {
                String info = String.format("Tripid: %6s | Depart Date: %20s | Arrival Date : %20s", c.getTripid(), c.getDepartdate(), c.getArrivaldate());
                try {
                    JButton jbt = new JButton(info, imgJbt);
                    jbt.setBackground(new Color(62, 117, 67));
                    jbt.setVerticalAlignment(SwingConstants.CENTER);
                    jbt.setHorizontalAlignment(SwingConstants.LEFT);
                    jbt.setVerticalTextPosition(SwingConstants.CENTER);
                    jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
                    jbt.setForeground(Color.WHITE);
                    jbt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            retrieveTrip(c);
                        }
                    });

                    jpTable.add(jbt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error in Create Bus Button", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    public static ImageIcon createImageIcon(String path, int w, int h) {
        ImageIcon img = null;
        ImageIcon icon = null;
        java.net.URL imgURL = CRUDTrip.class.getResource(path);

        try {
            img = new ImageIcon(CRUDTrip.class.getResource(path));
            icon = new ImageIcon((img.getImage()).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
            return icon;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Image of " + path + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void designPanel(Counter ds, Staff s) {
        JPanel jpHeader = new JPanel(new BorderLayout(100, 10));
        JPanel jpLogo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jpDate = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jpHeader2 = new JPanel(new GridLayout(2, 1));
        String[] navList = {"Welcome, " + s.getStaffname(), ds.getDestid().getDestl(), "Back To Counter", "Log Out"};
        String[] navImg = {"person", "counter", "back", "logout"};
        JButton[] jbtNav = new JButton[navList.length];
        JPanel jpNav = new JPanel(new GridLayout(1, navList.length));
        String[] sideList = {"Dashboard", "Ticket Management", "Ticket Info/Purchasing", "Refund/ Cancellation of Ticket",
            "Transport Management", "Bus",
            "Route", "Trip", "Staff Management", "Staff Info", "P & C Info", "Report Management",
            "Exception Report", "Transaction Report", "Summary Report"};
        String[] sideImg = {"dashboard", "ticketmgt", "ticketinfo", "refund", "transportmgt", "bus", "route", "trip",
            "staffmgt", "staffinfo", "pnc", "reportmgt", "exception", "trans", "summary"};
        JButton[] jbtSide = new JButton[sideList.length];
        JPanel jpSide = new JPanel(new GridLayout(sideList.length, 1));
        JPanel jpWest = new JPanel(new BorderLayout());
        ImageIcon hideImg = createImageIcon("../images/arrowToRight.png", 20, 20);
        JButton jbtHide = new JButton(hideImg);

        ImageIcon busImg = createImageIcon("../images/busIcon.png", 100, 100);
        JLabel busLabel = new JLabel(busImg);
        JLabel nameLabel = new JLabel("GoToMalaysia");
        nameLabel.setForeground(new Color(117, 117, 117));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 35));
        jpLogo.add(busLabel);
        jpLogo.add(nameLabel);
        jpLogo.setBackground(Color.WHITE);
        jpHeader.setBackground(Color.WHITE);
        jpHeader.add(jpLogo, BorderLayout.WEST);
        jpHeader.setPreferredSize(new Dimension(getWidth(), 100));

        jpNav.setBackground(Color.WHITE);
        for (int i = 0; i < navList.length; i++) {
            ImageIcon imgNav = createImageIcon("../images/Mainui/" + navImg[i] + ".png", 18, 18);
            jbtNav[i] = new JButton(navList[i], imgNav);
            jbtNav[i].setPreferredSize(new Dimension(40, 50));
            jbtNav[i].setForeground(Color.WHITE);
            jbtNav[i].setBackground(new Color(8, 8, 8));
            jbtNav[i].setFont(new Font("Arial", Font.BOLD, 12));
            jpNav.add(jbtNav[i]);
        }

        jbtNav[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChooseCounter f = new ChooseCounter(s);
                dispose();
            }
        });

        jbtNav[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                dispose();
            }
        });

        jpHeader2.add(jpNav);
        SimpleDateFormat sdf = new SimpleDateFormat("EE, dd MMMMM yyyy");
        Date now = new Date();
        JLabel l2 = new JLabel("Today's Date - " + sdf.format(now));
        jpDate.add(l2);
        jpDate.setBackground(Color.WHITE);
        jpHeader2.add(jpDate);
        jpHeader.add(jpHeader2, BorderLayout.CENTER);

        jpSide.setBackground(new Color(52, 73, 94));

        for (int i = 0; i < sideList.length; i++) {
            ImageIcon img = createImageIcon("../images/Mainui/" + sideImg[i] + ".png", 18, 18);
            jbtSide[i] = new JButton(sideList[i], img);
            jbtSide[i].setBackground(new Color(34, 34, 34));
            jbtSide[i].setForeground(new Color(125, 125, 131));
            jbtSide[i].setFont(new Font("Arial", Font.BOLD, 12));
            jbtSide[i].setHorizontalAlignment(SwingConstants.LEFT);
            jpSide.add(jbtSide[i]);
        }

        jbtSide[0].setBackground(new Color(0, 119, 181));
        jbtSide[0].setForeground(Color.WHITE);
        jbtSide[1].setEnabled(false);
        jbtSide[1].setBackground(new Color(8, 8, 8));
        jbtSide[1].setForeground(Color.WHITE);
        jbtSide[4].setEnabled(false);
        jbtSide[4].setBackground(new Color(8, 8, 8));
        jbtSide[4].setForeground(Color.WHITE);
        jbtSide[8].setEnabled(false);
        jbtSide[8].setBackground(new Color(8, 8, 8));
        jbtSide[8].setForeground(Color.WHITE);
        jbtSide[11].setEnabled(false);
        jbtSide[11].setBackground(new Color(8, 8, 8));
        jbtSide[11].setForeground(Color.WHITE);
        jbtHide.setBackground(new Color(8, 8, 8));
        jbtHide.setForeground(Color.WHITE);
        jbtHide.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        jbtHide.setHorizontalAlignment(SwingConstants.RIGHT);
        jpWest.setBackground(new Color(8, 8, 8));
        jpSide.setVisible(false);
        jbtHide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jpSide.isVisible()) {
                    jpSide.setVisible(false);
                    ImageIcon showImg = createImageIcon("../images/arrowToRight.png", 20, 20);
                    jbtHide.setIcon(showImg);

                } else {
                    jpSide.setVisible(true);
                    ImageIcon shideImg = createImageIcon("../images/arrowToLeft.png", 20, 20);
                    jbtHide.setIcon(shideImg);
                }
            }
        });

        jbtSide[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainUI f = new MainUI(ds, s);
                dispose();
            }
        });

        jbtSide[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicketTripInfo f = new TicketTripInfo(ds, s);
                dispose();
            }
        });

        jbtSide[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    RefundCancelMain f = new RefundCancelMain(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDBus f = new CRUDBus(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDRoute f = new CRUDRoute(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });

        jbtSide[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDTrip f = new CRUDTrip(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });

        jbtSide[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003")) {
                    StaffCRUD f = new StaffCRUD(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffPNCMain f = new StaffPNCMain(ds, s);
                dispose();

            }
        });

        jbtSide[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    TransactioReportSelection f = new TransactioReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    ExceptionReportSelection f = new ExceptionReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    SummaryReportSelection f = new SummaryReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        jpWest.add(jbtHide, BorderLayout.NORTH);
        jpWest.add(jpSide, BorderLayout.CENTER);
        jpBg.add(jpHeader, BorderLayout.NORTH);
        jpBg.add(jpWest, BorderLayout.WEST);
        jpBg.add(jpContent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
    }

}
