package client.network;

import client.view.JPTablePanel;
import client.view.MainWindow;

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

    public Client(JPTablePanel tablePanel, String idPerson) throws IOException {
        this.socket = new Socket(IP, PORT);
        outputChannel = new DataOutputStream(socket.getOutputStream());
        inputChannel = new DataInputStream(socket.getInputStream());
        sendRequest(idPerson);
        String response = inputChannel.readUTF();
        tablePanel.addInfoToTable(formatData(response));
        System.out.println(response);
    }

    public void sendRequest(String service, String params) throws IOException {
        outputChannel.writeUTF(service);
        outputChannel.writeUTF(params);
    }

    public String[] formatData(String data){
        return data.split(" ");
    }
    public void sendRequest(String service) throws IOException {
        outputChannel.writeUTF(service);
    }




}
