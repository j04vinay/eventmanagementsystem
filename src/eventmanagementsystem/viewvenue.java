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

public class viewvenue extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    viewvenue(){
        
        JLabel l1=new JLabel("Id");
        l1.setBounds(55,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("name");
        l2.setBounds(165,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("price");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("capacity");
        l4.setBounds(420,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("facilities");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6=new JLabel("description");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        t1=new JTable();
        t1.setBounds(0,40,750,350);
        add(t1);
        
        b1=new JButton("Load data");
        b1.setBounds(200,400,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(480,400,100,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(250,150,750,500);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from venue";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new viewvenue().setVisible(true);
    }
}