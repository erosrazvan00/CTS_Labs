package ro.ase.csie.cts.g1094.singeton;

public class TestSingleton {

	public static void main(String[] args) {
		
		//DBConnection con1 = new DBConnection();
		//..
		//DBConnection con2 = new DBConnection();
		
		//DBConnection con1 = new DBConnection("1.2.445", "cts");
		
		//DBConnection con1 = DBConnection.getConnection();
		//DBConnection con2 = DBConnection.getConnection();
		//DBConnection con3 = DBConnection.getConnection();
		//x
		
		DBConnection con1 = DBConnection.getConnection("127.0.0.1:1443", "cts");
		DBConnection con2 = DBConnection.getConnection("127.0.0.1:1443", "cts");
		
		DBConnection con3 = DBConnection.getConnection("10.0.0.1:1443", "productionDB");
		
		if(con1 == con2) {
			System.out.println("They point to the same DB");
		}
	}

}
