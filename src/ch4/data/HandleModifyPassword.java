package ch4.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HandleModifyPassword extends ConnectDatabase{
    public boolean handleModifyPassword(Login  login) {
        connectDatabase();//连接数据库（继承的方法）
        boolean isSuccess = false;
        if (con == null) {
            return false;
        }
        PreparedStatement preSql;
        String sqlStr = "update register_table set password = ? where id = ?";
        int ok = 0;
        try {
            preSql = con.prepareStatement(sqlStr);
            String id = login.getID();
            String pw = login.getPassword();

            pw = Encrypt.encrypt(pw, "mimajiami");//把用户密码加密
            preSql.setString(1, pw);
            preSql.setString(2, id);
            ok = preSql.executeUpdate();
            con.close();
        }
        catch(SQLException e) {}
        if (ok != 0) {
            isSuccess = true;
        }
        return isSuccess;
    }
}


