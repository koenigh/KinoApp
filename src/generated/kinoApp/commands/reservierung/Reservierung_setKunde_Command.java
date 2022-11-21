/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_setKunde_Command extends ObjectCommand<Reservierung, Void>{
   private static final long serialVersionUID = -692151348L;
   private Kunde arg;
   public Reservierung_setKunde_Command(Reservierung receiver, Kunde arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setKunde(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
