package ServerPartInterfaceClient;
/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server implements IServer, IAdminServer {
    
    private ArrayList<Client> clients = new ArrayList<Client>();
    private Map<Client, ArrayList<String>> messageQueue = new HashMap<Client, ArrayList<String>>();
    
    @Override
    public void connect(Client c) {
        this.clients.add(c);
    }
    
    @Override
    public boolean sendMessageTo(String message, String receiver, Client sender) {
        //System.out.println("ClientSize : " + clients.size());
        for (int i=0; i < clients.size(); i++) {
            //System.out.println("Client-Names-In-ArrayList : " + " for index " + i + " :: " + clients.get(i).getClientName());
            String[] receivers = receiver.split(";");
            for (int y=0; y < receivers.length; y++) {
                //System.out.println(receivers[y]);
                if (clients.get(i).getClientName().equalsIgnoreCase(receivers[y])) {
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
                }
            }
        }
        return true;
    }
    
    @Override
    public ArrayList<String> getMessages(Client c) {
        return messageQueue.get(c);
    }

    @Override
    public String[] getConnectedClients() {
        String[] connectedClients = new String[clients.size()];
        for (int i=0; i<clients.size();i++) {
            connectedClients[i] = clients.get(i).getClientName(); 
        }
        return connectedClients;
    }

    @Override
    public int getTotalNumMails() {
        int messageCounter = 0;
        for (int i=0; i < clients.size();i++) {
            if (messageQueue.get(clients.get(i)) != null) {
                messageCounter += messageQueue.get(clients.get(i)).size();
            }
        }
        return messageCounter;
    }
}
