/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Reservierung_constructor_Command extends ServiceCommand<Reservierung>{
   private static final long serialVersionUID = 31517092L;
   private Auffuehrung auffuehrung;
   private Kunde kunde;
   public Reservierung_constructor_Command(Auffuehrung auffuehrung, Kunde kunde){
      super();
      this.auffuehrung = auffuehrung;
      this.kunde = kunde;
   }
   public void execute(){
      try{this.result = Reservierung.createFresh(auffuehrung, kunde);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
