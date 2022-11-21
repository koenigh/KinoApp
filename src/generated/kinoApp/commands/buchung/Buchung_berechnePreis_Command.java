/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.buchung;
import generated.kinoApp.*;
import commands.*;
public class Buchung_berechnePreis_Command extends ObjectCommand<Buchung, baseTypes.Rational>{
   private static final long serialVersionUID = 1399290056L;
   public Buchung_berechnePreis_Command(Buchung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.berechnePreis();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
