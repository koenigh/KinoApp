/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getSitzplatzCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.SitzplatzProxy>>{
   private static final long serialVersionUID = 135270237L;
   public getSitzplatzCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getSitzplatzCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
