/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_setReservierung_Command extends ObjectCommand<Buchung, Void>{
   private static final long serialVersionUID = 1521206824L;
   private Reservierung arg;
   public Buchung_setReservierung_Command(Buchung receiver, Reservierung arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setReservierung(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
