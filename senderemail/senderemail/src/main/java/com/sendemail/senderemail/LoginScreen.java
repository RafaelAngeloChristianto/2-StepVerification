package com.sendemail.senderemail;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginScreen extends JFrame implements ActionListener {

    private JTextField username_field;
    private JPasswordField password_field;
    private JButton login_button;
    private JButton signup_button;
    public String users_username;
    public String users_password;
    private JFrame frame;
    private JLabel empty_warn;
    public String users_email;



    public LoginScreen() {
        JLabel label = new JLabel("FARLEAF INDUSTRIES", SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon("images/logo.png");
        label.setIcon(icon);
        label.setIconTextGap(25);
        label.setFont(new Font("Century Gothic", Font.PLAIN, 40));
        label.setBounds(275, -20, 960, 540);
        

        JLabel username = new JLabel("Username: ", SwingConstants.CENTER);
        username.setFont(new Font("Montserrat", Font.PLAIN, 25));
        username.setBounds(200, 195, 960, 540); 
        username_field = new JTextField();
        username_field.setBounds(740, 455, 200, 30);
        username_field.setHorizontalAlignment(JTextField.CENTER);


        JLabel password = new JLabel("Password: ", SwingConstants.CENTER);
        password.setFont(new Font("Montserrat", Font.PLAIN, 25));
        password.setBounds(200, 280, 960, 540); 
        password_field = new JPasswordField();
        password_field.setHorizontalAlignment(JPasswordField.CENTER);
        password_field.setBounds(740, 540, 200, 30);
        password_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));


        JPanel login_signup = new JPanel();
        login_signup.setLayout(null);
        login_button = new JButton("Login");
        login_button.addActionListener(this);
        signup_button = new JButton("Sign Up");
        signup_button.addActionListener(this);
        login_button.setBounds(150, 250, 100, 50); 
        signup_button.setBounds(270, 250, 100, 50); 
        login_signup.add(login_button);
        login_signup.add(signup_button);
        login_signup.setBounds(500, 400, 410, 300);
        login_button.setVerticalAlignment(JButton.CENTER);
        login_button.setHorizontalAlignment(JButton.CENTER);
        signup_button.setVerticalAlignment(JButton.CENTER);
        signup_button.setHorizontalAlignment(JButton.CENTER);


        empty_warn = new JLabel("Fill every field", JLabel.CENTER);
        empty_warn.setForeground(Color.RED);
        empty_warn.setBounds(700, 700, 100, 30);
        empty_warn.setVisible(false);
        


        frame = new JFrame();
        frame.setTitle("farleaf industries"); // window title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the frame
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setIconImage(icon.getImage()); // set the icon of the window
        frame.add(label);
        frame.add(username);
        frame.add(username_field);
        frame.add(password);
        frame.add(password_field);
        frame.add(login_signup);
        frame.add(empty_warn);

    } 

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login_button) {
            users_username = username_field.getText();
            users_password = password_field.getText();

            System.out.println("Login Information: ");
            System.out.println("Username: " + users_username);
            System.out.println("Password: " + users_password);

            if (users_username.length() == 0 || users_password.length() == 0) {
                empty_warn.setVisible(true);
            } else {
                if (Data.loginChecker(users_username, users_password)) {
                    empty_warn.setVisible(false);
                    WelcomePage continued_page = new WelcomePage(users_username);
                    frame.dispose();
                }
            }
        } else if (event.getSource() == signup_button) {
            frame.dispose();
            SignupScreen signup_screen_transfer = new SignupScreen();
        }
    }
}
