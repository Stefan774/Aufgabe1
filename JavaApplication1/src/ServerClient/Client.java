package ServerClient;
/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
import java.util.ArrayList;
import java.util.UUID;

public class Client {
    private String clientName;
    private Server mailServer;
    
    public void Client() {
        this.clientName = UUID.randomUUID().toString();
    }
    public void setClientName(String cN) {
        this.clientName = cN;
    }
    public String getClientName() {
        return this.clientName;
    }
    public void setMailServer(Server s) {
        this.mailServer = s;
        this.mailServer.connect(this);
    }
    public void sendMessage(String message, String receiver) {
        this.mailServer.sendMessage(message, receiver, this);
    }
    public ArrayList<String> inbox() {
        return this.mailServer.getMessages(this);
    }
}
