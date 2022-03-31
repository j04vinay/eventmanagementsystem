/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

/**
 *
 * @author Welcome
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class viewdetails extends JFrame implements ActionListener{
    JButton b1;
    String username;
    viewdetails(String username){
        this.username=username;
        setBounds(350,150,700,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.YELLOW);
        p1.setBounds(0,0,700,50);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1=new JLabel("View Your Details");
        l1.setBounds(220,10,500,35);
        l1.setFont(new Font("SAN_SERIF",Font.PLAIN,30));
        p1.add(l1);
        
        JPanel p2=new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setBounds(0,50,350,170);
        p2.setLayout(null);
        add(p2);
        
        JPanel p3=new JPanel();
        p3.setBackground(Color.WHITE);
        p3.setBounds(350,50,350,170);
        p3.setLayout(null);
        add(p3);
        
        JLabel l2=new JLabel("First name");
        l2.setBounds(20,20,120,25);
        l2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l2);
        
        JLabel l12=new JLabel();
        l12.setBounds(150,20,180,25);
        l12.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l12.setForeground(Color.red);
        p2.add(l12);
        
        JLabel l3=new JLabel("Last name");
        l3.setBounds(20,20,120,25);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p3.add(l3);
        
        JLabel l13=new JLabel();
        l13.setBounds(150,20,180,25);
        l13.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l13.setForeground(Color.red);
        p3.add(l13);
        
        JLabel l4=new JLabel("Username");
        l4.setBounds(20,50,120,25);
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l4);
        
        JLabel l14=new JLabel();
        l14.setBounds(150,50,180,25);
        l14.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l14.setForeground(Color.red);
        p2.add(l14);
        
        JLabel l5=new JLabel("Password");
        l5.setBounds(20,50,120,25);
        l5.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p3.add(l5);
       
        JLabel l15=new JLabel();
        l15.setBounds(150,50,180,25);
        l15.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l15.setForeground(Color.red);
        p3.add(l15);
        
        JLabel l6=new JLabel("Gender");
        l6.setBounds(20,80,120,25);
        l6.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l6);
        
        JLabel l16=new JLabel();
        l16.setBounds(150,80,180,25);
        l16.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l16.setForeground(Color.red);
        p2.add(l16);
        
        JLabel l7=new JLabel("User Type");
        l7.setBounds(20,80,120,25);
        l7.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p3.add(l7);
        
        JLabel l17=new JLabel();
        l17.setBounds(150,80,180,25);
        l17.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l17.setForeground(Color.red);
        p3.add(l17);
        
        JLabel l8=new JLabel("Email");
        l8.setBounds(20,110,120,25);
        l8.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l8);
        
        JLabel l18=new JLabel();
        l18.setBounds(150,110,180,25);
        l18.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l18.setForeground(Color.red);
        p2.add(l18);
        
        JLabel l9=new JLabel("Mobile No.");
        l9.setBounds(20,110,120,25);
        l9.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p3.add(l9);
        
        JLabel l19=new JLabel();
        l19.setBounds(150,110,180,25);
        l19.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l19.setForeground(Color.red);
        p3.add(l19);
        
        JLabel l10=new JLabel("Security Question");
        l10.setBounds(20,140,120,25);
        l10.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l10);
        
        JLabel l20=new JLabel();
        l20.setBounds(150,140,180,25);
        l20.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l20.setForeground(Color.red);
        p2.add(l20);
        
        JLabel l11=new JLabel("Answer");
        l11.setBounds(20,140,120,25);
        l11.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p3.add(l11);
        
        JLabel l21=new JLabel();
        l21.setBounds(150,140,180,25);
        l21.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        l21.setForeground(Color.red);
        p3.add(l21);
        
        b1=new JButton("Okay");
        b1.setBounds(275,225,140,30);
        b1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        add(b1);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from user where username='"+username+"'");
            while(rs.next()){
                l12.setText(rs.getString("firstname"));
                l13.setText(rs.getString("lastname"));
                l14.setText(rs.getString("username"));
                l15.setText(rs.getString("password"));
                l18.setText(rs.getString("email"));
                l19.setText(rs.getString("mobileNo"));
                l21.setText(rs.getString("answer"));
                l16.setText(rs.getString("gender"));
                l17.setText(rs.getString("usertype"));
                l20.setText(rs.getString("securityQue"));  
            }
        }catch(SQLException e){ }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
            new dashboard2(username).setVisible(true);
        }
    }
    public static void main(String args[]){
        new viewdetails("").setVisible(true);
    }
}
