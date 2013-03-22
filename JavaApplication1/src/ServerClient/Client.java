/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;
import java.util.UUID;
/**
 *
 * @author stefaneisenkolb
 */
public class Client {
    protected String clientName;
    public Server server1;
    
    public void Client() {
        this.clientName = UUID.randomUUID().toString();
    }
    public void setClientName(String cN) {
        this.clientName = cN;
    }
    public String getClientName() {
        return this.clientName;
    }
    public void sendMessage(String message, String client) {
        
    }
}
