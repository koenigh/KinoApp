/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.sitzplatz;
import generated.kinoApp.*;
import commands.*;
public class Sitzplatz_gibPreis_Command extends ObjectCommand<Sitzplatz, baseTypes.Rational>{
   private static final long serialVersionUID = -2130345512L;
   public Sitzplatz_gibPreis_Command(Sitzplatz receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.gibPreis();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
