import java.net.*;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RunnableClientHandler implements Runnable{

    private final Socket socket;

    RunnableClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(socket; // Not strictly necessary, but this is allowed.
            var in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), UTF_8));
            var out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line + " \n");
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Error in ClientHandler: " + e.getMessage());
        }
    }
}
