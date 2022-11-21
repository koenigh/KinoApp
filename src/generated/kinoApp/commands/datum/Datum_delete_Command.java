/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.datum;
import generated.kinoApp.*;
import commands.*;
public class Datum_delete_Command extends ObjectCommand<Datum, Void>{
   private static final long serialVersionUID = 1647053134L;
   public Datum_delete_Command(Datum receiver){
      super(receiver);
   }
   public void execute(){
      try{Datum.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
