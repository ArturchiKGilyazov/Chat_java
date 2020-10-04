import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                socket = new Socket("localhost", 8090);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                System.out.println("ГОВОРИ, СУКА!: ");
                String word = reader.readLine();
                out.write(word + '\n');
                out.flush();
                System.out.println(word);
                String serverLine = in.readLine();
                System.out.println(serverLine);
            } finally {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
