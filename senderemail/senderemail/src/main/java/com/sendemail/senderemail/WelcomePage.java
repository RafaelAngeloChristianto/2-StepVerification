package com.sendemail.senderemail;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomePage {    
    public WelcomePage(String username) {
        JFrame frame = new JFrame();
        
        JLabel welcoming_message = new JLabel();
        welcoming_message.setText("Welcome, " + username);
        welcoming_message.setBounds(500, 400, 400, 100); 
        welcoming_message.setFont(new Font("Montserrat", Font.PLAIN, 30)); 



        frame.add(welcoming_message);

        // frame configurations
        frame.setTitle("FARLEAF INDUSTRIES!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false); 

        ImageIcon icon = new ImageIcon("images/logo.png");
        frame.setIconImage(icon.getImage());
    }   
}
