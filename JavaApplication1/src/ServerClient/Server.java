/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;
import java.util.ArrayList;
/**
 *
 * @author stefaneisenkolb
 */
public class Server {
    private ArrayList<Client> clients = new ArrayList<Client>();
    
    public void connectClient(Client c) {
        this.clients.add(c);
    }
}
