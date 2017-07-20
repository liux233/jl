package test_oracle_conn;



public class Test_conn {
	
	
	public static void main(String[] args)
    {
		OracleOP op = new OracleOP();
		op.connectOracle();
		op.setSql("select * from goods ");
		op.testOracle();
		op.testOracle("select * from goods where name = ? and price = ?"); 
		//op.testOracle("select * from goods where name = book and price = 34"); //why book 标识符无效???
		//如果有where必须用?   ???
		op.disconnectOracle();
   }
}
