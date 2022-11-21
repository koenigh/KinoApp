/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_setAuffuehrung_Command extends ObjectCommand<Reservierung, Void>{
   private static final long serialVersionUID = 394303146L;
   private Auffuehrung arg;
   public Reservierung_setAuffuehrung_Command(Reservierung receiver, Auffuehrung arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setAuffuehrung(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
