/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Kinosaal_constructor_Command extends ServiceCommand<Kinosaal>{
   private static final long serialVersionUID = 877169181L;
   private String  name;
   public Kinosaal_constructor_Command(String  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Kinosaal.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
