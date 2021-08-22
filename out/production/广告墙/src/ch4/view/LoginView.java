package ch4.view;

import ch4.data.*;
import javax.swing.*;
import java.awt.event.*;


public class LoginView extends JPanel implements ActionListener{
    Login login;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;//登录
    JButton buttonExit;		//退出登录
    public void setLogin(Login login) {
        this.login = login;
    }

    LoginView() {	//无参构造函数
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonLogin = new JButton("登录");
        buttonExit = new JButton("退出登录");
//        BorderLayout borderLayout = new BorderLayout();
//        setLayout(borderLayout);
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);
        buttonExit.addActionListener(new ActionListener() {	//使用匿名类
            public void actionPerformed(ActionEvent e) {
                login.setLoginSuccess(false);
            }
        });
        buttonLogin.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        login.setID(inputID.getText());
        char [] pw = inputPassword.getPassword();
        login.setPassword(new String(pw));
        HandleLogin handleLogin = new HandleLogin();
        login = handleLogin.handleLogin(login);
        if (login.getLoginSuccess() == true) {
            JOptionPane.showMessageDialog(null, "登录成功","消息对话框", JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "登录失败","消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }


}

