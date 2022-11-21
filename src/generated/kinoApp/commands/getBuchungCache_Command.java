/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getBuchungCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.BuchungProxy>>{
   private static final long serialVersionUID = 183345960L;
   public getBuchungCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getBuchungCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
