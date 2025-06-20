package java21;

record State(String name) {}
record City(String name, State state) {}
record Person(String name, EmailAddress email, City city) implements Registrant {}
record Company(String name,EmailAddress email,int participants) implements Registrant {}
record Vendor(String name,EmailAddress email,String boothDetails) implements Registrant {}
record Volunteer(String name,EmailAddress email) implements Registrant {}

sealed interface Registrant { }

public class EventRegistration {

    public String sendWelcomeMessage(Registrant registrant) {
        return switch (registrant) {
            case Person(var name, EmailAddress(var email), City(String cname, State state))->
                    String.format("Hello %s (%s) from %s city in %s state, see you at the event..",
                            name, email, cname, state.name());
            case Company(var name, EmailAddress(var e), int participants) -> String.format("We welcome all %d participants from %s", participants, name);
            case Vendor(var name, EmailAddress(var email), var booth) -> String.format("Welcome %s,your booth is reserved", name);
            case Volunteer(var name, EmailAddress(var email)) ->
                    String.format("Thank you %s for volunteering, we will get in touch" +
                            " with you on your email address %s", name, email);
        };
    }
    public static void main(String[] args) {

        var eventRegistration = new EventRegistration();

        var message = eventRegistration.sendWelcomeMessage(new Person(
                "Jack", new EmailAddress("abc@abc.com"),
                new City("San Francisco", new State("California"))
        ));
        var welcomeMessage = eventRegistration.sendWelcomeMessage(new Company("Timeless Inc",
                new EmailAddress("abc@abc.com"), 8));

        var welcomeVolunteer = eventRegistration.sendWelcomeMessage(new Volunteer("Heidi",
                new EmailAddress("heidi@abc.com")));

        var vendor = eventRegistration.sendWelcomeMessage(new Vendor("BigMac",
                new EmailAddress("mac@mac.com"),"Booth number 21"));

        System.out.println(message);
        System.out.println(welcomeMessage);
        System.out.println(welcomeVolunteer);
        System.out.println(vendor);
    }
}
