/*
 * Permisos de uso de libreria de twitter4j
 * 
 * 
 */
package twitt2;

  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
/**
 * 
 * @author Jose Barros
 */


public class Metodos {
    
    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status estado;
    static DirectMessage mensaje;
    static ArrayList <Status> twits = new ArrayList<Status>();
    static Iterator <Status>it = twits.iterator();
    
    
   
  /**
   * acceso as contraseñas da conta twitter
   */ 
     
    
    public static void acceso(){
        
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("0ZWaOjOZyP5wDTvbUM31J8FC1");
        cb.setOAuthConsumerSecret("TIYKsQfLk8GjNhPvttSrLoszdP7DTBbAeYpvK627AWCU4Cide0");
        cb.setOAuthAccessToken("2906196855-RMJ4U2Y4mQSpFSHG9Cy7N6anxBEbLUmLvQDOg5M");
        cb.setOAuthAccessTokenSecret("zeqRnDvoalfzNqrw1aagiS8qCxLssXVJ2HLoqfTIavYlO");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
/**
 * timeline linea de tempo twitts
 */
    public static void timeLine () {

        List<Status> statuses;

        try {
            statuses= twitter.getHomeTimeline();
            System.out.println("Enseñando timeline.");
            for (twitter4j.Status estado : statuses) {
                System.out.println(estado.getUser().getName() + ":"
                        + estado.getText());
                twits.add(estado);
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(twitt2.Twitt1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
/**
 * post un novo tweet
 * @param estado novo tweet
 * a
 */
   public static void twitear(String publicacion) {
    try {
            estado = twitter.updateStatus(publicacion);
            System.out.println("Publicacion -> [" + estado.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
}

/**
 * BuscarTV busca Twitts
 * 
 * @param buscar palabra a buscar
 */
    public static void buscarTt(String buscar) {

        QueryResult result;
        try {
           Query query = new Query(JOptionPane.showInputDialog("Hashtag a buscar: "));
            result=twitter.search(query);
            for (twitter4j.Status statuse : result.getTweets()) {
            System.out.println("@" + statuse.getUser().getScreenName() + ":" + statuse.getText());
            }
        }catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(twitt2.Twitt1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * enviarMp envia mensaxe privado
     * 
     *
     * @param destinatario perfil ó que mandamos MP
     * 
     * @param mensaje mensaxe que mandamos
     */
   public static void enviarMP(String destinatario, String mensaje) {

        try {

            Metodos.mensaje = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Enviar: " + Metodos.mensaje.getText() + " a @" + Metodos.mensaje.getRecipientScreenName());

    }
    
    
    
}
