package ch4.data;

import java.sql.*;

public class ConnectDatabase {
    Connection con;
    public final void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   //加载jdbc驱动
//	            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
//	            System.out.println("数据库驱动加载失败");
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/guanggao_db?useSSL=false&serverTimezone=Hongkong",
                    "root","zhao0409");   //连接代码
	            System.out.println("数据库连接成功");
        } catch (SQLException e) {
//	            System.out.println("数据库连接失败");
        }
    }
}
