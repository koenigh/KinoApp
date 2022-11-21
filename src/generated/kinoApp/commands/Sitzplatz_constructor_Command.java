/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Sitzplatz_constructor_Command extends ServiceCommand<Sitzplatz>{
   private static final long serialVersionUID = -492073785L;
   private String  identifikation;
   private Reihe  reihe;
   public Sitzplatz_constructor_Command(String  identifikation, Reihe  reihe){
      super();
      this.identifikation = identifikation;
      this.reihe = reihe;
   }
   public void execute(){
      try{this.result = Sitzplatz.createFresh(identifikation, reihe);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
