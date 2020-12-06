import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userid = new JTextField();
    JPasswordField userpassword = new JPasswordField();
    JLabel useridlabel = new JLabel("User ID:");
    JLabel userpasswordlabel = new JLabel("Password:");
    JLabel Massagelabel = new JLabel();
    HashMap<String, String> Logininfo = new HashMap();

    LoginPage(HashMap<String, String> LogininfoOrig) {
        this.Logininfo = LogininfoOrig;
        this.useridlabel.setBounds(50, 100, 75, 25);
        this.userpasswordlabel.setBounds(50, 150, 150, 25);
        this.Massagelabel.setBounds(125, 250, 250, 35);
        this.Massagelabel.setFont(new Font((String)null, 2, 25));
        this.userid.setBounds(125, 100, 200, 25);
        this.userpassword.setBounds(125, 150, 200, 25);
        this.loginButton.setBounds(125, 200, 100, 25);
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);
        this.resetButton.setBounds(225, 200, 100, 25);
        this.resetButton.addActionListener(this);
        this.frame.add(this.useridlabel);
        this.frame.add(this.userpasswordlabel);
        this.frame.add(this.Massagelabel);
        this.frame.add(this.userid);
        this.frame.add(this.userpassword);
        this.frame.add(this.loginButton);
        this.frame.add(this.resetButton);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);
        this.frame.setBounds(100,100,400,400);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.resetButton) {
            this.userid.setText("");
            this.userpassword.setText("");
        }

        if (e.getSource() == this.loginButton) {
            String userID = this.userid.getText();
            String password = String.valueOf(this.userpassword.getPassword());
            if (this.Logininfo.containsKey(userID)) {
                if (((String)this.Logininfo.get(userID)).equals(password)) {
                    this.Massagelabel.setForeground(Color.blue);
                    this.Massagelabel.setText("Welcome");
                    try {
                        WelcomePage window = new WelcomePage();
                        window.frame.setVisible(true);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    this.Massagelabel.setForeground(Color.red);
                    this.Massagelabel.setText("Invalid password");
                }
            } else {
                this.Massagelabel.setForeground(Color.red);
                this.Massagelabel.setText("Invalid user name");
            }
        }

    }
}
