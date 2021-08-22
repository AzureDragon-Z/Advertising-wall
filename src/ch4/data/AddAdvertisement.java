package ch4.data;

import java.sql.*;
import java.io.*;

public class AddAdvertisement extends ConnectDatabase{
    Login login;
    public void setLogin(Login login) {
        this.login = login;
    }
    public boolean addAdvertisement(Advertisement ad) {
        connectDatabase();	//链接数据库
        if (con == null || login == null) {
            return false;
        }
        if (login.getLoginSuccess() == false) {
            return false;
        }
        boolean success = false;

        //将对应id的数据写入输入库guanggao_table中，
        PreparedStatement preSql;
        String sqlStr = "insert into guanggao_table values(?,?,?,?)";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, login.getID());
            String content = ad.getContent();
            preSql.setString(2, content);
            File f = ad.getPictureFile();
            InputStream in = new FileInputStream(f);
            int length = in.available();
            preSql.setBinaryStream(3, in, length);
            preSql.setString(4, login.getID()+ad.getSerialNumber());
            int isOK = preSql.executeUpdate();
            if (isOK != 0) {
                success = true;
            }
            else {
                success = false;
            }
            con.close();
        }
        catch (Exception e) {
            success = false;
        }
        return success;
    }
}

