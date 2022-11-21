/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.reservierung;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_addToPlaetze_Command extends ObjectCommand<Reservierung, Void>{
   private static final long serialVersionUID = -1721754562L;
   private Sitzplatz arg;
   public Reservierung_addToPlaetze_Command(Reservierung receiver, Sitzplatz arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToPlaetze(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
