/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
public class Auffuehrung_setFilm_Command extends ObjectCommand<Auffuehrung, Void>{
   private static final long serialVersionUID = -1156265972L;
   private Film arg;
   public Auffuehrung_setFilm_Command(Auffuehrung receiver, Film arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setFilm(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
