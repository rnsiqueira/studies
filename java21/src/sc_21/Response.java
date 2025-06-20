package sc_21;

import java.util.List;

public record Response(Request request,Weather weather,List<Activity> activity,List<Restaurant> restaurants){

}
