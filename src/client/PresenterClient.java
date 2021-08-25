package client;

import client.network.Client;
import client.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PresenterClient implements ActionListener {

    private MainWindow window;
    public PresenterClient() throws IOException {
        window = new MainWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fuente = e.getActionCommand();
        switch (fuente) {
            case "searchPerson":
                searchPerson();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }

    public void searchPerson(){
        String idPerson = window.getMainPanel().getDataText().getCasilla().getText();
        try {
            Client client = new Client(window.getMainPanel().getTablle(), idPerson);
            client.sendRequest("/searchPerson", idPerson);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new PresenterClient();
    }
}
