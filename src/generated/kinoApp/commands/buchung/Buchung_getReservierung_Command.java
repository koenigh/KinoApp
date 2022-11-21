/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_getReservierung_Command extends ObjectCommand<Buchung, Reservierung>{
   private static final long serialVersionUID = 1102879921L;
   public Buchung_getReservierung_Command(Buchung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservierung();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
