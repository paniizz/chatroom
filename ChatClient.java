import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private BufferedReader in;
    private PrintWriter out;
    private String serverAddress;

    public ChatClient(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    private void run() throws IOException {
        try (Socket socket = new Socket(serverAddress, 1234)) {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = in.readLine();
                if (line.startsWith("SUBMITNAME")) {
                    System.out.print("Enter your username: ");
                    out.println(scanner.nextLine());
                } else if (line.startsWith("NAMEACCEPTED")) {
                    System.out.println("Connected to chat server");
                    break;
                }
            }

            Thread readerThread = new Thread(new Reader());
            readerThread.start();

            while (true) {
                out.println(scanner.nextLine());
            }
        }
    }

    private class Reader implements Runnable {
        public void run() {
            try {
                while (true) {
                    String line = in.readLine();
                    if (line.startsWith("MESSAGE")) {
                        System.out.println(line.substring(8));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from server");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // localhost
        ChatClient client = new ChatClient(serverAddress);
        client.run();
    }
}
