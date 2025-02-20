import java.net.*;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RunnableServerHandler implements Runnable{

    private final Socket socket;

    RunnableServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try( socket;
            var in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), UTF_8));
            var out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), UTF_8))) {
            String line;
            for (int i = 0; i < 1000; i++) {

                out.write("Hello " + i + "\n");
                out.flush();

                while ((line = in.readLine()) != null) {
                    System.out.println(line + "\n");
                }

            }

        } catch (IOException e) {
            System.err.println("Error in ClientHandler: " + e.getMessage());
        }
    }


}
