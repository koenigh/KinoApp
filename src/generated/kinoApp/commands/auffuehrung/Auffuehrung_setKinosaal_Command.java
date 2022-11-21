/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_setKinosaal_Command extends ObjectCommand<Auffuehrung, Void>{
   private static final long serialVersionUID = 2136312616L;
   private Kinosaal arg;
   public Auffuehrung_setKinosaal_Command(Auffuehrung receiver, Kinosaal arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setKinosaal(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
