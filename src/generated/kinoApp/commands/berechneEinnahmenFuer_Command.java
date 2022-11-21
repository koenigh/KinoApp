/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class berechneEinnahmenFuer_Command extends ServiceCommand<baseTypes.Rational>{
   private static final long serialVersionUID = 1526046000L;
   private Film film;
   public berechneEinnahmenFuer_Command(Film film){
      super();
      this.film = film;
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().berechneEinnahmenFuer(film);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
