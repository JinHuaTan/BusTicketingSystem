/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainCounterControl;
import BUSCONTROL.MaintainDslocationControl;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Dslocation;
import BUSDOMAIN.Staff;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ChooseCounter extends JFrame {

    private DefaultComboBoxModel srcModel = new DefaultComboBoxModel();
    private MaintainDslocationControl mdc;
    private MaintainCounterControl mcc;

    private JScrollPane jsPane;
    private JPanel jpWhole = new JPanel(new BorderLayout());
    private Image imgBg;
    private JPanel jpBg2 = new JPanel(new BorderLayout());
    private JPanel jpNav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
    private JPanel jpBody = new JPanel();

    private ArrayList<Counter> counterList = new ArrayList<Counter>();
    private JButton[] jbtLocation;

    public ChooseCounter(Staff s) {
        mcc = new MaintainCounterControl();
        mdc = new MaintainDslocationControl();
        for (int i = 0; i < mdc.getAllRecord().size(); i++) {
            srcModel.addElement(mdc.getAllRecord().get(i).getDestl());
        }
        try {
            imgBg = ImageIO.read(this.getClass().getResource("../images/background/bg50.jpg"));;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Image of login cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        JPanel jpBg = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                Graphics2D g2 = (Graphics2D) g;
                g2.fill(new Rectangle(0, 0, d.width, 260));
                g.drawImage(imgBg, 0, 0, d.width, 260, null);
            }
        };
        jpBg.setPreferredSize(new Dimension(getWidth(), 260));
        jpBg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel jpHeaderBody = new JPanel();
        jpHeaderBody.setOpaque(true);
        jpHeaderBody.setBackground(new Color(0, 0, 0, 0));
        jpHeaderBody.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpHeaderBody.setLayout(new BoxLayout(jpHeaderBody, BoxLayout.Y_AXIS));

        ImageIcon busImg = createImageIcon("../images/busIcon.png", 90, 90);
        JLabel busLabel = new JLabel(busImg);
        busLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpHeaderBody.add(busLabel);

        JLabel jlCounter = new JLabel("CHOOSE COUNTER");
        jlCounter.setFont(new Font("Geneva", Font.BOLD, 70));
        jlCounter.setForeground(Color.WHITE);
        jlCounter.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpHeaderBody.add(jlCounter);

        JLabel jlCounter2 = new JLabel("Where are you?");
        jlCounter2.setFont(new Font("Verdana", Font.BOLD, 30));
        jlCounter2.setForeground(Color.WHITE);
        jlCounter2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpHeaderBody.add(jlCounter2);
        jpBg.add(jpHeaderBody);

        jpBg2.setBackground(Color.WHITE);
        jpNav.setBackground(Color.BLACK);

        ImageIcon imgNav = createImageIcon("../images/Mainui/person.png", 18, 18);
        JButton jbtWelcome = new JButton("Welcome, " + s.getStaffname(), imgNav);
        editNavButton(jbtWelcome);
        jbtWelcome.setBorder(null);
        jpNav.add(jbtWelcome);

        ImageIcon imgCounter = createImageIcon("../images/setting.png", 18, 18);
        JButton jbtCounter = new JButton("Manage Counter", imgCounter);
        editNavButton(jbtCounter);
        jbtWelcome.setBorder(null);
        jpNav.add(jbtCounter);
        jbtCounter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                if(s.getJobposition().getPositionid().equals("P00003")){
                CRUDCounter l = new CRUDCounter();
                
                }else{
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        ImageIcon imgNav2 = createImageIcon("../images/Mainui/logout.png", 18, 18);
        JButton jbtLogout = new JButton("Log Out", imgNav2);
        editNavButton(jbtLogout);
        jpNav.add(jbtLogout);
        jbtLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                dispose();
            }
        });
        jpBody.setLayout(new GridBagLayout());
        jpBody.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        int count = 1, y = 2;
        counterList = new ArrayList<Counter>(mcc.getAllRecord());
        int listSize = counterList.size();
        jbtLocation = new JButton[listSize];

        if (listSize != 0) {
            for (int l = 0; l < listSize; l++) {
                Dslocation ds = mdc.selectRecord(counterList.get(l).getDestid().getDestid());
                String jl2html = null;
                try {
                    jl2html = "<html><head>"
                            + "<style>"
                            + "table {width:100%;height:auto;margin:5 5}"
                            + "</style>"
                            + "</head><body>"
                            + "<table>"
                            + "<tr>"
                            + "<td>" + "<img src=\"" + ViewLocation.class.getResource("../images/location/" + ds.getImageurl() + "") + "\" width=180 height=100></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ds.getDestl() + "</td>"
                            + "</tr>"
                            + "</table>"
                            + "</body></html>";
                } catch (Exception ioe) {
                    JOptionPane.showMessageDialog(null, "Image of " + ds.getDestl() + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                jbtLocation[l] = new JButton(jl2html);
                editButton(jbtLocation[l]);
                Counter ctn = counterList.get(l);
                jbtLocation[l].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MainUI f = new MainUI(ctn, s);
                        setVisible(false);
                    }
                });
                c.insets = new Insets(10, 10, 10, 10);
                c.gridwidth = 1;
                c.ipady = 1;
                c.gridy = y;
                c.gridx = count;
                if (count == 5) {
                    count = 0;
                    y++;
                }
                count++;

                jpBody.add(jbtLocation[l], c);
            }
        } else {
            c.insets = new Insets(5, 5, 5, 5);
            c.gridwidth = 1;
            c.gridy = 2;
            c.gridx = count;
            jpBody.add(new JLabel("No place to be displayed."), c);
        }

        jpBg2.add(jpNav, BorderLayout.NORTH);
        jpBg2.add(jpBody, BorderLayout.CENTER);
        jpWhole.add(jpBg, BorderLayout.NORTH);
        jpWhole.add(jpBg2, BorderLayout.CENTER);
        jsPane = new JScrollPane(jpWhole);
        add(jsPane);
        setTitle("GoToMalaysia - Choose location");
        setSize(500, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void editNavButton(JButton jbt) {
        jbt.setOpaque(false);
        jbt.setBackground(Color.BLACK);
        jbt.setForeground(Color.WHITE);
        jbt.setFont(new Font("Arial", Font.BOLD, 12));
        jbt.setHorizontalAlignment(AbstractButton.LEFT);
        jbt.setVerticalAlignment(AbstractButton.CENTER);
    }

    public static ImageIcon createImageIcon(String path, int w, int h) {
        ImageIcon img = null;
        ImageIcon icon = null;
        java.net.URL imgURL = ChooseCounter.class.getResource(path);

        try {
            img = new ImageIcon(ChooseCounter.class.getResource(path));
            icon = new ImageIcon((img.getImage()).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
            return icon;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Image of " + path + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void editButton(JButton jbt) {
        jbt.setOpaque(false);
        jbt.setBackground(new Color(0, 0, 0, 0));
        Border border = new LineBorder(Color.WHITE, 1);
        jbt.setBorder(border);
        jbt.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        jbt.setForeground(new Color(230, 126, 34));
        jbt.setHorizontalTextPosition(AbstractButton.CENTER);
        jbt.setVerticalTextPosition(AbstractButton.CENTER);
        jbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Border border = new LineBorder(Color.ORANGE, 1);
                jbt.setBorder(border);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Border border = new LineBorder(Color.WHITE, 1);
                jbt.setBorder(border);
            }
        });
    }

    public static void main(String[] args) {
    }
}
