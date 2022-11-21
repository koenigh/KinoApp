/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_setEingangsDatum_Command extends ObjectCommand<Buchung, Void>{
   private static final long serialVersionUID = 1579585317L;
   private Datum arg;
   public Buchung_setEingangsDatum_Command(Buchung receiver, Datum arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setEingangsDatum(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
