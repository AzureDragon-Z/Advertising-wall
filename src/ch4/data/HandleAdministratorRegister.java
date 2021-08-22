package ch4.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HandleAdministratorRegister extends ConnectDatabase{
    public boolean handleAdministratorRegister(Register register) {
        connectDatabase();//连接数据库（继承的方法）
        boolean isSuccess = false;
        if (con == null) {
            return false;
        }
        PreparedStatement preSql;
        String sqlStr = "insert into administrator_table values(?,?)";
        int ok = 0;
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, register.getID());
            String pw = register.getPassword();
            pw = Encrypt.encrypt(pw, "mimajiami");//把用户密码加密
            preSql.setString(2, pw);
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
