package sc_21;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

/**
 * Service class to fetch weather data.
 */
public class WeatherService {

    private static final Random random = new Random();

    /**
     * Fetches the first successful mock data
     * @param request -The request object
     * @return Weather - Weather data like min & max temp,humidity.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static Weather fetch(Request request) throws ExecutionException, InterruptedException{

        List<Callable<Weather>> weatherTasks = weatherCallables(request);

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<Weather>()) {

            for (var task : weatherTasks) {
                scope.fork(task);
            }
            return scope.join()
                    .result();
        }
    }

    private static List<Callable<Weather>> weatherCallables(Request request) {
        List<Callable<Weather>> weatherCallables = new ArrayList<>();
        weatherCallables.add(() -> fetchFromAsia(request));
        weatherCallables.add(() -> fetchFromAmericas(request));
        weatherCallables.add(() -> fetchFromAfrica(request));

        return weatherCallables;
    }

    private static Weather fetchFromAsia(Request request) throws InterruptedException {
        Duration sleepFor = Duration.of(random.nextInt(30,100), ChronoUnit.MILLIS);
        Thread.sleep(sleepFor);
        System.out.println("Fetching weather for " + request.cityToVisit() +  " from Asia that took " + sleepFor + " milliseconds");
        return new Weather(30.0,40.0,10);
    }

    private static Weather fetchFromAmericas(Request request) throws InterruptedException {
        Duration sleepFor = Duration.of(random.nextInt(60,130), ChronoUnit.MILLIS);
        Thread.sleep(sleepFor);
        System.out.println("Fetching weather for " +request.cityToVisit() + " from Americas that took " + sleepFor + " milliseconds");
        return new Weather(30.1,40.1,10);
    }

    private static Weather fetchFromAfrica(Request request) throws InterruptedException {
        Duration sleepFor = Duration.of(random.nextInt(50,120), ChronoUnit.MILLIS);
        Thread.sleep(sleepFor);
        System.out.println("Fetching weather for " + request.cityToVisit() +" from Africa that took " + sleepFor + " milliseconds");
        return new Weather(30.2,40.2,10);
    }
}
