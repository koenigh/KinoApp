/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getReservierungCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.ReservierungProxy>>{
   private static final long serialVersionUID = 2065957148L;
   public getReservierungCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getReservierungCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
