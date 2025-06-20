package java21;


import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.Objects;


public class NetworkService {

    /**
     * The get API utilizes types to handle exceptions.
     * The NetworkResult interface is a sealed interface, it has 4 different types.
     * @param uri -The uri to call
     * @return The type of the result from the network call
     */
    public <T> NetworkResult<T> get(String uri) {

        Objects.requireNonNull(uri);

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return new Success<>(response.body());
        } catch (IOException e) {
            return switch (e) {
                case HttpTimeoutException timeout -> new Timeout<>("HttpTimeOut,Retry after 2 seconds:" + timeout.getMessage());
                case ConnectException connectException -> new Timeout<>("Could not connect to host and port");
                default -> new Failure<>(e.getCause());
            };
        } catch (InterruptedException e) {
            return new Interrupted<>(e);
        }
    }
}