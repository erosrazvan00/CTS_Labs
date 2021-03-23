package ro.ase.csie.cts.g1094.singeton;

public class DBConnection {
	String connString;
	String schema;
	
	private static DBConnection connection = null;
	
	
	private DBConnection() {
		System.out.println("Creating a connection object");
		System.out.println("Loading configuration ...");
		
		//WE CAN IMPLEMNT THE ATTRIBUTES JUST HERE
		this.connString = "127.0.01";
		this.schema = "cts";
	}

	private DBConnection(String connString, String schema) {
		super();
		this.connString = connString;
		this.schema = schema;
	}
	
//SINGLETON - PREVENTING MULTIPLE OBJECTS	
	public static DBConnection getConnection() {
		if(DBConnection.connection == null) {
			connection = new DBConnection();
		}
		return DBConnection.connection;
	}
	
//IT'S NOT CLEAN
//IT'S MISLAEDING - OTHERS WILL THINK THEY HAVE MULTIPLE CONNECTIONS
	public static DBConnection getConnection(String connString, String schema) {
		if(DBConnection.connection == null) {
			connection = new DBConnection();
		}
		return DBConnection.connection;
	}
	
}
