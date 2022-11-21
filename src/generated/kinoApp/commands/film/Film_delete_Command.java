/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.film;
import generated.kinoApp.*;
import commands.*;
public class Film_delete_Command extends ObjectCommand<Film, Void>{
   private static final long serialVersionUID = -1828493273L;
   public Film_delete_Command(Film receiver){
      super(receiver);
   }
   public void execute(){
      try{Film.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
