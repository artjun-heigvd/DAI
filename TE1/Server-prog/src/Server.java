import java.net.*;
import java.io.*;

import static java.nio.charset.StandardCharsets.*;

public class Server {
    final static int SERVER_PORT = 31111;

    public static void main(String[] args){

        Server server = new Server();
        server.run();
    }

    private void run(){
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            System.out.println("Ready maggot !!");

            while (true) {

                try (Socket socket = serverSocket.accept();
                     var in = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                     var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8))) {
                    System.out.println("Hello maggot !!");

                    String str;
                    String protocolMess;
                    String data;
                    while((str = in.readLine()) != null) {
                        protocolMess = str.substring(0, str.indexOf(':') + 1);
                        data = str.substring(str.indexOf(':') + 2);
                        System.out.println(protocolMess);
                        System.out.println(data);
                        switch(protocolMess){
                            case "COUNT:":
                                out.write(count(data) + "\n");
                                break;
                            case "UNDERSCORE:":
                                out.write(underscore(data) + "\n");
                                break;
                            case "UPPERCASE:":
                                out.write(uppercase(data) + "\n");
                                break;
                                default:
                                    throw new IOException("Unknown protocol message");
                        }
                        out.flush();
                    }

                } catch (IOException e) {
                    System.out.println("Server: socket ex.: " + e);
                }
                System.out.println("Goodbye soldier !!");
            }
        } catch (IOException e) {
            System.out.println("Server: server socket ex.: " + e);

        }
    }

    private int count(String s){
        return s.length();
    }

    private String uppercase(String s){
        return s.toUpperCase();
    }

    private String underscore(String s){
        return s.replaceAll("\\s+", "_");
    }
}
