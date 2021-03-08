package dbConnection;

import Helper.DataHelper;

public class DBOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataHelper datahelper = new DataHelper();
		datahelper.getConnection();
		datahelper.insertvalues();
		datahelper.update();
		datahelper.delete();
		datahelper.closeConnection();

	}

}
