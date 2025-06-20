package sc_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Service class for restaurant related data.
 */
public class RestaurantService {

    /**
     * Returns a list of restaurant records.
     * The size of the list and the rating are returned randomly.
     * @param request - The request object.
     * @return - A list of restaurant records.
     */
    public static List<Restaurant> fetch(Request request) {

        Random random = new Random();

        var restaurantList = new ArrayList<String>();
        restaurantList.add("Take It Cheesy");
        restaurantList.add("Nacho Daddy");
        restaurantList.add("Lettuce Eat Bistro ");
        restaurantList.add("Granola Heaven");
        restaurantList.add("Alchemy Bar");

        int startIndex = random.nextInt(0,restaurantList.size());
        int endIndex = random.nextInt(1,restaurantList.size());

        List<String> prunedList;
        if (startIndex <= endIndex) {
            prunedList = restaurantList.subList(startIndex, endIndex);
        } else {
            prunedList = restaurantList.subList(endIndex, startIndex);
        }

        return prunedList.stream()
                .map(name ->  new Restaurant(name,random.nextInt(3,6)))
                .toList();
    }
}
