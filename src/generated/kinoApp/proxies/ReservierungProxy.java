/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Reservierung;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Auffuehrung;
import generated.kinoApp.relationControl.AuffuehrungInReservierungSupervisor;
import generated.kinoApp.Kunde;
import generated.kinoApp.relationControl.KundeInReservierungSupervisor;
import generated.kinoApp.Sitzplatz;
import java.util.List;
public class ReservierungProxy implements IReservierung{
   private Integer id;
   private Optional<Reservierung> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservierungProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservierungProxy(Reservierung theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reservierung getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reservierung";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservierung)) return false;
      return ((IReservierung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reservierung load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reservierung", this.id);
         Auffuehrung auffuehrung = AuffuehrungInReservierungSupervisor.getInstance().getAuffuehrung(this).getTheObject();
         Kunde kunde = KundeInReservierungSupervisor.getInstance().getKunde(this).getTheObject();
         return Reservierung.instantiateRuntimeCopy(this, auffuehrung, kunde);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Auffuehrung getAuffuehrung() throws PersistenceException{
      return this.getTheObject().getAuffuehrung();
   }
   public void setAuffuehrung(Auffuehrung newAuffuehrung)throws PersistenceException{
      this.getTheObject().setAuffuehrung(newAuffuehrung);
   }
   public Kunde getKunde() throws PersistenceException{
      return this.getTheObject().getKunde();
   }
   public void setKunde(Kunde newKunde)throws PersistenceException{
      this.getTheObject().setKunde(newKunde);
   }
   public List<Sitzplatz> getPlaetze() throws PersistenceException{
      return this.getTheObject().getPlaetze();
   }
   public void addToPlaetze(Sitzplatz arg) throws PersistenceException{
      this.getTheObject().addToPlaetze(arg);
   }
   public boolean removeFromPlaetze(Sitzplatz arg) throws PersistenceException{
      return this.getTheObject().removeFromPlaetze(arg);
   }
}
