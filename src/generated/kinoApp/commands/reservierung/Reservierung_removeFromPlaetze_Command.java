/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_removeFromPlaetze_Command extends ObjectCommand<Reservierung, Boolean>{
   private static final long serialVersionUID = -1867377693L;
   private Sitzplatz arg;
   public Reservierung_removeFromPlaetze_Command(Reservierung receiver, Sitzplatz arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromPlaetze(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
