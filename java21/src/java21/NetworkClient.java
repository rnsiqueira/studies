package java21;


import java.util.Objects;

public class NetworkClient {

    private final NetworkService networkService;

    public NetworkClient(NetworkService networkService) {
        this.networkService = networkService;
    }

    public NetworkResponse fetchData(String uri) {

        Objects.requireNonNull(uri);
        NetworkResult<?> result = networkService.get(uri);
        return switch (result) {
            case Success(var response) -> new NetworkResponse(response, NetworkResult.State.SUCCESS);
            case Failure(Throwable cause) -> new NetworkResponse(cause.getMessage(), NetworkResult.State.FAILED);
            case Interrupted(InterruptedException ie) -> new NetworkResponse(ie.getMessage(), NetworkResult.State.INTERRUPTED);
            case Timeout(var reason) -> new NetworkResponse(reason, NetworkResult.State.TIMEOUT);
        };
    }
}
