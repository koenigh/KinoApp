/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.kinosaal;
import generated.kinoApp.*;
import commands.*;
import java.util.Collection;
public class Kinosaal_getReihen_Command extends ObjectCommand<Kinosaal, Collection<Reihe>>{
   private static final long serialVersionUID = -7077474L;
   public Kinosaal_getReihen_Command(Kinosaal receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReihen();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
