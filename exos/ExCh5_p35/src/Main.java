public class Main {
    public static void main(String[] args) {

        VThreadsClient client = new VThreadsClient();
        VThreadsServer server = new VThreadsServer();

        server.serve(6987, 6);
        client.client(6987);
    }
}