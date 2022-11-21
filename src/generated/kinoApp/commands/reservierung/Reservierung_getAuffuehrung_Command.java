/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_getAuffuehrung_Command extends ObjectCommand<Reservierung, Auffuehrung>{
   private static final long serialVersionUID = -1112685604L;
   public Reservierung_getAuffuehrung_Command(Reservierung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAuffuehrung();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
