package cl.velasquezabel.eyjava.logging;

import java.util.HashMap;
import java.util.Map;

public final class LoggingUtil {
	private static Map<String,Logger> loggerMap = new HashMap<String, Logger>();
	private LoggingUtil(){
		
	}
	
	public static <C> Logger<C> getLogger( Class<C> c ){
		String p = c.getPackage().getName();
		String className = c.getName();
		String loggerKey = p.concat(".").concat(className);
		Logger<C> logger = loggerMap.get(loggerKey);
		if( logger == null ){
			logger = new Logger<C>();
			loggerMap.put(loggerKey, logger);
		}
		return logger;
	}
}
