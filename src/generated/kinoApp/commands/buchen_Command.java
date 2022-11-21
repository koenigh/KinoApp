/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class buchen_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -401174570L;
   private Reservierung reservierung;
   public buchen_Command(Reservierung reservierung){
      super();
      this.reservierung = reservierung;
   }
   public void execute(){
      try{KinoApp.getInstance().buchen(reservierung);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
