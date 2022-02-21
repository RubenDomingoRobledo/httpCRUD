package WeatherAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GET {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.tomorrow.io/v4/timelines?location=-73.98529171943665,40.75872069597532&fields=temperature&timesteps=1h&units=metric&apikey=vPWoQVZvS9quyaCnWv4SIGkXhRixyu3k"))
                .setHeader("NombreHeader", "Header Http")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        HttpHeaders headers = response.headers();
        headers.map().forEach((clave, valor) -> System.out.println(clave + ":" + valor));

        System.out.println(response.statusCode());

        System.out.println(response.body());
    }
}
