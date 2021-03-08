package Helper;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataHelper {
	private Connection con;
	private Statement stmt;

	public Boolean getConnection() {
		boolean isDBconnectionOpen = true;
		try {
			FileReader reader = new FileReader("D:\\eclipse\\ab\\jj\\Properties\\DBdetails.properties");
			Properties p = new Properties();
			p.load(reader);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.10:1521:xe", p.getProperty("user"),
					p.getProperty("password"));
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println(e);
			isDBconnectionOpen = false;
		}
		return isDBconnectionOpen;
	}

	public void closeConnection() {
		final String methodName = "closeConnection";
		if (null == con) {
			return;
		}
		if (null != con) {
			try {
				stmt = null;
				con.close();
				con = null;
			} catch (SQLException ex) {
				con = null;
			}
		}
	}

	public void insertvalues() {
		try {
			getConnection();
			stmt = con.createStatement();
			int result = stmt.executeUpdate("insert into abhi(Id,firstname,lastname) values('2','Ranjith','Kumar')");
			ResultSet rs = stmt.executeQuery("select * from abhi");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(" ");
		}
	}

	public void update() {
		try {
			getConnection();
			stmt = con.createStatement();
			int result = stmt.executeUpdate("update abhi set firstname='john',lastname='Benner' where id=2");
			ResultSet rs = stmt.executeQuery("select * from abhi");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(" ");
		}
	}

	public void delete() {
		try {
			getConnection();
			stmt = con.createStatement();
			int result = stmt.executeUpdate("delete from abhi where id=2");
			ResultSet rs = stmt.executeQuery("select * from abhi");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
