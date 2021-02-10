package ba.unsa.etf.rpr.project.utilities;

public class Threading {
    public static void runOnAnotherThread(Runnable func) {
        new Thread(func).start();
    }
}
