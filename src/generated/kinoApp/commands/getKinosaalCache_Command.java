/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getKinosaalCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.KinosaalProxy>>{
   private static final long serialVersionUID = -1060010980L;
   public getKinosaalCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getKinosaalCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
