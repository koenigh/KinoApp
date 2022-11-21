/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
import java.util.Collection;
public class Reihe_getSitzplaetze_Command extends ObjectCommand<Reihe, Collection<Sitzplatz>>{
   private static final long serialVersionUID = 1700022400L;
   public Reihe_getSitzplaetze_Command(Reihe receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSitzplaetze();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
