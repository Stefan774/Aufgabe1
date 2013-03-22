package ServerClient;
/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
import java.util.ArrayList;

public class Server {
    private ArrayList<Client> clients = new ArrayList<Client>();
    
    public void connect(Client c) {
        this.clients.add(c);
    }
    public boolean sendMessage(String message, String receiver, Client sender) {
        for (int i=0; i < clients.size(); i++) {
            if (clients.get(i).getClientName().equalsIgnoreCase(receiver)) {
                clients.get(i).inbox(message, sender.getClientName());
                return true;
            }
        }
        return false;
    }
}
