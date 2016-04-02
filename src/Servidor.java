/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import juegos.interfaces.*;
/**
 *
 * @author Igor Aresti
 */
public class Servidor extends java.rmi.server.UnicastRemoteObject implements Trivial {
    
    String[] preguntas=new String[5];
    String[] respuestas=new String[5];
    private int numeropregunta=-1;
    private int a=0,b=0;
    
    
    public Servidor()throws java.rmi.RemoteException{
        File fichero=new File("Trivial.txt");
        
        try{
        
        BufferedReader p = new BufferedReader(new FileReader(fichero));
        
        preguntas[a]=p.readLine();
        a++;
        respuestas[b]=p.readLine();
        b++;
        preguntas[a]=p.readLine();
        a++;
        respuestas[b]=p.readLine();
        b++;
        preguntas[a]=p.readLine();
        a++;
        respuestas[b]=p.readLine();
        b++;
        preguntas[a]=p.readLine();
        a++;
        respuestas[b]=p.readLine();
        b++;
        preguntas[a]=p.readLine();
        respuestas[b]=p.readLine();
        p.close();
        }
        catch(IOException ex){
        }
    }
    
    

    @Override
    public String getQuestion() throws RemoteException {
        
        numeropregunta++;
        return preguntas[numeropregunta];
        
    }

    @Override
    public boolean checkAnswer(String answer) throws RemoteException {
        
        boolean b=false;
        if(answer.equals(respuestas[numeropregunta]))
            b=true;
        
        
        return b;
    }
    public static void main( String[] args ) {
        System.out.println(args[0]);
        
        try {
            Registry registry = LocateRegistry.createRegistry(1024);
            
            Trivial cal = new Servidor();
            java.rmi.Naming.rebind( "//localhost:" + args[0] + "/PruebaRMI", cal );
        } catch( Exception e ) {
            
            e.printStackTrace();
        }
        
    }
    
}
