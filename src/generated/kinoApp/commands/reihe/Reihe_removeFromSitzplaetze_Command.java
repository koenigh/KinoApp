/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
public class Reihe_removeFromSitzplaetze_Command extends ObjectCommand<Reihe, Boolean>{
   private static final long serialVersionUID = -725267952L;
   private Sitzplatz arg;
   public Reihe_removeFromSitzplaetze_Command(Reihe receiver, Sitzplatz arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromSitzplaetze(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
