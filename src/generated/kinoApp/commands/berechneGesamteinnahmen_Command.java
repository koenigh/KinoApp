/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class berechneGesamteinnahmen_Command extends ServiceCommand<baseTypes.Rational>{
   private static final long serialVersionUID = 890383684L;
   public berechneGesamteinnahmen_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().berechneGesamteinnahmen();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
