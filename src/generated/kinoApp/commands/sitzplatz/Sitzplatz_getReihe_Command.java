/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.sitzplatz;
import generated.kinoApp.*;
import commands.*;
public class Sitzplatz_getReihe_Command extends ObjectCommand<Sitzplatz, Reihe>{
   private static final long serialVersionUID = -848477213L;
   public Sitzplatz_getReihe_Command(Sitzplatz receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReihe();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
