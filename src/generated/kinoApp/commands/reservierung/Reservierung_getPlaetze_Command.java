/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
import java.util.Collection;
public class Reservierung_getPlaetze_Command extends ObjectCommand<Reservierung, Collection<Sitzplatz>>{
   private static final long serialVersionUID = -1335187321L;
   public Reservierung_getPlaetze_Command(Reservierung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPlaetze();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
