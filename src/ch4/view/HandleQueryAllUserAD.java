package ch4.view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import ch4.data.*;

public class HandleQueryAllUserAD implements ActionListener {
    QueryAllUserAD queryAll;
    QueryAllUserADView view;

    public HandleQueryAllUserAD() { //构造函数
        queryAll = new QueryAllUserAD();
    }

    public void actionPerformed(ActionEvent e) {
        queryAll.setLogin(view.login);
        if(view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null, "请先登录", "消息对话框", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        Advertisement [] ad = queryAll.queryAllUser();
        if (ad == null) {
            return ;
        }
        AdvertisingBoard board = new AdvertisingBoard();	//创建广告牌
        board.setAdvertisement(ad);  		//在广告牌上设置广告
        view.pCenter.setAdvertisingBoard(board);//在视图上显示广告牌
        view.pCenter.next.doClick();
    }

    public void setView(QueryAllUserADView view) {
        this.view = view;
    }
}

