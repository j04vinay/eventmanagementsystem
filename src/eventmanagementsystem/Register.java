/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice c1,c2,c3;
    Register(){
        setBounds(350,150,650,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.YELLOW);
        p1.setBounds(0,0,650,50);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1=new JLabel("We welcomes You");
        l1.setBounds(180,10,500,35);
        l1.setFont(new Font("SAN_SERIF",Font.PLAIN,30));
        p1.add(l1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(50,130,200,200);
        add(l12);
        
        JPanel p2=new JPanel();
        p2.setBackground(new Color(131,193,233));
        p2.setBounds(290,50,350,400);
        p2.setLayout(null);
        add(p2);
        
        JLabel l2=new JLabel("First name*");
        l2.setBounds(20,20,120,25);
        l2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l2);
        
        t1=new JTextField();
        t1.setBounds(150,20,180,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        JLabel l3=new JLabel("Last name*");
        l3.setBounds(20,50,120,25);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l3);
        
        t2=new JTextField();
        t2.setBounds(150,50,180,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
        JLabel l4=new JLabel("Username*");
        l4.setBounds(20,80,120,25);
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l4);
        
        t3=new JTextField();
        t3.setBounds(150,80,180,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t3);
        
        JLabel l5=new JLabel("Password*");
        l5.setBounds(20,110,120,25);
        l5.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l5);
        
        t4=new JTextField();
        t4.setBounds(150,110,180,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t4);
        
        JLabel l6=new JLabel("Gender");
        l6.setBounds(20,140,120,25);
        l6.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l6);
        
        c1=new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("None");
        c1.setBounds(150,140,180,25);
        p2.add(c1);
        
        JLabel l7=new JLabel("User Type");
        l7.setBounds(20,170,120,25);
        l7.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l7);
        
        c2=new Choice();
        c2.add("Customer");
        c2.setBounds(150,170,180,25);
        p2.add(c2);
        
        JLabel l8=new JLabel("Email*");
        l8.setBounds(20,200,120,25);
        l8.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l8);
        
        t5=new JTextField();
        t5.setBounds(150,200,180,25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t5);
        
        JLabel l9=new JLabel("Mobile No.*");
        l9.setBounds(20,230,120,25);
        l9.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l9);
        
        t6=new JTextField();
        t6.setBounds(150,230,180,25);
        t6.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t6);
        
        JLabel l10=new JLabel("Security Question");
        l10.setBounds(20,260,120,25);
        l10.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l10);
        
        c3=new Choice();
        c3.add("Your Nickname?");
        c3.add("Your favorite book name?");
        c3.add("Your lucky number?");
        c3.add("Your pet name?");
        c3.add("Your role model?");
        c3.setBounds(150,260,180,25);
        p2.add(c3);
        
        JLabel l11=new JLabel("Answer*");
        l11.setBounds(20,290,120,25);
        l11.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l11);
        
        t7=new JTextField();
        t7.setBounds(150,290,180,25);
        t7.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t7);
        
        b1=new JButton("Submit");
        b1.setBounds(20,325,140,30);
        b1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(170,325,140,30);
        b2.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        b2.setBackground(Color.WHITE);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        p2.add(b2);
    }
    public void actionPerformed(ActionEvent ae){
        conn c=new conn();
        if(ae.getSource()==b1){
            String firstname=t1.getText();
            String lastname=t2.getText();
            String username=t3.getText();
            String password=t4.getText();
            String gender=c1.getSelectedItem();
            String usertype=c2.getSelectedItem();
            String email=t5.getText();
            String mobileno=t6.getText();
            String security=c3.getSelectedItem();
            String answer=t7.getText();
          
            if(firstname.equals("") || lastname.equals("") || username.equals("") || password.equals("") || email.equals("") || mobileno.equals("") || answer.equals("")){
                JOptionPane.showMessageDialog(null,"please fill required fields");
            } else {
                {
                    String query="insert into user values('"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+gender+"','"+usertype+"','"+email+"','"+mobileno+"','"+security+"','"+answer+"')";
                    try{
                        conn c1=new conn();
                        c1.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Registration Successfully");
                        
                        this.setVisible(false);
                        new login().setVisible(true);
                    }catch(SQLException e){ }
                }
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Register().setVisible(true);
    }
}