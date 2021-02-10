package ba.unsa.etf.rpr.project.utilities;

public class ServerConfig {
    public static final String HOSTNAME = "http://localhost";
    public static final String PORT = "8080";

    public static String getServer() {
        return HOSTNAME+":"+PORT;
    }
}
