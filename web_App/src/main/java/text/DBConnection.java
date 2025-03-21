package text;
import java.sql.*;
public class DBConnection
{
private static Connection con;
private DBConnection() {}
static
{
	try {
		Class.forName(DBInformation.driver);
		con=
DriverManager.getConnection(DBInformation.dbURL,DBInformation.dbUName,DBInformation.dbPWord);
	}catch(Exception e) {
		e.printStackTrace();
	}//end of catch
	}//end of block
public static Connection getCon() {
	return con;
}
}
