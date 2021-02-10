package ba.unsa.etf.rpr.project.utilities;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;

public class Json {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    Gson gson = new Gson();

    public static String sendPost(String url, String payload) throws Exception {
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(payload));
        post.setHeader("Accept", "text/plain");
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
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
