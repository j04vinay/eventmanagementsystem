/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Himanshu Agarwal
 */
public class dashboard2 extends JFrame implements ActionListener{
    String username=null;
    dashboard2(String username){
        this.username=username;
        setBounds(0,0,1366,750);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/details.jpg"));
         Image i2=i1.getImage().getScaledInstance(1366,768,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel l1=new JLabel(i3);
         l1.setBounds(0,0,1366,768);
         add(l1);
         
         JLabel l2=new JLabel("VJ Event Planners Welcomes You");
         l2.setBounds(350,0,1000,50);
         l2.setForeground(Color.white);
         l2.setFont(new Font("Tahoma",Font.PLAIN,35));
         l1.add(l2);
        
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        JMenu jm1 = new JMenu("RECEPTION");
        jm1.setForeground(Color.RED);
	menuBar.add(jm1);

        JMenuItem a2 = new JMenuItem(username);
	jm1.add(a2);
        
        JMenuItem a1 = new JMenuItem("BOOK AN EVENT");
	jm1.add(a1);
        a1.addActionListener(this);
        
        JMenuItem a3 = new JMenuItem("VIEW PROFILE DETAILS");
	jm1.add(a3);
        a3.addActionListener(this);
        
        JMenuItem a4 = new JMenuItem("VIEW BOOKED EVENT DETAILS");
	jm1.add(a4);
        a4.addActionListener(this);
        
        JMenuItem b2 = new JMenuItem("LOGOUT");
	b2.addActionListener(this);
	jm1.add(b2);
        
        JMenu m2=new JMenu("VIEW EMPLOYEE DETAILS");
         m2.setForeground(Color.BLUE);
         menuBar.add(m2);
         
         JMenuItem i7=new JMenuItem("VIEW PHOTOGRAPHER");
         i7.addActionListener(this);
         m2.add(i7);
         
         JMenuItem i8=new JMenuItem("VIEW CATERER");
         i8.addActionListener(this);
         m2.add(i8);
        
         JMenu m3=new JMenu("VIEW VENUE DETAILS");
         m3.setForeground(Color.BLACK);
         menuBar.add(m3);
         
         JMenuItem i9=new JMenuItem("VIEW VENUE");
         i9.addActionListener(this);
         m3.add(i9);
         
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("BOOK AN EVENT")){
            this.setVisible(false);
            new bookevent(username).setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW PROFILE DETAILS")){
            this.setVisible(false);
            new viewdetails(username).setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW BOOKED EVENT DETAILS")){
            this.setVisible(false);
            new vieweventdetails(username).setVisible(true);
        }else if(ae.getActionCommand().equals("LOGOUT")){
            this.setVisible(false);
            new login().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW PHOTOGRAPHER")){
             new viewphotographer().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW CATERER")){
             new viewcaterer().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW VENUE")){
             new viewvenue().setVisible(true);
        }
    }
    public static void main(String args[]){
        dashboard2 d = new dashboard2("");
        
    }
}