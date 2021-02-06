package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class SplashScreen {


    public void loginAction(ActionEvent actionEvent) throws Exception {
        Gson gson = new Gson();
        HttpPost post = new HttpPost("http://localhost:8080");
        List<NameValuePair> podaciZaPOST = new ArrayList<>();

        User user = new User(
                null,
                "test",
                "testovic",
                'F',
                LocalDate.of(2000, 01, 01),
                Period.between(LocalDate.of(2000, 01, 01), LocalDate.now()).getYears(),
                "Varvare",
                false,
                "ETF",
                "C#",
                "beze nesto"
        );

        /*
        {
"name": "test",
  "lastname": "testovic",
  "gender": "M",
  "dateOfBirth": "2000-01-01",
  "city": "Varvare",
  "student": true,
  "institution": "ETF",
  "favoriteLanguage": "C#",
  "about": "test test test, nista posebno"
}

         */
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        podaciZaPOST.add(new BasicNameValuePair("name", "test"));
//        podaciZaPOST.add(new BasicNameValuePair("lastname", "testovic"));
//        podaciZaPOST.add(new BasicNameValuePair("gender", "F"));
//        podaciZaPOST.add(new BasicNameValuePair("dateOfBirth", "2000-01-01"));
//        podaciZaPOST.add(new BasicNameValuePair("city", "Varvare"));
//        podaciZaPOST.add(new BasicNameValuePair("student", "false"));
//        podaciZaPOST.add(new BasicNameValuePair("institution", "ETf"));
//        podaciZaPOST.add(new BasicNameValuePair("favoriteLanguage", "C#"));
//        podaciZaPOST.add(new BasicNameValuePair("about", "test test test nista posebno"));
        post.setEntity(new StringEntity(user.getJsonFormat()));
        post.setHeader("Accept", "text/plain");
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        System.out.println(response.getStatusLine().toString());
    }
}
