/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author stefaneisenkolb
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}

interface ISERVER {
    public void d ();
    public boolean s ();
}

class SERVER implements ISERVER {

    @Override
    public void d() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean s() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}