/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getKundeCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.KundeProxy>>{
   private static final long serialVersionUID = -900162378L;
   public getKundeCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getKundeCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
