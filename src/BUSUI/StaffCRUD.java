package BUSUI;

import BUSCONTROL.MaintainJobpositionControl;
import BUSCONTROL.MaintainPaymenttypeControl;
import BUSCONTROL.MaintainStaffControl;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Staff;
import static BUSUI.RefundCancelMain.createImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;

public class StaffCRUD extends JFrame {

    private MaintainStaffControl msc;
    private MaintainJobpositionControl mjpc;
    private MaintainPaymenttypeControl mptc;
    private JPanel jpContentHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));//header
    private JPanel jpContentCenter = new JPanel(new BorderLayout(30, 30));//content
    private JPanel jpContent = new JPanel(new BorderLayout());
    private JPanel jpLeft;//form
    private JPanel jpRight;
    private JPanel jpTable;
    private ArrayList<Staff> staffInPanel;

    private JScrollPane JSPane;
    private JPanel jpBg = new JPanel(new BorderLayout());
    private JButton jbtLeft = new JButton("<");
    private JButton jbtRight = new JButton(">");
    private JTextField[] jtfStaff = new JTextField[15];
    private Image imgBg;

    public StaffCRUD(Counter ds, Staff s) {

        msc = new MaintainStaffControl();
        mjpc = new MaintainJobpositionControl();
        mptc = new MaintainPaymenttypeControl();
        staffInPanel = msc.getAllRecord();
        design(ds, s);
        jpContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jpContent.add(jpContentHeader, BorderLayout.NORTH);
        jpContent.add(jpContentCenter, BorderLayout.CENTER);
        jpContent.setBackground(Color.WHITE);
        designPanel(ds, s);
        add(jpBg);

        setTitle("GoToMalaysia - Staff Management");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void design(Counter ds, Staff s) {
        jpContentHeader.setPreferredSize(new Dimension(getWidth(), 50));
        ImageIcon icon = createImageIcon("../images/GreyIcon/person.png", 30, 30);
        JButton jlHeader = new JButton(" Manage Staff", icon);
        jlHeader.setBackground(new Color(0, 0, 0, 0));
        jlHeader.setOpaque(false);
        jlHeader.setBorder(null);
        jlHeader.setAlignmentX(LEFT_ALIGNMENT);
        jlHeader.setFont(new Font("Arial", Font.BOLD, 32));
        jlHeader.setForeground(new Color(117, 117, 117));
        jpContentHeader.add(jlHeader);

        jpContentHeader.setBackground(new Color(0, 0, 0, 0));
        jpContentHeader.setOpaque(false);
        jpContentHeader.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        jpContentCenter.setBackground(new Color(0, 0, 0, 0));
        jpContentCenter.setOpaque(false);
        jpContentCenter.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        jpLeft = new JPanel(new BorderLayout());
        jpLeft.setOpaque(false);
        jpLeft.setBackground(new Color(0, 0, 0, 0));

        JPanel jpHeaNorth = new JPanel();
        jpHeaNorth.setBackground(new Color(0, 0, 0, 0));
        jpHeaNorth.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jpHeaNorth.setLayout(new BoxLayout(jpHeaNorth, BoxLayout.X_AXIS));
        DefaultComboBoxModel chooseModel = new DefaultComboBoxModel();
        ArrayList<String> columnName = msc.getAllColumnName();

            chooseModel.addElement(columnName.get(0));
            chooseModel.addElement(columnName.get(1));
            chooseModel.addElement(columnName.get(3));

        JComboBox comboBox = new JComboBox(chooseModel);
        comboBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(comboBox);
        JTextField jtfSearch = new JTextField();
        jtfSearch.setUI(new PlaceholderUI("Press Enter To Search", true));
        jtfSearch.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(jtfSearch);
        jtfSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffInPanel = msc.searchRecordByColumn((String) comboBox.getSelectedItem(), jtfSearch.getText());
                CreateButtonsInPanel(staffInPanel);
            }
        });
        ImageIcon imgClearT = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgClearT);
        jbtClear.setBackground(Color.BLUE);
        jbtClear.setForeground(Color.WHITE);
        jpHeaNorth.add(jbtClear);
        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msc = new MaintainStaffControl();
                staffInPanel = msc.getAllRecord();
                CreateButtonsInPanel(staffInPanel);
                jtfSearch.setText("");
            }
        });

        jpTable = new JPanel();
        jpTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpTable.setBackground(Color.WHITE);
        CreateButtonsInPanel(staffInPanel);
        JScrollPane jsPane = new JScrollPane(jpTable);
        jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jpLeft.add(jpHeaNorth, BorderLayout.NORTH);
        jpLeft.add(jsPane, BorderLayout.CENTER);

        jpRight =  new StaffManagementForm(ds, s);
        jpContentCenter.add(jpLeft, BorderLayout.CENTER);
        jpContentCenter.add(jpRight, BorderLayout.EAST);
    }

    public void CreateButtonsInPanel(ArrayList<Staff> staffList) {
        jpTable.removeAll();
        jpTable.revalidate();
        jpTable.repaint();
        jpTable.setLayout(new GridLayout(staffList.size(), 1));

        int count = 1, y = 1;
        ImageIcon imgJbt = createImageIcon("../images/Mainui/person.png", 30, 30);

        if (staffList.size() < 1) {
            JLabel jlTable = new JLabel("No staff to be displayed.");
            jpTable.add(jlTable);
        } else {
            for (Staff s : staffList) {
                String info = String.format("Staffid: %6s | Staff Name: %50s", s.getStaffid(), s.getStaffname());
                try {
                    JButton jbt = new JButton(info, imgJbt);
                    jbt.setBackground(new Color(243, 156, 18));
                    jbt.setVerticalAlignment(SwingConstants.CENTER);
                    jbt.setHorizontalAlignment(SwingConstants.LEFT);
                    jbt.setVerticalTextPosition(SwingConstants.CENTER);
                    jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
                    jbt.setForeground(Color.WHITE);
                    jbt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            
                        }
                    });

                    jpTable.add(jbt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error in Create Staff Button", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtLeft) {
//                retrieveBus(msc.displayRecord('L'));
            } else if (e.getSource() == jbtRight) {
//                retrieveBus(msc.displayRecord('R'));
            }
        }
    }

    public static ImageIcon createImageIcon(String path, int w, int h) {
        ImageIcon img = null;
        ImageIcon icon = null;
        java.net.URL imgURL = StaffCRUD.class.getResource(path);

        try {
            img = new ImageIcon(StaffCRUD.class.getResource(path));
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
