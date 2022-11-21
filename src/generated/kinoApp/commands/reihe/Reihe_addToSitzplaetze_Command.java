/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reihe;
import generated.kinoApp.*;
import commands.*;
public class Reihe_addToSitzplaetze_Command extends ObjectCommand<Reihe, Void>{
   private static final long serialVersionUID = -1157310286L;
   private Sitzplatz arg;
   public Reihe_addToSitzplaetze_Command(Reihe receiver, Sitzplatz arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToSitzplaetze(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
