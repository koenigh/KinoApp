/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_delete_Command extends ObjectCommand<Buchung, Void>{
   private static final long serialVersionUID = -1046502416L;
   public Buchung_delete_Command(Buchung receiver){
      super(receiver);
   }
   public void execute(){
      try{Buchung.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
