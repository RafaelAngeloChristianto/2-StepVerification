package com.sendemail.senderemail;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.core.joran.action.Action;

import javax.swing.event.DocumentEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupScreen implements ActionListener {
    public JFrame frame;
    private JTextField username_field;
    private JTextField email_field;
    private JPasswordField password_field;
    private JPasswordField confirm_password_field;
    private JLabel diff_warning;
    private JButton create_account_button;
    private JButton back_to_login;
    private JLabel email_warning;
    public String username_user;
    public static String users_email;
    private String confirmPassword;
    protected static int otp;
    public JButton confirm_email;
    public JPanel otp_entering;
    public JTextField otp_field;
    public JButton verify_otp_button;
    
    public SignupScreen() {
        frame = new JFrame();
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
       

        JLabel email = new JLabel("Email: ", SwingConstants.CENTER);
        email.setFont(new Font("Montserrat", Font.PLAIN, 25));
        email.setBounds(222, 250, 960, 540); 
        email_field = new JTextField();
        email_field.setBounds(740, 510, 200, 30);
        email_field.setHorizontalAlignment(JTextField.CENTER);
        email_warning = new JLabel("Email must contain '@'", SwingConstants.CENTER);
        email_warning.setForeground(Color.RED);
        email_warning.setFont(new Font("Montserrat", Font.PLAIN, 15));
        email_warning.setBounds(740, 530, 200, 30);
        email_warning.setVisible(false);
        email_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkEmail();
            }
            public void removeUpdate(DocumentEvent e) {
                checkEmail();
            }
            public void insertUpdate(DocumentEvent e) {
                checkEmail();
            }
        });

        confirm_email = new JButton("Send Confirmation Email");
        confirm_email.addActionListener(this);
        confirm_email.setBounds(950, 510, 200, 30);


        otp_entering = new JPanel();
        otp_entering.setLayout(null);
        otp_entering.setBounds(600, 580, 400, 150);
        JLabel enterOTP = new JLabel("Enter OTP:", SwingConstants.CENTER);
        enterOTP.setFont(new Font("Montserrat", Font.PLAIN, 20));
        enterOTP.setBounds(0, 0, 400, 30);
        otp_field = new JTextField();
        otp_field.setBounds(150, 40, 100, 30);
        otp_field.setHorizontalAlignment(JTextField.CENTER);
        verify_otp_button = new JButton("Verify OTP");
        verify_otp_button.setBounds(150, 80, 100, 30);
        verify_otp_button.addActionListener(this);

        otp_entering.add(enterOTP);
        otp_entering.add(otp_field);
        otp_entering.add(verify_otp_button);
        otp_entering.setBackground(new Color(245, 245, 220));
        otp_entering.setVisible(false);

        JLabel password = new JLabel("Password: ", SwingConstants.CENTER);
        password.setFont(new Font("Montserrat", Font.PLAIN, 25));
        password.setBounds(200, 310, 960, 540); 
        password_field = new JPasswordField();
        password_field.setBounds(740, 570, 200, 30);
        password_field.setHorizontalAlignment(JTextField.CENTER);

        JLabel confirm_password = new JLabel("Confirm Password: ", SwingConstants.CENTER);
        confirm_password.setFont(new Font("Montserrat", Font.PLAIN, 25));
        confirm_password.setBounds(154, 370, 960, 540); 
        confirm_password_field = new JPasswordField();
        confirm_password_field.setBounds(740, 630, 200, 30);
        confirm_password_field.setHorizontalAlignment(JTextField.CENTER);



        diff_warning = new JLabel("Passwords do not match", SwingConstants.CENTER);
        diff_warning.setForeground(Color.RED);
        diff_warning.setFont(new Font("Montserrat", Font.PLAIN, 15));
        diff_warning.setBounds(740, 650, 200, 30);
        diff_warning.setVisible(false);
        confirm_password_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkPasswordConfirmation();
            }
            public void removeUpdate(DocumentEvent e) {
                checkPasswordConfirmation();
            }
            public void insertUpdate(DocumentEvent e) {
                checkPasswordConfirmation();
            }
        });


        create_account_button = new JButton("Create Account");
        create_account_button.addActionListener(this);  
        create_account_button.setBounds(600, 700, 150, 50);

        back_to_login = new JButton("Back to Login Page");
        back_to_login.setBounds(800, 700, 150, 50); 
        back_to_login.addActionListener(this);

        // adding elements to frame
        frame.add(label);
        frame.add(username);
        frame.add(username_field);
        frame.add(email);
        frame.add(email_field);
        frame.add(password);
        frame.add(password_field);
        frame.add(confirm_password);
        frame.add(confirm_password_field);
        frame.add(email_warning);
        frame.add(diff_warning);
        frame.add(create_account_button);
        frame.add(back_to_login);
        frame.add(confirm_email);
        frame.add(otp_entering);

        // frame configurations
        frame.setTitle("Join our community: FARLEAF INDUSTRIES!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setIconImage(icon.getImage());
    }

    public void checkPasswordConfirmation() {
        String initialPassword = new String(password_field.getPassword());
        confirmPassword = new String(confirm_password_field.getPassword());

        if (!confirmPassword.equals(initialPassword)) {
            diff_warning.setVisible(true);
        } else {
            diff_warning.setVisible(false);
        }
    }



    // check whether the email has an @ or not
    public void checkEmail() {
        users_email = new String(email_field.getText());
        // System.out.println("Checking: " + users_email);

        if (!users_email.contains("@")) {
            email_warning.setVisible(true);
        } else {
            email_warning.setVisible(false);
        }
    }

    // to check whether the user has confirmed their email or not, making changes whether they can create account or not yet
    boolean email_confirm_done = false;
    public void confirmEmailButton(ActionEvent e) {
        if (e.getSource() == confirm_email) {
            // generating a 6-digit otp code to send to the users' email
            Random random = new Random();
            otp = random.nextInt(900000)+1;

            ApplicationContext context = SpringApplication.run(SenderemailApplication.class);
            EmailSender emailsen = context.getBean(EmailSender.class);
            emailsen.sendEmail(users_email, "Verification Code", Integer.toString(otp));
            
            String userInput = JOptionPane.showInputDialog(frame, "Enter OTP:");
            int user_input_otp = Integer.parseInt(userInput);
            
            if (otp == user_input_otp) {
                JOptionPane.showMessageDialog(frame, "Correct! Verified!");
                email_confirm_done = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong! Try again!");
                email_confirm_done = false;
            }
        }
    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create_account_button || e.getSource() == back_to_login) {
            username_user = new String(username_field.getText());
            Data data = new Data(username_user, users_email, confirmPassword);
            System.out.println("Username: " + username_user);
            System.out.println("Email: " + users_email);
            System.out.println("Password: " + confirmPassword);
            if (email_confirm_done) {
                data.saveToDatabase();
                LoginScreen login_screen = new LoginScreen();
                frame.dispose(); // throw the screen
                email_confirm_done = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Verify your account!");
            }
            
            } else if (e.getSource() == confirm_email) {
                confirmEmailButton(e);
            }
        }
}
