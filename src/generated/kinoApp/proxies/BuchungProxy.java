/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Buchung;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Datum;
import generated.kinoApp.relationControl.DatumInBuchungSupervisor;
import generated.kinoApp.Reservierung;
import generated.kinoApp.relationControl.ReservierungDerBuchungSupervisor;
public class BuchungProxy implements IBuchung{
   private Integer id;
   private Optional<Buchung> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BuchungProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BuchungProxy(Buchung theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Buchung getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Buchung";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBuchung)) return false;
      return ((IBuchung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Buchung load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Buchung", this.id);
         Datum eingangsDatum = DatumInBuchungSupervisor.getInstance().getEingangsDatum(this).getTheObject();
         Reservierung reservierung = ReservierungDerBuchungSupervisor.getInstance().getReservierung(this).getTheObject();
         return Buchung.instantiateRuntimeCopy(this, eingangsDatum, reservierung);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Datum getEingangsDatum() throws PersistenceException{
      return this.getTheObject().getEingangsDatum();
   }
   public void setEingangsDatum(Datum newEingangsDatum)throws PersistenceException{
      this.getTheObject().setEingangsDatum(newEingangsDatum);
   }
   public Reservierung getReservierung() throws PersistenceException{
      return this.getTheObject().getReservierung();
   }
   public void setReservierung(Reservierung newReservierung)throws PersistenceException{
      this.getTheObject().setReservierung(newReservierung);
   }
}
