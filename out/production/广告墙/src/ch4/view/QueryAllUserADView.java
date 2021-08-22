package ch4.view;

import javax.swing.*;
import java.awt.*;
import ch4.data.Login;

public class QueryAllUserADView extends JPanel {	//查询全部广告的视图
    public Login login;
    JButton submit;		//提交按钮
    public AdvertisingBoardView pCenter;	//广告牌
    HandleQueryAllUserAD handleQueryAllUserAD;	//负责查询所有广告

    QueryAllUserADView(){
        initView();
        registerListener();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        pCenter = new AdvertisingBoardView();
        submit = new JButton("浏览全部广告");
        pNorth.add(submit);
        add(pNorth, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
    }

    private void registerListener() {
        handleQueryAllUserAD = new HandleQueryAllUserAD();
        handleQueryAllUserAD.setView(this);
        submit.addActionListener(handleQueryAllUserAD);
    }

}
