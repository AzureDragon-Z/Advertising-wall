package ch4.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;

public class DeleUserByAdministrator extends ConnectDatabase{
    Login login;
    public void setLogin(Login login) {
        this.login = login;
    }
    public boolean deleUserByAdministrator(Login login) {
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
        String sqlStr = "delete from register_table where id = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, login.getID());
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
