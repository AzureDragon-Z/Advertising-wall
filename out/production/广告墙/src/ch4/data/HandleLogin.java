package ch4.data;

import java.sql.*;

public class HandleLogin extends ConnectDatabase {
    public Login handleLogin(Login login) {
        connectDatabase(); 	//连接数据库（继承的方法）
        PreparedStatement preSql;
        ResultSet rs;
        if (con == null) {
            login.setLoginSuccess(false);
            return login;
        }
        String id = login.getID();
        String pw = login.getPassword();
        String sqlStr = "select id, password from register_table where " + "id = ? and password = ? ";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, id);
            pw = Encrypt.encrypt(pw,"mimajiami");  //把用户密码加密
            preSql.setString(2, pw);
            rs = preSql.executeQuery();
            if (rs.next()==true) {
                login.setLoginSuccess(true);
            }
            else {
                login.setLoginSuccess(false);
            }
            con.close();
        }
        catch (SQLException e) {
            login.setLoginSuccess(false);
        }
        return login;
    }
}
