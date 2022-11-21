/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Kunde_constructor_Command extends ServiceCommand<Kunde>{
   private static final long serialVersionUID = -1441703939L;
   private String  firstName;
   private String  lastName;
   public Kunde_constructor_Command(String  firstName, String  lastName){
      super();
      this.firstName = firstName;
      this.lastName = lastName;
   }
   public void execute(){
      try{this.result = Kunde.createFresh(firstName, lastName);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
