package ch4.view;

import ch4.data.Login;

import javax.swing.*;

public class DeleUserByAdministrator extends JPanel{
    Login login;
    JTextField inputUserId;		//输入广告的序列号码
    JButton submit;		//提交按钮
    JTextField hintMess;

    HandleDeleUserByAdministrator handleDeleUserByAdministrator;

    DeleUserByAdministrator() {	//构造函数
        initView();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void initView() {
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputUserId = new JTextField(20);
        submit = new JButton("删除用户");
        add(new JLabel("输入用户的id"));
        add(inputUserId);
        add(submit);
        add(hintMess);

    }
}
