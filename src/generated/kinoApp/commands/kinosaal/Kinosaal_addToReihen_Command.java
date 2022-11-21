/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.kinosaal;
import generated.kinoApp.*;
import commands.*;
public class Kinosaal_addToReihen_Command extends ObjectCommand<Kinosaal, Void>{
   private static final long serialVersionUID = 1430337687L;
   private Reihe arg;
   public Kinosaal_addToReihen_Command(Kinosaal receiver, Reihe arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToReihen(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
