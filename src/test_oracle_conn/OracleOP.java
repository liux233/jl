package test_oracle_conn;

/*
 * can connect oracle but sql not friend
 * author:liux
 * date:2017-7-20 12:57
 * version:0.0.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleOP {
	private final String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:xe";
	private String oracleUsername;
	private String oraclePassword;
	
	Connection con;
	PreparedStatement pre;
	ResultSet result;
	
	String sql;

	public OracleOP(String oracleusername, String oraclepassword){
		this.oracleUsername = oracleusername;
		this.oraclePassword = oraclepassword;
		this.con = null;
		this.pre = null;
		this.result = null;
		this.sql = null;
	}
	
	public OracleOP() {
		this.oracleUsername = "xiaoliu";
		this.oraclePassword = "123456";
		this.con = null;
		this.pre = null;
		this.result = null;
		this.sql = null;
	}
	
	void connectOracle() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //load driver
			System.out.println("start try to connect db");
			con = DriverManager.getConnection(url, oracleUsername, oraclePassword);
			System.out.println("connect success!");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	void disconnectOracle() {
		try{
			if(result != null) {
				result.close();
			} 
			if(pre != null) {
				pre.close();
			}
			if(con != null) {
				con.close();
			}
			System.out.println("db has benn closed!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public void testOracle(String sql) {
		try
	    {
	        //String sql = "select * from goods where name = ? and price = ? ";// 预编译语句，“？”代表参数
	        //String sql = "select * from goods ";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, "computer");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        pre.setString(2, "5000");
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        while (result.next())
	            // 当结果集不为空时
	            System.out.println( "name:" + result.getString("name") + "  price:" + result.getInt("price") + "  amount:" + result.getInt("amount"));
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	
	public  void testOracle() {
	    try
	    {
	        //String sql = "select * from goods where name = ? and price = ? ";// 预编译语句，“？”代表参数
	        //String sql = "select * from goods ";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(this.sql);// 实例化预编译语句
	        //pre.setString(1, "computer");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        //pre.setString(2, "5000");
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        while (result.next())
	            // 当结果集不为空时
	            System.out.println( "name:" + result.getString("name") + "  price:" + result.getInt("price") + "  amount:" + result.getInt("amount"));
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
}
