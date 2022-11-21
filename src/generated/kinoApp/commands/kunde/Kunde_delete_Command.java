/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.kunde;
import generated.kinoApp.*;
import commands.*;
public class Kunde_delete_Command extends ObjectCommand<Kunde, Void>{
   private static final long serialVersionUID = -1942896194L;
   public Kunde_delete_Command(Kunde receiver){
      super(receiver);
   }
   public void execute(){
      try{Kunde.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
