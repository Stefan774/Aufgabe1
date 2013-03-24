/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPartInterfaceClient;

/**
 *
 * @author stefaneisenkolb
 */
public interface IAdminServer {
    public String[] getConnectedClients ();
    public int getTotalNumMails ();
}
