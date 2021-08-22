package ch4.view;

import ch4.data.HandleAdministratorRegister;
import ch4.data.HandleRegister;
import ch4.data.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorRegisterView extends JPanel implements ActionListener {
    Register AdministratorRegister;
    JTextField inputID;	//输入ID
    JPasswordField inputPassword; //输入密码
    JPasswordField againPassword;	//再次输入密码
    JButton buttonAdministratorRegister;

    AdministratorRegisterView() {	//无参构造函数
        AdministratorRegister = new Register();
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        againPassword = new JPasswordField(12);
        buttonAdministratorRegister = new JButton("管理员注册");
        add(new JLabel("输入ID"));
        add(inputID);
        add(new JLabel("设置密码:"));
        add(inputPassword);
        add(new JLabel("再次输入密码"));
        add(againPassword);
        add(buttonAdministratorRegister);
        buttonAdministratorRegister.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String id = inputID.getText().trim();
        char [] pw = inputPassword.getPassword();
        char [] pw_again = againPassword.getPassword();
        String pwStr = new String(pw).trim();
        if (id.length() == 0 || pwStr.length() == 0) {
            JOptionPane.showMessageDialog(null, "注册失败","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String pw_againStr = new String(pw_again).trim();
        if(pwStr.equals(pw_againStr)) {
            AdministratorRegister.setID(id);
            AdministratorRegister.setPassword(new String(pw));
            HandleAdministratorRegister handleAdministratorRegister = new HandleAdministratorRegister();
            boolean boo = handleAdministratorRegister.handleAdministratorRegister(AdministratorRegister);
            if (boo) {
                JOptionPane.showMessageDialog(null, "管理员注册成功", "消息对话框", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "注册失败", "id重复换个id,消息对话框", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "两次输入密码不同","消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void main(String [] args) {
        AdministratorRegisterView re = new AdministratorRegisterView();
    }
}
