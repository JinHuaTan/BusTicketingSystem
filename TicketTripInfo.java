/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainDslocationControl;
import BUSCONTROL.MaintainTripControl;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Dslocation;
import BUSDOMAIN.Staff;
import BUSDOMAIN.Trip;
import static BUSUI.CRUDRoute.createImageIcon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

public class TicketTripInfo extends JFrame {

    private MaintainTripControl mtc;
    private MaintainDslocationControl mdc;

    private ArrayList<Trip> tripList;
    private DefaultComboBoxModel srcModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel destModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel ddayModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dmonthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dyearModel = new DefaultComboBoxModel();
    private JComboBox[] jcbTrip = new JComboBox[5];
    private JLabel[] jlTrip = new JLabel[5];

    private JScrollPane jspane;
    private JPanel jpContentHeader = new JPanel(new BorderLayout());
    private JPanel jpCombo = new JPanel();
    private JPanel jpTrip = new JPanel();
    private String srcJcb = "All";
    private String destJcb = "All";
    private int jcbDay = -1;
    private int jcbMonth = -1;
    private int jcbYear = -1;
    private JPanel jpBg = new JPanel(new BorderLayout());
    private JPanel jpContent;
    private Image imgBg;
    private Staff currentStaff;
    private Counter currentCounter;

    public TicketTripInfo(Counter ds, Staff s) {
        currentStaff = s;
        currentCounter = ds;
        mtc = new MaintainTripControl();
        mdc = new MaintainDslocationControl();

        Calendar calOri = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        int beforeDay, afterDay;
        if (calOri.get(Calendar.DAY_OF_MONTH) >= cal.get(Calendar.DAY_OF_MONTH)) {
            afterDay = 31;
            beforeDay = 1;
        } else {
            afterDay = cal.get(Calendar.DAY_OF_MONTH);
            beforeDay = calOri.get(Calendar.DAY_OF_MONTH);
        }

        for (int i = beforeDay; i <= afterDay; i++) {
            ddayModel.addElement(String.format("%02d", i) + "");
        }
        for (int i = calOri.get(Calendar.MONTH) + 1; i <= cal.get(Calendar.MONTH) + 1; i++) {
            dmonthModel.addElement(String.format("%02d", i) + "");
        }
        for (int i = calOri.get(Calendar.YEAR); i <= cal.get(Calendar.YEAR); i++) {
            dyearModel.addElement(String.format("%04d", i) + "");
        }

        ImageIcon ticketJbt = createImageIcon("../images/ticket-jbt.png", 50, 50);
        JButton jbtTPurchase = new JButton("Ticket Info / Purchasing", ticketJbt);
        jbtTPurchase.setForeground(new Color(117, 117, 117));
        jbtTPurchase.setBackground(Color.white);
        jbtTPurchase.setHorizontalAlignment(SwingConstants.LEFT);
        jbtTPurchase.setBorder(null);
        jbtTPurchase.setFont(new Font("Arial", Font.BOLD, 30));

        jpContentHeader.add(jbtTPurchase, BorderLayout.NORTH);
        jpContentHeader.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        jlTrip[0] = new JLabel("Source - ");
        jpCombo.add(jlTrip[0]);
        jcbTrip[0] = new JComboBox(srcModel);
        jlTrip[0].setLabelFor(jcbTrip[0]);
        jcbTrip[0].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    srcJcb = (String) e.getItem();
                    CreateButtonsInPanel(srcJcb, destJcb);
                }
            }
        });
        jpCombo.add(jcbTrip[0]);

        jlTrip[1] = new JLabel(" | Destination - ");
        jpCombo.add(jlTrip[1]);
        jcbTrip[1] = new JComboBox(destModel);
        jlTrip[1].setLabelFor(jcbTrip[1]);
        jcbTrip[1].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    destJcb = (String) e.getItem();
                    CreateButtonsInPanel(srcJcb, destJcb);
                }
            }
        });
        jpCombo.add(jcbTrip[1]);

        jlTrip[2] = new JLabel(" | Date - dd: ");
        jpCombo.add(jlTrip[2]);
        jcbTrip[2] = new JComboBox(ddayModel);
        jlTrip[2].setLabelFor(jcbTrip[2]);
        jcbTrip[2].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (((String) e.getItem()).equals("Any")) {
                        jcbDay = -1;
                    } else {
                        jcbDay = Integer.parseInt(e.getItem().toString());
                    }
                    if (CompareDateWithJcombo(jcbDay, jcbMonth, jcbYear)) {
                        CreateButtonsInPanel(srcJcb, destJcb);
                    }
                }
            }
        });
        jpCombo.add(jcbTrip[2]);

        jlTrip[3] = new JLabel(" | mm: ");
        jpCombo.add(jlTrip[3]);
        jcbTrip[3] = new JComboBox(dmonthModel);
        jlTrip[3].setLabelFor(jcbTrip[3]);
        jcbTrip[3].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (((String) e.getItem()).equals("Any")) {
                        jcbMonth = -1;
                    } else {
                        jcbMonth = Integer.parseInt(e.getItem().toString());
                    }
                    if (CompareDateWithJcombo(jcbDay, jcbMonth, jcbYear)) {
                        CreateButtonsInPanel(srcJcb, destJcb);
                    }
                }
            }
        });
        jpCombo.add(jcbTrip[3]);

        jlTrip[4] = new JLabel(" | yyyy: ");
        jpCombo.add(jlTrip[4]);
        jcbTrip[4] = new JComboBox(dyearModel);
        jlTrip[4].setLabelFor(jcbTrip[4]);
        jcbTrip[4].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (((String) e.getItem()).equals("Any")) {
                        jcbYear = -1;
                    } else {
                        jcbYear = Integer.parseInt(e.getItem().toString());
                    }
                    if (CompareDateWithJcombo(jcbDay, jcbMonth, jcbYear)) {
                        CreateButtonsInPanel(srcJcb, destJcb);
                    }
                }
            }
        });
        jpCombo.add(jcbTrip[4]);
        jpContentHeader.add(jpCombo, BorderLayout.CENTER);

        jpContent = new JPanel(new BorderLayout());
        jspane = new JScrollPane(jpTrip);
        jpContent.setBackground(Color.WHITE);
        jpContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jpContent.add(jpContentHeader, BorderLayout.NORTH);
        jpContent.add(jspane, BorderLayout.CENTER);

        designPanel(ds, s);
        add(jpBg);

        setTitle("GoToMalaysia - CRUD of Bus");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
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

    public void CreateTripJButton(Trip r) {
        String info = r.toString();
        try {
            JButton jbt = new JButton(info);
            jbt.setBackground(Color.WHITE);
            jbt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PurchaseTicketInfo f = new PurchaseTicketInfo(r, currentCounter, currentStaff);
                }
            });
            jpTrip.add(jbt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Create Trip Button", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CreateButtonsInPanel(String src, String dest) {
        jpTrip.removeAll();
        jpTrip.revalidate();
        jpTrip.repaint();
        tripList = mtc.getAllRecord();
        jpTrip.setLayout(new GridLayout((int) Math.ceil(tripList.size() / 6.0), 6, 5, 5));

        if (src.equals("All") && dest.equals("All")) {
            for (int i = 0; i < tripList.size(); i++) {
                CompareDateWithTrip(tripList.get(i), jcbDay, jcbMonth, jcbYear);

            }
        } else if (src.equals("All") && !dest.equals("All")) {
            for (int i = 0; i < tripList.size(); i++) {
                if (tripList.get(i).getRouteid().getDestid().getDestl().equals(dest)) {
                    CompareDateWithTrip(tripList.get(i), jcbDay, jcbMonth, jcbYear);
                }
            }
        } else if (!src.equals("All") && dest.equals("All")) {
            for (int i = 0; i < tripList.size(); i++) {
                if (tripList.get(i).getRouteid().getSourceid().getDestl().equals(src)) {
                    CompareDateWithTrip(tripList.get(i), jcbDay, jcbMonth, jcbYear);
                }
            }
        } else if (!src.equals("All") && !dest.equals("All")) {
            for (int i = 0; i < tripList.size(); i++) {
                if (tripList.get(i).getRouteid().getSourceid().getDestl().equals(src)) {
                    if (tripList.get(i).getRouteid().getDestid().getDestl().equals(dest)) {
                        CompareDateWithTrip(tripList.get(i), jcbDay, jcbMonth, jcbYear);
                    }
                }
            }
        }
    }


    public static ImageIcon createImageIcon(String path, int w, int h) {
        ImageIcon img = null;
        ImageIcon icon = null;
        java.net.URL imgURL = TicketTripInfo.class.getResource(path);

        try {
            img = new ImageIcon(TicketTripInfo.class.getResource(path));
            icon = new ImageIcon((img.getImage()).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
            return icon;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Image of " + path + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void main(String[] args) {
    }

}
