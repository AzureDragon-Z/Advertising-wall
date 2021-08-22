package ch4.view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import ch4.data.*;

//负责处理查询一个用户广告视图上的ActionEvent事件

public class HandleQueryOneUserAD implements ActionListener{
    QueryOneUserADView view;
    QueryOneUserAD query;
    public HandleQueryOneUserAD() {
        query = new QueryOneUserAD();
    }

    public void actionPerformed(ActionEvent e) {
        query.setLogin(view.login);
        if (view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null, "请先登录","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = view.inputID.getText().trim();
        if (id.length() == 0) return;
        Advertisement [] ad = query.queryOneUser(id);
        if (ad == null) return;
        AdvertisingBoard board = new AdvertisingBoard();	//创建广告牌
        board.setAdvertisement(ad);
        view.pCenter.setAdvertisingBoard(board);
        view.pCenter.next.doClick();
    }

    public void setView(QueryOneUserADView view) {
        this.view = view;
    }
}

