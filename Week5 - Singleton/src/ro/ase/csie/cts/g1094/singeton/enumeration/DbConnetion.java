package ro.ase.csie.cts.g1094.singeton.enumeration;

public enum DbConnetion {
	
	DEV_DB;
	
	
	String connString;
	String schema;
	
	private DbConnetion() {
		System.out.println("Loading settings from the conf file");			
	}
	
	
}
