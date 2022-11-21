/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
public class Reihe_setKategorie_Command extends ObjectCommand<Reihe, Void>{
   private static final long serialVersionUID = -1171372860L;
   private Kategorie arg;
   public Reihe_setKategorie_Command(Reihe receiver, Kategorie arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setKategorie(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
