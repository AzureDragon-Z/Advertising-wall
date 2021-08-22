package ch4.data;
import java.sql.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;

public class ModifyADContent extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean modifyADContent(Advertisement ad) {
        connectDatabase();    //链接数据库
        if (con == null || login == null) {
            return false;
        }
        if (login.getLoginSuccess() == false) {
            return false;
        }
        boolean success = false;

        //将对应id的数据写入输入库guanggao_table中，
        PreparedStatement preSql;
        String sqlStr = "update guanggao_table set content = ? where serialNumber = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            String content = ad.getContent();       //获取文本内容
            preSql.setString(1, content);
            preSql.setString(2, login.getID() + ad.getSerialNumber());
            int isOK = preSql.executeUpdate();
            if (isOK != 0) {
                success = true;
            } else {
                success = false;
            }
            con.close();
        } catch (Exception e) {
            success = false;
        }
        return success;
    }
}

