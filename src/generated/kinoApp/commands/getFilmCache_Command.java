/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class getFilmCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoApp.proxies.FilmProxy>>{
   private static final long serialVersionUID = 1376280015L;
   public getFilmCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoApp.getInstance().getFilmCache();
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
