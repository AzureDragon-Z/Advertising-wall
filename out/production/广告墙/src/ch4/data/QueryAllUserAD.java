package ch4.data;

import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

public class QueryAllUserAD extends ConnectDatabase{	//负责全部广告的查询
    Login login;
    public void setLogin(Login login) {
        this.login = login;
    }
    public Advertisement [] queryAllUser() {
        connectDatabase();	//连接数据库
        if (con == null || login == null) {
            return null;
        }
        if (login.getLoginSuccess() == false) {
            return null;
        }
        Advertisement[] ad = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from guanggao_table");
            rs.last();
            int recordAmount = rs.getRow();//结果集中额全部记录
            ad = new Advertisement[recordAmount];
            for (int i = 0; i < ad.length; i++) {
                ad[i] = new Advertisement();
            }
            rs.beforeFirst();
            int i = 0;
            while(rs.next()) {
                String id = rs.getString(1);
                ad[i].setID(id);
                ad[i].setContent(rs.getString(2));
                InputStream in = rs.getBinaryStream(3);
                int length = in.available();
                byte [] b= new byte[length];
                in.read(b);
                in.close();
                Image img = Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number = rs.getString(4);
                int index = id.length();   //找到id的结束位置
                number = number.substring(index);
                ad[i].setSerialNumber(number);
                i++;
            }
            con.close();
        }
        catch(Exception e) {}
        return ad;
    }

}

