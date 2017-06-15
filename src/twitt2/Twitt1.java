package twitt2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitt2.Metodos;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Jose Barros
 * a
 */
public class Twitt1 {

    /**
     * @param args menú de twitter
     */
   public static void main(String[] args) {
         
       int select;
             
       do {
  select = Integer.parseInt(JOptionPane.showInputDialog("1. Nuevo estado \n 2.TimeLine \n 3.BuscarTwit \n 4.Mensaje \n 5.Seleccionar twits"));
    switch(select){
        
        case 1:Metodos.twitearN(JOptionPane.showInputDialog(null,"Introducir nuevo Estado"));
            break;
        case 2:Metodos.lineaTiempo();
            break;
        case 3:Metodos.buscarTwit(JOptionPane.showInputDialog("Introduce el hastag"));   
            break;
        case 4:Metodos.enviarMensaje(JOptionPane.showInputDialog("Introduce destinatario"),JOptionPane.showInputDialog("Introduce el mensaje"));
            break;
        case 5:Metodos.seleccion();
            break;
    }
  
          }while(select!=0);
    }
        
        
    }