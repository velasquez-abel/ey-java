package cl.velasquezabel.eyjava.logging;

public class Logger<T> {
	protected <T>Logger(){
		
	}
	public void error(String m){
		System.out.println( "ERROR: ".concat( m ) );
	}
	public void info(String m){
		System.out.println( "INFO: ".concat( m ) );
	}
	public void warning(String m){
		System.out.println( "WARNING: ".concat( m ) );
	}
	public void fatal(String m){
		System.out.println( "FATAL: ".concat( m ) );
	}
	public void debug(String m){
		System.out.println( "DEBUG: ".concat( m ) );
	}
	public void error(Exception m){
		System.out.println( "ERROR: ".concat( m.getMessage() ) );
	}
	public void info(Exception m){
		System.out.println( "INFO: ".concat( m.getMessage() ) );
	}
	public void warning(Exception m){
		System.out.println( "WARNING: ".concat( m.getMessage() ) );
	}
	public void fatal(Exception m){
		System.out.println( "FATAL: ".concat( m.getMessage() ) );
	}
	public void debug(Exception m){
		System.out.println( "DEBUG: ".concat( m.getMessage() ) );
	}
}
