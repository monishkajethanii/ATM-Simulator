package ATM_Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import adv.*;

public class Login1 extends JFrame implements ActionListener {
    JPanel inputPanel;
    JLabel titleLabel, emailLabel, passwordLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton signInButton, signUpButton;

    public Login1() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null); // Center the frame

        // Create a gradient background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 0), 0, height,
                        new Color(0, 0, 0));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        setContentPane(backgroundPanel);

        // Title
        titleLabel = new JLabel("Sign in to your account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        setForeground(Color.WHITE);

        // Input Panel
        inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        emailLabel = new JLabel("Email or username:");
        emailField = new JTextField(20);

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(emailLabel, gbc);
        gbc.gridy++;
        inputPanel.add(emailField, gbc);
        gbc.gridy++;
        inputPanel.add(passwordLabel, gbc);
        gbc.gridy++;
        inputPanel.add(passwordField, gbc);

        // Button Panel
        signInButton = new JButton("SIGN IN");
        signUpButton = new JButton("SIGN UP");
        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);

        // Add components to the content pane
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==signInButton){
        SignIn si=new SignIn();
        setVisible(false);
        si.setVisible(true);
      }

        if(ae.getSource()==signUpButton){
            SignUpOne so=new SignUpOne();
            setVisible(false);
            so.setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login1();
    }
}
