package server.network;

import server.model.DataServer;
import server.model.Infringement;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Logger;

public class Server {

    private ServerSocket serverSocket;
    public static final int PORT = 4000;
    private DataServer dataServer;

    public Server() throws IOException {
        dataServer = new DataServer();
        this.serverSocket = new ServerSocket(PORT);
        Logger.getGlobal().info("Se inicia server en el puerto:" + PORT);
        manageConnection();
    }

    private void manageConnection() {
        new Thread(() -> {
            while (!serverSocket.isClosed()) {
                try {
                    Socket connection = serverSocket.accept();
                    Logger.getGlobal().info("Nueva conexion");
                    DataInputStream inputChannel = new DataInputStream(connection.getInputStream());
                    DataOutputStream outputChannel = new DataOutputStream(connection.getOutputStream());
                    String service = inputChannel.readUTF();
                    switch (service){
                        case "/searchPerson":
                            searchPerson(inputChannel, outputChannel);
                            break;
                    }
                } catch (IOException e) {
                    Logger.getGlobal().warning(e.getMessage());
                }
            }
        }).start();
    }

    private void serviceUploadPhoto(DataInputStream inputChannel, DataOutputStream outputChannel) throws IOException {
        System.out.println("image");
        int size = inputChannel.readInt();
        byte [] data = new byte[size];
        inputChannel.read(data);
        File file = new File("./icon.png");
        Files.write(file.toPath(), data);
        outputChannel.writeInt(200);
    }

    public void searchPerson(DataInputStream inputChannel, DataOutputStream outputChannel) throws IOException {
        for (Infringement infrigment: dataServer.getInfringements()) {
            if (infrigment.getPerson().getId() == Integer.parseInt(inputChannel.readUTF())) {
                String person = infrigment.getPerson().getId()+" " +  infrigment.getPerson().getName();
                outputChannel.writeUTF(person);
                System.out.println(person);
            }
        }
    }




    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
