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

public class ForgotPassword extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    ForgotPassword(){
        setBounds(300,200,800,370);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBounds(10,10,500,300);
        add(p);
        
        JLabel l1=new JLabel("Username");
        l1.setBounds(20,20,100,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,14));
        p.add(l1);
        
        t1=new JTextField();
        t1.setBounds(160,20,200,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p.add(t1);
        
        b1=new JButton("Search");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.setBounds(380,20,100,30);
        b1.addActionListener(this);
        p.add(b1);
        
        JLabel l2=new JLabel("email");
        l2.setBounds(20,60,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        p.add(l2);
        
        t2=new JTextField();
        t2.setBounds(160,60,200,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2);
        
        JLabel l3=new JLabel("Security Question");
        l3.setBounds(20,100,120,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        p.add(l3);
        
        t3=new JTextField();
        t3.setBounds(160,100,200,30);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p.add(t3);
        
        JLabel l4=new JLabel("Answer");
        l4.setBounds(20,140,120,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        p.add(l4);
        
        t4=new JTextField();
        t4.setBounds(160,140,200,30);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);
        
        b2=new JButton("Retrieve");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380,140,100,30);
        b2.addActionListener(this);
        p.add(b2);
        
        JLabel l5=new JLabel("Password");
        l5.setBounds(20,180,120,30);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        p.add(l5);
        
        t5=new JTextField();
        t5.setBounds(160,180,200,30);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);
        
        b3=new JButton("Back");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.setBounds(150,250,150,30);
        b3.addActionListener(this);
        p.add(b3);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(550,65,200,200);
        add(l6);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        conn c=new conn();
        if(ae.getSource()==b1){
            try{
                String sql="select * from user where username='"+t1.getText()+"'";
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                    t2.setText(rs.getString("email"));
                    t3.setText(rs.getString("securityQue"));
                }
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            try{
                String sql="select * from user where answer='"+t4.getText()+"' AND username='"+t1.getText()+"'";
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                    t5.setText(rs.getString("password"));
                }
            }catch(Exception e){}
        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args){
        new ForgotPassword().setVisible(true);
    }
}