/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
import java.util.Collection;
public class Auffuehrung_getReservierungen_Command extends ObjectCommand<Auffuehrung, Collection<Reservierung>>{
   private static final long serialVersionUID = -1225699466L;
   public Auffuehrung_getReservierungen_Command(Auffuehrung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservierungen();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
