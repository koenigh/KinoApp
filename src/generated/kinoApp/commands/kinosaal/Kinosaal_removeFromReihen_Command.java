/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.kinosaal;
import generated.kinoApp.*;
import commands.*;
public class Kinosaal_removeFromReihen_Command extends ObjectCommand<Kinosaal, Boolean>{
   private static final long serialVersionUID = 962534296L;
   private Reihe arg;
   public Kinosaal_removeFromReihen_Command(Kinosaal receiver, Reihe arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromReihen(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
