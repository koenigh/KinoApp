/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class ServerStart_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1958855843L;
   public ServerStart_Command(){
      super();
   }
   public void execute(){
      try{KinoApp.getInstance();}catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
