package haribo4ever.commons;

public class Chronometre {

	private static long start;
	private static long stop;
	
	public static void start() {
		// TODO Auto-generated method stub
		start = System.currentTimeMillis();
	}
	public static void stop() {
		stop = System.currentTimeMillis();
	}
	
	public static long getTemps() {
		return stop - start;
		
	}

}
