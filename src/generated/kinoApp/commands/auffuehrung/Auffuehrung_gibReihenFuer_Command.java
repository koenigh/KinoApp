/**--- Generated at Mon Nov 21 10:47:49 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands.auffuehrung;
import generated.kinoApp.*;
import commands.*;
import java.util.Collection;
public class Auffuehrung_gibReihenFuer_Command extends ObjectCommand<Auffuehrung, Collection<Reihe>>{
   private static final long serialVersionUID = -1359681575L;
   private Kategorie kategorie;
   public Auffuehrung_gibReihenFuer_Command(Auffuehrung receiver, Kategorie kategorie){
      super(receiver);
      this.kategorie = kategorie;
   }
   public void execute(){
      try{this.result = this.receiver.gibReihenFuer(kategorie);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
