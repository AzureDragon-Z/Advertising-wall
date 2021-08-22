package ch4.data;

import java.io.File;
import java.awt.Image;


public class Advertisement {
    String ID;		//广告的ID
    String content;		//广告的文本
    File pictureFile;	//广告的图片文件
    Image image;		//广告图片
    String serialNumber;//广告编号


    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public File getPictureFile() {
        return pictureFile;
    }
    public void setPictureFile(File pictureFile) {
        this.pictureFile = pictureFile;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}

