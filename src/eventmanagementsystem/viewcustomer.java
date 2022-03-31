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
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewcustomer extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    viewcustomer(){
        
        JLabel l1=new JLabel("Firstname");
        l1.setBounds(35,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Lastname");
        l2.setBounds(175,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Username");
        l3.setBounds(310,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Password");
        l4.setBounds(445,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(580,10,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Usertype");
        l6.setBounds(720,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Email");
        l7.setBounds(850,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("ContactNo");
        l8.setBounds(980,10,100,20);
        add(l8);
        
        JLabel l9=new JLabel("SecurityQue");
        l9.setBounds(1100,10,100,20);
        add(l9);
        
        JLabel l10=new JLabel("Answer");
        l10.setBounds(1240,10,100,20);
        add(l10);
        
        t1=new JTable();
        t1.setBounds(0,40,1350,550);
        add(t1);
        
        b1=new JButton("Load data");
        b1.setBounds(500,600,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(780,600,100,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(0,0,1350,750);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from user where usertype='Customer'";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new viewcustomer().setVisible(true);
    }
}