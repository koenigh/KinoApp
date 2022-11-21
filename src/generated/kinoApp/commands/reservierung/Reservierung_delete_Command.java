/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_delete_Command extends ObjectCommand<Reservierung, Void>{
   private static final long serialVersionUID = -1130004844L;
   public Reservierung_delete_Command(Reservierung receiver){
      super(receiver);
   }
   public void execute(){
      try{Reservierung.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
