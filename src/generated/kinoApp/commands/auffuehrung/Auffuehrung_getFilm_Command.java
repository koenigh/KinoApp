/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_getFilm_Command extends ObjectCommand<Auffuehrung, Film>{
   private static final long serialVersionUID = -469218415L;
   public Auffuehrung_getFilm_Command(Auffuehrung receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getFilm();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
