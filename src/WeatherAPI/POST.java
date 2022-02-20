package WeatherAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class POST {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception {
    	
    	String weather = new StringBuilder()
                .append("{")
                .append("\"ciudad\":\"Barcelona\",")
                .append("\"tiempo\":\"Soleado\",")
                .append("\"temperatura\":\"17\"")
                .append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(weather))
                .uri(URI.create("https://www.tomorrow.io/weather/US/MA/Boston/112589/hourly/post"))
                .setHeader("NombreHeader", "Header Http")
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        System.out.println(response.body());
    }
}