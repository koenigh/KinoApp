/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_delete_Command extends ObjectCommand<Auffuehrung, Void>{
   private static final long serialVersionUID = -211873463L;
   public Auffuehrung_delete_Command(Auffuehrung receiver){
      super(receiver);
   }
   public void execute(){
      try{Auffuehrung.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
