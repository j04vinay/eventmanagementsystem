/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
        
public class eventmanagement extends JFrame implements ActionListener{
    JLabel id,l1;
    JButton b;
    
    eventmanagement(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eventmanagementsystem/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366,560,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,120,1366,560);
        add(l1);

        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        b.setBounds(500,600,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
        JLabel lid=new JLabel("EVENT MANAGEMENT SYSTEM");
        lid.setBounds(140,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        add(id);
        
        getContentPane().setBackground(Color.WHITE);

        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            this.setVisible(false);
            new login().setVisible(true);    
        }
    }

    public static void main(String[] arg){
        new eventmanagement();
    }
}