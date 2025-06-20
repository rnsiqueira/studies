package sc_21;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * Shows example of Structured Concurrency in JDK 21.
 */
public class Server {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Server server = new Server();
        Response response = server.handleVacation(new Request("Xander", "Cage", "Bengaluru", 10));
        System.out.println("Xander Cage, enjoy your vacation...");

        System.out.println("\nWeather : " + response.weather());
        System.out.println("\nActivities : " + response.activity());
        System.out.println("\nRestaurants : " + response.restaurants());
    }


    public Response handleVacation(Request request)
            throws InterruptedException, ExecutionException {

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            Supplier<Weather> weather = scope.fork(() -> WeatherService.fetch(request));
            var activities = scope.fork(() -> ActivityService.fetch(request));
            var restaurants = scope.fork(() -> RestaurantService.fetch(request));

            scope.join()
                    .throwIfFailed();

            return new Response(request, weather.get(), activities.get(), restaurants.get());
        }
    }

}