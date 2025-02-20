import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class VThreadsServer {
    public void serve(int port, int numThreads) {
        System.out.println("Starting virtual thread server on port: " + port);
        try (var serverSocket = new ServerSocket(port);
             ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    var handler = new RunnableClientHandler(socket);
                    executor.execute(handler);
                } catch (IOException e) {
                    System.err.println("Error client socket: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error server socket: " + e.getMessage());
        }
    }
}

