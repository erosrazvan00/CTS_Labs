package ro.ase.csie.cts.g1094.singleton.staticref;

public class DbConnection {
	String connString;
	String schema;
	
	
	//eager instantiation (without anyone to ask)
	//(lazy - wait until someone ask) 
	public static DbConnection connection = new DbConnection();
	
	
	//static class initalizer
	static {
		//called only once before the class is loaded by the JVM
		System.out.println("Hello! DBConnection is loaded");
		connection.connString = "10.0.0.1:1443";
		connection.schema = "tempData";
	}
	
	//constructor initializer
	{
		//called everytime before any constructor call
		System.out.println("Building an object!");
	}
	
	//If you dont define it you get the free public version of it
	private DbConnection() {
		System.out.println("Creating a connection object");
		System.out.println("Loading configuration ...");
		this.connString = "127.0.01";
		this.schema = "cts";
	}

}
