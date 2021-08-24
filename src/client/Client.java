package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import java.net.Socket;
import java.nio.file.Files;

public class Client {
    private Socket socket;
    public static final int PORT = 4000;
    public static final String IP = "127.0.0.1";
    private DataOutputStream outputChannel;
    private DataInputStream inputChannel;

    public Client() throws IOException {
        this.socket = new Socket(IP, PORT);
        outputChannel = new DataOutputStream(socket.getOutputStream());
        inputChannel = new DataInputStream(socket.getInputStream());
        /*sendRequest("/users", "1,20");
        String response = inputChannel.readUTF();
        System.out.println(response);*/
        File file = new File("./icon.png");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        sendRequest("/readDatas", fileContent);
        int response = inputChannel.readInt();
        System.out.println(response);
    }

    public void sendRequest(String service, String params) throws IOException {
        outputChannel.writeUTF(service);
        outputChannel.writeUTF(params);
    }
    public void sendRequest(String service, byte[] data) throws IOException {
        outputChannel.writeUTF(service);
        outputChannel.writeInt(data.length);
        outputChannel.write(data);
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
