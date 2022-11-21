/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_getKinosaal_Command extends ObjectCommand<Auffuehrung, Kinosaal>{
   private static final long serialVersionUID = 1815404799L;
   public Auffuehrung_getKinosaal_Command(Auffuehrung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getKinosaal();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
