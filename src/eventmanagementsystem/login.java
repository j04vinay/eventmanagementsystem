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
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    login(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(400,250,600,300);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,250,250);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,250,250);
        p1.add(l1);
        
        JPanel p2=new JPanel();
        p2.setBounds(250,0,350,300);
        p2.setLayout(null);
        add(p2);
        
        JLabel l2=new JLabel("Username");
        l2.setBounds(20,20,100,20);
        l2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l2);
        
        t1=new JTextField();
        t1.setBounds(20,50,300,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        JLabel l3=new JLabel("Password");
        l3.setBounds(20,90,100,20);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(l3);
        
        t2=new JPasswordField();
        t2.setBounds(20,120,300,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
        b1=new JButton("Login");
        b1.setBounds(20,160,140,30);
        b1.setBackground(Color.BLUE);
        b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Register");
        b2.setBounds(180,160,140,30);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        b2.setForeground(Color.BLUE);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setBorder(new LineBorder(Color.BLUE));
        b2.addActionListener(this);
        p2.add(b2);
        
        b3=new JButton("Forgot password");
        b3.setBounds(90,200,160,30);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        b3.setForeground(Color.BLUE);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setBorder(new LineBorder(Color.BLUE));
        b3.addActionListener(this);
        p2.add(b3);  
    }
    public void actionPerformed(ActionEvent ae){
        conn c=new conn();
        if(ae.getSource()==b1){
            try{
                String username=t1.getText();
                String password=t2.getText();
                String sql="select * from user where username='"+username+"' AND password='"+password+"'";
                
                ResultSet rs=c.s.executeQuery(sql);
                if(rs.next()){
                    String usertype=rs.getString("usertype");
                    switch (usertype) {
                        case "admin" -> {
                            this.setVisible(false);
                            new dashboard().setVisible(true);
                        }
                        case "Customer" -> {
                            this.setVisible(false);
                            new dashboard2(username).setVisible(true);
                        }
                        default -> this.setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Register().setVisible(true);
        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
    public static void main(String[] args){
        new login().setVisible(true);
    }
}