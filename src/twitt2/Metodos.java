/*
 * Permisos de uso de libreria de twitter4j
 * 
 * 
 */
package twitt2;

  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * @author Jose Barros
 */


public class Metodos {
    
     static Twitter twitter =TwitterFactory.getSingleton(); //adición del singleton
    static Status status;
    static DirectMessage message;
    static ArrayList <Status> twits = new ArrayList<Status>();
    static Iterator <Status>it = twits.iterator();
    
    
    /**
 * Usado para recoger en una colección la linea temporal del twitter del usuario.
 */
        public static void lineaTiempo() {

        List<Status> statuses;
        try {
            statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);

            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(TwitterCOD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        /**
 * utilizado para twittear nuevos estados,escribiéndolos por teclado.
 * @param latestStatus se recibe el mensaje de la actualización de estado.
 */
    public static void twitearN(String latestStatus) {

        try {
            status = twitter.updateStatus(latestStatus);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
 * Usado para buscar twits relacionados con la palabra que nosotros introduzcamos en la búsqueda.
 * 
 * @param busqueda Cadena de caracteres donde introducimos el contenido a buscar
 */
    public static void buscarTwit(String busqueda) {

        Query query = new Query(busqueda);
        QueryResult result;
        try {
            result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * utilizado para poder enviar mensaje privados,sólo a gente a la que
     * seguimos o nos sigue.
     *
     * @param destinatario direccion de twitter a la que queremos enviar el
     * correo.
     * @param mensaje contiene  la cadena de caracteres a enviar
     */
    public static void enviarMensaje(String destinatario, String mensaje) {

        try {

            message = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());

    }
    /**
     * recoge en un nuevo arraylist objetos tipo Status,pudiendo recoger sus diferentes variables
     */
    public static void seleccion(){
      
    for(int i=0;i<twits.size();i++){
  System.out.println(twits.get(i).getUser()+""+twits.get(i).getGeoLocation()+""+twits.get(i).getText());
        
    }
       
    }
    
    
}