package ServerClient;
/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private Map<Client, ArrayList> messageQueue = new HashMap<Client, ArrayList>();
    
    public void connect(Client c) {
        this.clients.add(c);
    }
    public boolean sendMessage(String message, String receiver, Client sender) {
        System.out.println("ClientSize : " + clients.size());
        for (int i=0; i < clients.size(); i++) {
            System.out.println("Client-Names-In-ArrayList : " + " for index " + i + " :: " + clients.get(i).getClientName());
            if (clients.get(i).getClientName().equalsIgnoreCase(receiver)) {
                if (messageQueue.get(clients.get(i)) == null) {
                    ArrayList<String> messages = new ArrayList<String>();
                    //System.out.println("Stored Message : " + "Message from : " + sender.getClientName() + " " + message);
                    messages.add("Message from : " + sender.getClientName() + " \n " + message);
                    messageQueue.put(clients.get(i),messages);
                } else {
                    //System.out.println("Stored Message : " + "Message from : " + sender.getClientName() + " " + message);
                    //System.out.println("Message stored from Client-1 :: " + messageQueue.get(clients.get(i)));
                    messageQueue.get(clients.get(i)).add("Message from : " + sender.getClientName() + " \n " + message);
                    //System.out.println("Message stored from Client-1 message 2 :: " + messageQueue.get(clients.get(i)).get(1));
                }
                return true;
            }
        }
        return false;
    }
    public ArrayList getMessages(Client c) {
        return messageQueue.get(c);
    }
}
