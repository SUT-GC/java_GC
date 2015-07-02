package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Dao {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://127.0.0.1:3306/gc1";
		String user = "root";
		String pass = "gc";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
	}
}
