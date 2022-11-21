/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
public class Reihe_delete_Command extends ObjectCommand<Reihe, Void>{
   private static final long serialVersionUID = 753209506L;
   public Reihe_delete_Command(Reihe receiver){
      super(receiver);
   }
   public void execute(){
      try{Reihe.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
