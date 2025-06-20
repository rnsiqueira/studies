
package java18;


import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.Request;
import com.sun.net.httpserver.Headers;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class SimpleWebServer {

    /**
     * The path from where the web server will serve files.
     */

    //Edit path.
    private static final String directoryPath = "src/java18/server";
    private static final String footballDataPath = "src/java18/server/football-competitions.json";


    public static void main(String[] args) throws IOException {
        runSimpleWebServer();
        runSimpleWebServerCustomHandler();
    }

    /**
     * Starts a simple web server at port 8080.
     */
    public static void runSimpleWebServer() {
        var serverPort = new InetSocketAddress(8080);
        var servedPath = Paths.get(directoryPath)
                .toAbsolutePath();
        var logMessageOutputLevel = SimpleFileServer.OutputLevel.VERBOSE;

        var server = SimpleFileServer.createFileServer(serverPort, servedPath,
                logMessageOutputLevel);

        server.start();
    }

    public static void runSimpleWebServerCustomHandler() throws IOException {

        var getResponsePath = Paths.get(footballDataPath)
                .toAbsolutePath();

        var jsonHeaders = Headers.of("Content-Type", "application/json");
        var getHandler = HttpHandlers.of(200, jsonHeaders, Files.readString(getResponsePath));
        var deleteHandler = HttpHandlers.of(204, Headers.of(), "");

        Predicate<Request> IS_DELETE = r -> r.getRequestMethod()
                .equals("DELETE");

        var handler = HttpHandlers.handleOrElse(IS_DELETE, deleteHandler, getHandler);

        var outputFilter = SimpleFileServer.createOutputFilter(System.out,
                SimpleFileServer.OutputLevel.VERBOSE);

        var server = HttpServer.create(new InetSocketAddress(8082), 10, "/",
                handler, outputFilter);
        server.start();
    }
}
