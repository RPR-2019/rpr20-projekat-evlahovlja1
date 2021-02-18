package ba.unsa.etf.rpr.project.utilities;

public class ServerConfig {
    public static final String HOSTNAME = "http://localhost";
    public static final String PORT = "8080";
    public static final String CRED = "cred";

    public static String getServer() {
        return HOSTNAME+":"+PORT;
    }
    public static String getCredServer() {
        return HOSTNAME+":"+PORT+"/"+CRED;
    }
    public static String getHost() {
        return HOSTNAME.split("//")[1];
    }
}
