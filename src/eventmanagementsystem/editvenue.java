/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Welcome
 */
public class editvenue extends JFrame implements ActionListener{
    String s[] = new String[]{"Id","Name","Price","Capacity","Facilites","Description"};
    JTextField t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    Choice c1;
    
    editvenue(){
        JLabel l10 = new JLabel("EDIT VENUE");
        l10.setFont(new Font("Tahoma", Font.PLAIN, 20));
	l10.setBounds(140, 20, 120, 30);
	add(l10);
        int j =0;
        
        for (int i=0;i<s.length;i++){
            JLabel l1 = new JLabel(s[i]);
            l1.setForeground(new Color(25, 25, 112));
            l1.setFont(new Font("Tahoma", Font.BOLD, 16));
            l1.setBounds(60, 70+j, 100, 25);
            add(l1);
            j+=30;
        }
        
        c1=new Choice();
        try{
            conn c=new conn();
            String sql="select * from venue";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                c1.add(rs.getString("id"));
            }
        }catch(Exception e){}
        c1.setBounds(180,70,150,25);
        add(c1);
        
        b3=new JButton("");
        b3.addActionListener(this);
	b3.setBounds(340, 70,20,20);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.RED);
	add(b3);
        
        t2=new JTextField();
        t2.setBounds(180,100,150,25);
        add(t2);
        
        t3=new JTextField();
        t3.setBounds(180,130,150,25);
        add(t3);
        
        t4=new JTextField();
        t4.setBounds(180,160,150,25);
        add(t4);
        
        t5=new JTextField();
        t5.setBounds(180,190,150,25);
        add(t5);
        
        t6=new JTextField();
        t6.setBounds(180,220,150,25);
        add(t6);
        
        b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 270, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	add(b1);
        
        b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 270, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450,200,400,400);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c =new conn();
            String s1=c1.getSelectedItem();
            String s2=t2.getText();
            String s3=t3.getText();
            String s4=t4.getText();
            String s5=t5.getText();
            String s6=t6.getText();
            String sql = "update venue set name='"+s2+"', price='"+s3+"', capacity='"+s4+"', facilities='"+s5+"',description='"+s6+"' where id='"+s1+"'";
            try{
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Successfully Edited");
                this.setVisible(false);
            }catch(SQLException ex){System.out.println(ex);}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }else if(ae.getSource()==b3){
            try{
            conn c=new conn();
            String sql="select * from venue where id='"+c1.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("price"));
                t4.setText(rs.getString("capacity"));
                t5.setText(rs.getString("facilities"));
                t6.setText(rs.getString("description"));
            }
            }catch(Exception e){}
        }
    }
    public static void main(String[] args){
        new editvenue().setVisible(true);
    }
}