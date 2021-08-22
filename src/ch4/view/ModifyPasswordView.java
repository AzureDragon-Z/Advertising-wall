package ch4.view;
import ch4.data.HandleModifyPassword;
import ch4.data.Login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//extends JPanel implements ActionListener
public class ModifyPasswordView extends JPanel implements ActionListener{
    public Login login;
    JTextField inputID;
    JPasswordField inputModifiedPassword; //输入修改后的密码
    JPasswordField againModifiedPassword;	//再次输入修改后的密码
    JButton buttonModify;

    public void setLogin(Login login) {
        this.login = login;
    }
    ModifyPasswordView() {	//无参构造函数
        inputID = new JTextField(12);
        inputModifiedPassword = new JPasswordField(12);
        againModifiedPassword = new JPasswordField(12);
        buttonModify = new JButton("修改");
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("修改密码:"));
        add(inputModifiedPassword);
        add(new JLabel("再次输入修改后密码"));
        add(againModifiedPassword);
        add(buttonModify);
        buttonModify.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String id = inputID.getText().trim();
        char[] pw = inputModifiedPassword.getPassword();
        char[] pw_again = againModifiedPassword.getPassword();
        String pwStr = new String(pw).trim();
        String pw_againStr = new String(pw_again).trim();
        if (pwStr.equals(pw_againStr)) {
            login.setID(id);
            login.setPassword(new String(pw));
            HandleModifyPassword handleModifyPassword = new HandleModifyPassword();
            boolean boo = handleModifyPassword.handleModifyPassword(login);
            if (boo) {
                JOptionPane.showMessageDialog(null, "修改成功","消息对话框", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "两次输入密码不同", "消息对话框", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
