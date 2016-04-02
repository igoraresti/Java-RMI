/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.rmi.RemoteException;
import profesor.*;
import juegos.interfaces.*;

/**
 *
 * @author Igor Aresti
 */
public class Cliente  {
    public static void main(String[] args)  {
        System.out.println(args[0]);
        if( args.length != 2 ) {
            System.out.println( "Usage: Cliente <server_host> <port>" );
            return;
        }
        String host = args[0];
        String port = args[1];
        char r;
        String erantzuna,galdera;
        System.out.println("\nBienvenido al trivial. Responde a las preguntas");
        try{
        Trivial cal = (Trivial)java.rmi.Naming.lookup("//" + host + ":" + port + "/PruebaRMI");
        
        do{
            
            galdera=cal.getQuestion().substring(0);
            System.out.println(galdera);
            erantzuna=Teclado.LeeCadena().substring(0);
            if(cal.checkAnswer(erantzuna))
                System.out.println("\nHas acertado la pregunta!");
            else
                System.out.println("\nHas fallado la pregunta!");

            System.out.println("\nQuieres volver a jugar? s/n");
            r=Teclado.LeeCaracter();
        }
        while(r=='s');
        }
        catch( Exception e ) {
            e.printStackTrace();}
        
        
    }
    
}
