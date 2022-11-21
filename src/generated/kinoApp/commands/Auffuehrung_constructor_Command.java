/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_constructor_Command extends ServiceCommand<Auffuehrung>{
   private static final long serialVersionUID = -847927289L;
   private Film film;
   private Kinosaal kinosaal;
   private Integer  auffuehrungId;
   public Auffuehrung_constructor_Command(Film film, Kinosaal kinosaal, Integer  auffuehrungId){
      super();
      this.film = film;
      this.kinosaal = kinosaal;
      this.auffuehrungId = auffuehrungId;
   }
   public void execute(){
      try{this.result = Auffuehrung.createFresh(film, kinosaal, auffuehrungId);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
