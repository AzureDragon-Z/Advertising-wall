package ch4.view;

import java.awt.*;
import javax.swing.*;

public class ShowImageDialog extends JDialog {
    Image img;
    ShowImageDialog(Image img) {	//构造函数
        this.img = img;
        setLocation(100,100);
        setTitle("广告墙图片");
        setSize(800, 570);
        GiveImage image = new GiveImage();
        add(image);
        setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class GiveImage extends JPanel {	//内部类，专门为该对话框提供图片
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getBounds().width, getBounds().height, this);
        }
    }
}

