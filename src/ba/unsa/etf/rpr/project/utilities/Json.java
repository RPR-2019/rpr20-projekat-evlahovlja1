package ba.unsa.etf.rpr.project.utilities;

import ba.unsa.etf.rpr.project.exceptions.ServerNotReachableException;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.SocketException;
import java.util.HashMap;

public class Json {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    Gson gson = new Gson();

    public static String sendPost(String url, String payload) throws Exception {
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Connection-Timeout", "5");
            post.setHeader("Request-Timeout", "5");
            post.setHeader("Accept", "text/plain");
            post.setHeader("Content-type", "application/json");
            post.setHeader("charset","utf-8");
            post.setEntity(new StringEntity(payload));
            HttpResponse response = httpClient.execute(post);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        catch (SocketException e) {
            throw new ServerNotReachableException("Server trenutno nedostupan");
        }
    }

    public static String generatePayload(HashMap<String, String> keyVal) {
        String ret = "{";

        for (var o : keyVal.entrySet()) {
            ret += "\"" + o.getKey() + "\": \"" + o.getValue() + "\", ";
        }
        ret = ret.trim();
        ret = ret.substring(0, ret.length()-1);

        ret += "}";
        return ret;
    }
}
