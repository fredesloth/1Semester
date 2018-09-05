package measure;

import java.util.concurrent.TimeUnit;

public class Measurer {
    private static long startTime;
    private static long stopTime;
    
    public static void start() {
        startTime = System.nanoTime();
    }
    
    public static void stop() {
        stopTime = System.nanoTime();
    }
    
    public static long durationInSeconds() {
        return TimeUnit.SECONDS.convert(stopTime - startTime, TimeUnit.NANOSECONDS);
    }
    
    public static long durationInMilliSeconds() {
        return TimeUnit.MILLISECONDS.convert(stopTime - startTime, TimeUnit.NANOSECONDS);
    }

}
