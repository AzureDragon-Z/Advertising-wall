package ch4.data;

import java.sql.*;

public class DelAdvertisement extends ConnectDatabase{
    Login login;
    public void setLogin(Login login) {
        this.login = login;
    }
    public boolean delAdvertisement(String serialNumber) {
        boolean success = false;
        connectDatabase();//连接数据库
        PreparedStatement preSql;
        if (con == null || login == null) {
            return false;
        }
        if (login.getLoginSuccess() == false) {
            return false;
        }
        connectDatabase();
        String SQL = "delete from guanggao_table where serialNumber = ?";
        try {
            preSql = con.prepareStatement(SQL);
            preSql.setString(1, login.getID()+serialNumber);
            int isOK = preSql.executeUpdate();
            if (isOK != 0) {
                success = true;
            }
            else {
                success = false;
            }
            con.close();
        }
        catch (SQLException e) {
            success = false;
        }
        return success;
    }
}

