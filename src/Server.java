import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;      //Сокет сервера
    private static Socket socket;                  //Сокет для передачи информации
    private static BufferedWriter out;             //поток для чтения в сокет
    private static BufferedReader in;              //поток для чтения из сокета


    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(8090);  //слушаем с 8090 порта
            System.out.println("Server UP");            //дали понять
            socket = serverSocket.accept();                      //ждём пока кто-то не подключится
            System.out.println("Подключился" + socket.getLocalAddress());

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                System.out.println("asdddd");
                String word = in.readLine();
                System.out.println(word);
                out.write("Подтверждаю, что получил слово:" + word);
                out.flush();
            } finally {
                socket.close();
                in.close();
                out.close();
            }
        } finally {
            serverSocket.close();
        }

    }
}
