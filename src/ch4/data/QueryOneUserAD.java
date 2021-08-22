package ch4.data;

import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

public class QueryOneUserAD extends ConnectDatabase{
    Login login;
    public void setLogin(Login login) {
        this.login = login;
    }
    public Advertisement[] queryOneUser(String id) {
        connectDatabase();//连接数据库
        if (con == null || login == null) {
            return null;
        }
        if (login.getLoginSuccess() == false) {
            return null;
        }
        Advertisement [] ad = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from guanggao_table where id = '"+id+"'");
            rs.last();
            int recordAmount = rs.getRow();//结果集中的全部记录
            ad = new Advertisement[recordAmount];
            for (int i = 0; i < ad.length; i++) {
                ad[i] = new Advertisement();
            }
            rs.beforeFirst();
            int i = 0;
            while(rs.next()) {
                ad[i].setID(id);
                ad[i].setContent(rs.getString("content"));
                InputStream in = rs.getBinaryStream("imageFile");
                int length = in.available();
                byte[] b = new byte[length];
                in.read(b);
                in.close();
                Image img = Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number = rs.getString("serialNumber");
                int index = id.length();//	找到id结束的位置
                number = number.substring(index);
                ad[i].setSerialNumber(number);
                i++;
            }
            con.close();
        }
        catch (Exception e) {}
        return ad;
    }
}
