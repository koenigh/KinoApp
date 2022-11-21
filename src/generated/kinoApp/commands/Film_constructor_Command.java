/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Film_constructor_Command extends ServiceCommand<Film>{
   private static final long serialVersionUID = -1082124870L;
   private String  bezeichnung;
   private Integer  laenge;
   public Film_constructor_Command(String  bezeichnung, Integer  laenge){
      super();
      this.bezeichnung = bezeichnung;
      this.laenge = laenge;
   }
   public void execute(){
      try{this.result = Film.createFresh(bezeichnung, laenge);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
