package java21;

/**
 * Shows example of improved labels for enums in switch & pattern
 * matching.
 */

public class StreamingService {

    public static void main(String[] args) {

        //Uncomment and run as required.

        //String message = switchBeforeJDK21(FootballLeague.BUNDESLIGA);
        //streamUsingQualifiedNamesStatement(FootballLeague.BUNDESLIGA);
        //String message = streamUsingGuards(FootballLeague.BUNDESLIGA);
        String message = streamUsingQualifiedNames(FootballLeague.BUNDESLIGA);
        System.out.println(message);
    }

    public static String switchBeforeJDK21(FootballLeague footballLeague) {
        return switch(footballLeague){
            case EPL -> "Watching English Premier League";
            case LA_LIGA -> "Watching Spanish Football";
            case BUNDESLIGA -> "Watching German Football League";
        };
    }

    public static String streamUsingGuards(League league) {
        return switch(league){
            case FootballLeague fLeague when fLeague == FootballLeague.EPL ->{
                yield "Watching English Premier League";
            }
            case FootballLeague fLeague when fLeague == FootballLeague.LA_LIGA ->{
                yield "Watching Spanish Football";
            }
            case FootballLeague fLeague ->"Watching German Football League";

            case BasketballLeague bLeague when bLeague == BasketballLeague.ACB ->{
                yield "Watching basketball in Spain";
            }
            case BasketballLeague bLeague when bLeague == BasketballLeague.NBA ->{
                yield "Watching basketball in America";
            }
            case BasketballLeague bLeague -> "Watching Basketball in Europe";
        };
    }

    public static String streamUsingQualifiedNames(League league) {
        return switch (league) {
            case FootballLeague.EPL ->  "Watching English Premier League";
            case FootballLeague.BUNDESLIGA ->  "Watching German Football League";
            case FootballLeague.LA_LIGA ->  "Watching Spanish Football";
            case BasketballLeague.EUROLEAGUE ->  "Watching Basketball in Europe";
            case BasketballLeague.ACB ->  "Watching basketball in Spain";
            case BasketballLeague.NBA ->  "Watching basketball in America";
        };
    }

    public static void streamUsingQualifiedNamesSwitchStatement(League league) {
        switch (league) {
            case FootballLeague.EPL:
                System.out.println("Watching English Premier League");
                break;
            case FootballLeague.BUNDESLIGA:
                System.out.println("Watching German Football League");
                break;
            case FootballLeague.LA_LIGA:
                System.out.println("Watching Spanish Football");
                break;
            case BasketballLeague.EUROLEAGUE:
                System.out.println("Watching Basketball in Europe");
                break;
            case BasketballLeague.ACB:
                System.out.println("Watching basketball in Spain");
                break;
            case BasketballLeague.NBA:
                System.out.println("Watching basketball in America");
                break;
            default:System.out.println("Streaming a league");
        }
    }
}
