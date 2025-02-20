package ch.heig.dai.lab.protocoldesign;

import java.io.*;
import java.net.*;
import static java.nio.charset.StandardCharsets.*;

public class Server {
    final int SERVER_PORT = 6789;

    public static void main(String[] args) {
        // Create a new server and run it
        Server server = new Server();
        server.run();
    }

    private void run() {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while(true) {
                try (Socket socket = serverSocket.accept();
                     var in = new BufferedReader(
                             new InputStreamReader(
                                     socket.getInputStream(), UTF_8));
                     var out = new BufferedWriter(
                             new OutputStreamWriter(
                                     socket.getOutputStream(), UTF_8))) {
                    String line;
                    while ((line = in.readLine()) != null) {

                        out.write(line + "\n");
                        out.flush();
                    }
                }catch (IOException e){
                    System.out.println("Server: socket exc. " + e);
                }

            }
        }catch(IOException e){
            System.out.println("Server: socket exc. " + e);
        }
    } 
}