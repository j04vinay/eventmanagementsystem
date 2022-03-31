/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2,m3,m4,m5,m6;
    JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13;
    dashboard(){
        super("EVENT MANAGEMENT SYSTEM");
        setBounds(300,300,1366,768);
        
         mb=new JMenuBar();
         setJMenuBar(mb);
         
         m1=new JMenu("RECEPTION");
         m1.setForeground(Color.red);
         mb.add(m1);

         i1=new JMenuItem("ADMIN");
         i1.addActionListener(this);
         m1.add(i1);
         
         i2=new JMenuItem("ADD VENUE");
         i2.addActionListener(this);
         m1.add(i2);
         
        
         i3=new JMenuItem("ADD PHOTOGRAPHER");
         i3.addActionListener(this);
         m1.add(i3);
        
         i4=new JMenuItem("ADD CATERER");
         i4.addActionListener(this);
         m1.add(i4);
         
         i5=new JMenuItem("VIEW BOOKED EVENT");
         i5.addActionListener(this);
         m1.add(i5);
         
         i6=new JMenuItem("LOGOUT");
         i6.addActionListener(this);
         m1.add(i6);
         
         m2=new JMenu("VIEW EMPLOYEE DETAILS");
         m2.setForeground(Color.BLUE);
         mb.add(m2);
         
         i7=new JMenuItem("VIEW PHOTOGRAPHER");
         i7.addActionListener(this);
         m2.add(i7);
         
         i8=new JMenuItem("VIEW CATERER");
         i8.addActionListener(this);
         m2.add(i8);
         
         m3=new JMenu("VIEW VENUE DETAILS");
         m3.setForeground(Color.RED);
         mb.add(m3);
         
         i9=new JMenuItem("VIEW VENUE");
         i9.addActionListener(this);
         m3.add(i9);
         
         m4=new JMenu("VIEW CUSTOMER DETAILS");
         m4.setForeground(Color.BLUE);
         mb.add(m4);
         
         i10=new JMenuItem("VIEW CUSTOMER");
         i10.addActionListener(this);
         m4.add(i10);
         
         m5=new JMenu("EDIT EMPLOYEE DETAILS");
         m5.setForeground(Color.RED);
         mb.add(m5);
         
         i11=new JMenuItem("EDIT PHOTOGRAPHER");
         i11.addActionListener(this);
         m5.add(i11);
         
         i12=new JMenuItem("EDIT CATERER");
         i12.addActionListener(this);
         m5.add(i12);
         
         m6=new JMenu("EDIT VENUE DETAILS");
         m6.setForeground(Color.BLUE);
         mb.add(m6);
         
         i13=new JMenuItem("EDIT VENUE");
         i13.addActionListener(this);
         m6.add(i13);
         
         mb.setBounds(0,0,1000,50);
        
         
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
         
         setLayout(null);
         setBounds(0,0,1366,768);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD VENUE")){
            new addvenue().setVisible(true);
        }  else if(ae.getActionCommand().equals("ADD PHOTOGRAPHER")){
            new addphotographer().setVisible(true);
        } else if(ae.getActionCommand().equals("ADD CATERER")){
            new addcaterer().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW BOOKED EVENT")){
             new eventdetails().setVisible(true);
        }else if(ae.getActionCommand().equals("LOGOUT")){
             this.setVisible(false);
             new login().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW PHOTOGRAPHER")){
             new viewphotographer().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW CATERER")){
             new viewcaterer().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW VENUE")){
             new viewvenue().setVisible(true);
        }else if(ae.getActionCommand().equals("VIEW CUSTOMER")){
             new viewcustomer().setVisible(true);
        }else if(ae.getActionCommand().equals("EDIT PHOTOGRAPHER")){
             new editphotographer().setVisible(true);
        }else if(ae.getActionCommand().equals("EDIT CATERER")){
             new editcaterer().setVisible(true);
        }else if(ae.getActionCommand().equals("EDIT VENUE")){
             new editvenue().setVisible(true);
        }         
    }
    public static void main(String[] args){
        new dashboard().setVisible(true);
    }
}
    