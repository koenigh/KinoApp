/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Reihe_constructor_Command extends ServiceCommand<Reihe>{
   private static final long serialVersionUID = 1591752346L;
   private Kategorie kategorie;
   private String  buchstabe;
   public Reihe_constructor_Command(Kategorie kategorie, String  buchstabe){
      super();
      this.kategorie = kategorie;
      this.buchstabe = buchstabe;
   }
   public void execute(){
      try{this.result = Reihe.createFresh(kategorie, buchstabe);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
