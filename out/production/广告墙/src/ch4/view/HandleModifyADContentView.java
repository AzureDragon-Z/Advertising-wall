package ch4.view;

import ch4.data.Advertisement;
import ch4.data.ModifyADContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleModifyADContentView implements ActionListener {
    ModifyADContentView view;
    ModifyADContent modifyADContent;
    Advertisement ad;
    public HandleModifyADContentView() {
        modifyADContent = new ModifyADContent();
        ad = new Advertisement();
    }

    public void actionPerformed(ActionEvent e) {
        modifyADContent.setLogin(view.login);
        if(view.login.getLoginSuccess() == false) {
            JOptionPane.showMessageDialog(null, "请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (e.getSource() == view.submit) {
            String number = view.inputSerialNumber.getText();
            String content = view.inputWord.getText();
            ad.setContent(content);
            ad.setSerialNumber(number);
            boolean boo = modifyADContent.modifyADContent(ad);
            if (boo) {
                view.hintMess.setText("添加成功");
            }
            else {
                view.hintMess.setText("添加失败");
            }
        }
    }

    public void setView(ModifyADContentView view) {
        this.view = view;
    }
}

//    AddAdvertisementView view;
//    AddAdvertisement addAdvertisement;
//    Advertisement ad;
//    public HandleAddAdvertisement() {
//        addAdvertisement = new AddAdvertisement();
//        ad = new Advertisement();
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        addAdvertisement.setLogin(view.login);
//        if(view.login.getLoginSuccess() == false) {
//            JOptionPane.showMessageDialog(null, "请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if(e.getSource() == view.inputPictureFile) {
//            JFileChooser fileDialog = new JFileChooser();
//            int state = fileDialog.showOpenDialog(null);
//            if (state == JFileChooser.APPROVE_OPTION) {
//                try {
//                    File dir = fileDialog.getCurrentDirectory();
//                    String name = fileDialog.getSelectedFile().getName();
//                    File file = new File(dir, name);
//                    ad.setPictureFile(file);
//                }
//                catch (Exception exp) {}
//            }
//        }
//
//        if (e.getSource() == view.submit) {
//            String number = view.inputSerialNumber.getText();
//            String content = view.inputWord.getText();
//            ad.setContent(content);
//            ad.setSerialNumber(number);
//            boolean boo = addAdvertisement.addAdvertisement(ad);
//            if (boo) {
//                view.hintMess.setText("添加成功");
//            }
//            else {
//                view.hintMess.setText("添加失败");
//            }
//        }
//    }
//
//    public void setView(AddAdvertisementView view) {
//        this.view = view;
//    }