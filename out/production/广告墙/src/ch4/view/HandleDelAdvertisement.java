package ch4.view;

import ch4.data.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

//负责处理删除广告的视图上的ActionEvent事件
public class HandleDelAdvertisement implements ActionListener {
    DelAdvertisementView view;		//删除广告的视图
    DelAdvertisement delAdvertisement; 	//负责删除广告的对象
    public HandleDelAdvertisement() {
        delAdvertisement = new DelAdvertisement();
    }

    public void actionPerformed(ActionEvent e) {
        delAdvertisement.setLogin(view.login);
        if (view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null, "请先登录", "消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String number = view.inputSerialNumber.getText().trim();
        boolean boo = delAdvertisement.delAdvertisement(number);//删除操作
        if (boo) {
            view.hintMess.setText("删除成功");
        }
        else {
            view.hintMess.setText("删除失败，没有该广告");
        }
    }

    public void setView(DelAdvertisementView view) {
        this.view = view;
    }
}

