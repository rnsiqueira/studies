package sc_21;

import java21.NetworkClient;
import java21.NetworkResponse;
import java21.NetworkService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class returns a random activity by invoking the uri below.
 * This is an actual network call.
 */
public class ActivityService {

    private static final String uri = "https://www.boredapi.com/api/activity";

    public static List<Activity> fetch(Request request){
        List<Activity> activities = new ArrayList<>();
        NetworkClient networkClient = new NetworkClient(new NetworkService());
        NetworkResponse response = networkClient.fetchData(uri);
        activities.add(new Activity(response.response()));
        return activities;
    }

}
