/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.kinosaal;
import generated.kinoApp.*;
import commands.*;
public class Kinosaal_delete_Command extends ObjectCommand<Kinosaal, Void>{
   private static final long serialVersionUID = 2075352803L;
   public Kinosaal_delete_Command(Kinosaal receiver){
      super(receiver);
   }
   public void execute(){
      try{Kinosaal.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
