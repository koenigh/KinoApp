/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class closeDBConnection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 50455715L;
   public closeDBConnection_Command(){
      super();
   }
   public void execute(){
      try{KinoApp.getInstance().closeDBConnection();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
