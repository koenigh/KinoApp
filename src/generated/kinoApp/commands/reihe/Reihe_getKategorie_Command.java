/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
public class Reihe_getKategorie_Command extends ObjectCommand<Reihe, Kategorie>{
   private static final long serialVersionUID = 560539218L;
   public Reihe_getKategorie_Command(Reihe receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getKategorie();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
