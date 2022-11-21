/**--- Generated at Mon Nov 21 10:21:23 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class reservierungAnlegen_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1806911736L;
   private Auffuehrung auffuehrung;
   private Kunde kunde;
   private Integer anzahlPlaetze;
   private Kategorie kategorie;
   public reservierungAnlegen_Command(Auffuehrung auffuehrung, Kunde kunde, Integer anzahlPlaetze, Kategorie kategorie){
      super();
      this.auffuehrung = auffuehrung;
      this.kunde = kunde;
      this.anzahlPlaetze = anzahlPlaetze;
      this.kategorie = kategorie;
   }
   public void execute(){
      try{KinoApp.getInstance().reservierungAnlegen(auffuehrung, kunde, anzahlPlaetze, kategorie);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
