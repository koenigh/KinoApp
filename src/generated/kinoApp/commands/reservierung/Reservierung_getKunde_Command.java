/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_getKunde_Command extends ObjectCommand<Reservierung, Kunde>{
   private static final long serialVersionUID = -1987622767L;
   public Reservierung_getKunde_Command(Reservierung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getKunde();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
