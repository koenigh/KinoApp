/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Buchung_constructor_Command extends ServiceCommand<Buchung>{
   private static final long serialVersionUID = -1157566821L;
   private Datum eingangsDatum;
   private Reservierung reservierung;
   public Buchung_constructor_Command(Datum eingangsDatum, Reservierung reservierung){
      super();
      this.eingangsDatum = eingangsDatum;
      this.reservierung = reservierung;
   }
   public void execute(){
      try{this.result = Buchung.createFresh(eingangsDatum, reservierung);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
