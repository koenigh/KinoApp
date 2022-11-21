/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.sitzplatz;
import generated.kinoApp.*;
import commands.*;
public class Sitzplatz_delete_Command extends ObjectCommand<Sitzplatz, Void>{
   private static final long serialVersionUID = 792527952L;
   public Sitzplatz_delete_Command(Sitzplatz receiver){
      super(receiver);
   }
   public void execute(){
      try{Sitzplatz.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
