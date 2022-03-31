/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class bookevent extends JFrame implements ActionListener{
    JPanel p;
    JLabel l8,l11;
    JTextField t2;
    JComboBox cb1;
    JButton b1,b2,b3;
    Choice c1,c2,c3;
    String username=null;
    bookevent(String username){
        this.username=username;
        setBounds(250, 150, 1000, 500);
	p = new JPanel();
	setContentPane(p);
	p.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/login.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);
        
        JLabel l10 = new JLabel("BOOK EVENT");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	p.add(l10);
        
	JLabel l1 = new JLabel("Username");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 20);
	p.add(l1);
                
        l11 = new JLabel(username);
	l11.setForeground(Color.red);
	l11.setFont(new Font("Tahoma", Font.BOLD, 14));
	l11.setBounds(176, 70, 154, 22);
	p.add(l11);
        
	JLabel l2 = new JLabel("Function");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	p.add(l2);
        
        cb1 = new JComboBox(new String[] {"Marriage","Birthday","Anniversery","Break up party","Patch up party" });
	cb1.setBounds(176, 110, 154, 20);
	p.add(cb1);

	JLabel l3 = new JLabel("Photographer");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	p.add(l3);
        
        c2 = new Choice();
        c2.add("No");
        try{
            conn c=new conn();
            String sql="select * from photographer";
            ResultSet rs1=c.s.executeQuery(sql);
            while(rs1.next()){
                c2.add(rs1.getString("name"));
            }
        }catch(Exception e){}
	c2.setBounds(176, 150, 154, 20);
	p.add(c2);
        
        JLabel l4 = new JLabel("Catering");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	p.add(l4);
        
        c3 = new Choice();
        c3.add("No");
        try{
            conn c=new conn();
            String sql="select * from caterer";
            ResultSet rs2=c.s.executeQuery(sql);
            while(rs2.next()){
                c3.add(rs2.getString("name"));
            }
        }catch(Exception e){}
	c3.setBounds(176, 190, 154, 20);
	p.add(c3);

        JLabel l5 = new JLabel("Venue");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	p.add(l5);
        
        c1 = new Choice();
        try{
            conn c=new conn();
            String sql="select * from venue";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
        }catch(Exception e){}
	c1.setBounds(176, 230, 154, 20);
	p.add(c1);
	
        JLabel l6 = new JLabel("Date");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 270, 102, 22);
	p.add(l6);
                
        t2 = new JTextField();
	t2.setBounds(174, 270, 156, 20);
	p.add(t2);
        
        JLabel l7 = new JLabel("Price");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 310, 102, 22);
	p.add(l7);
                
        l8 = new JLabel();
	l8.setForeground(Color.RED);
	l8.setFont(new Font("Tahoma", Font.BOLD, 14));
	l8.setBounds(174, 310, 156, 20);
	p.add(l8);
        
	b1 = new JButton("Book");
	b1.addActionListener(this);
	b1.setBounds(64, 400, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	p.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 400, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	p.add(b2);
        
        b3 = new JButton("Check");
	b3.addActionListener(this);
	b3.setBounds(140, 350, 111, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	p.add(b3);
	
        p.setBackground(Color.WHITE);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name=l11.getText();
            String partyType=(String) cb1.getSelectedItem();
            String photographer=(String) c2.getSelectedItem();
            String catering=(String) c3.getSelectedItem();
            String venue=(String) c1.getSelectedItem();
            String date=t2.getText();
            String price=l8.getText();
            try{
                conn c=new conn();
                String str="insert into event values('"+name+"','"+partyType+"','"+photographer+"','"+catering+"','"+venue+"','"+date+"','"+price+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Event Booked successfully");
                this.setVisible(false);
                new dashboard2(username).setVisible(true);
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new dashboard2(username).setVisible(true);
        }else if(ae.getSource()==b3){
            int price=0,amount1=0,amount2=0;
            String photographer=(String) c2.getSelectedItem();
            String catering=(String) c3.getSelectedItem();
            String venue=(String) c1.getSelectedItem();
            try{
                conn c=new conn();
                String sql="select * from venue where name='"+venue+"'";
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                    price=Integer.parseInt(rs.getString("price"));
                }
                if(photographer.equals("No")){
                    price+=amount1;
                }else {
                    String sql2="select * from photographer where name='"+photographer+"'";
                    ResultSet rs2=c.s.executeQuery(sql2);
                    while(rs2.next()){
                        amount1=Integer.parseInt(rs2.getString("price"));
                    }
                    price+=amount1;
                }
                if(catering.equals("No")){
                    price+=amount2;
                }else {
                    String sql3="select * from caterer where name='"+catering+"'";
                    ResultSet rs3=c.s.executeQuery(sql3);
                    while(rs3.next()){
                        amount2=Integer.parseInt(rs3.getString("price"));
                    }
                    price+=amount2;
                }
                l8.setText("Rs"+price);
            }catch(Exception e){}
        }
    }
    public static void main( String args[]){
        new bookevent("").setVisible(true);
    }
}