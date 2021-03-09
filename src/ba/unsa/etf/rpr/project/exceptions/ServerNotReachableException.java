package ba.unsa.etf.rpr.project.exceptions;

import java.net.ConnectException;

public class ServerNotReachableException extends ConnectException {
    public ServerNotReachableException(String s) {
        super(s);
    }
}
