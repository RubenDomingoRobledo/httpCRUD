package CRUD;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PeticionPOST {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws IOException, InterruptedException {

        String user = new StringBuilder()
                .append("{")
                .append("\"name\":\"Paco\",")
                .append("\"email\":\"lucia@gmail.com\",")
                .append("\"age\":\"55\",")
                .append("\"date\":\"2020-09-03\"")
                .append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(user))
                .uri(URI.create("http://localhost:8090/api/v1/student"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        System.out.println(response.body());

    }

}