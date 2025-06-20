package java21;

public class NetworkClientTest {

    final static String URL = "https://www.boredapi.com/api/activity";

    public static void main(String[] args) {
        NetworkClient networkClient = new NetworkClient(new NetworkService());
        NetworkResponse response = networkClient.fetchData(URL);
        System.out.println(response);
    }
}
