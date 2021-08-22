package ch4.view;

import ch4.data.*;
import javax.swing.*;
import java.awt.*;

public class DelAdvertisementView extends JPanel{	//删除广告的视图
    Login login;
    JTextField inputSerialNumber;		//输入广告的序列号码
    JButton submit;		//提交按钮
    JTextField hintMess;

    HandleDelAdvertisement handleDelAdvertisement;	//负责删除广告

    DelAdvertisementView() {	//构造函数
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void initView() {
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        inputSerialNumber = new JTextField(20);
        submit = new JButton("删除广告");
        add(new JLabel("输入广告的序列号码"));
        add(inputSerialNumber);
        add(submit);
        add(hintMess);
    }

    private void registerListener() {
        handleDelAdvertisement = new HandleDelAdvertisement();
        handleDelAdvertisement.setView(this);
        submit.addActionListener(handleDelAdvertisement);
    }
}

