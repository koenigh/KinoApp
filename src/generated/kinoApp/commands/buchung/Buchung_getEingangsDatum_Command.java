/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_getEingangsDatum_Command extends ObjectCommand<Buchung, Datum>{
   private static final long serialVersionUID = -1883804443L;
   public Buchung_getEingangsDatum_Command(Buchung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getEingangsDatum();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
