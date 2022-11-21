/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getAuffuehrungCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.AuffuehrungProxy>>{
   private static final long serialVersionUID = 1459741189L;
   public getAuffuehrungCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getAuffuehrungCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
