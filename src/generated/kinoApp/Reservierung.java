/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoApp;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import java.util.List;
import generated.kinoApp.proxies.IBuchung;
import generated.kinoApp.relationControl.ReservierungDerBuchungSupervisor;
import generated.kinoApp.relationControl.AuffuehrungInReservierungSupervisor;
import generated.kinoApp.relationControl.KundeInReservierungSupervisor;
import generated.kinoApp.relationControl.PlaetzeInReservierungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.ReservierungProxy;
import observation.Observable;
import generated.kinoApp.proxies.IReservierung;
import generated.kinoApp.relationControl.*;
import generated.kinoApp.proxies.*;
import db.executer.PersistenceException;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservierung extends Observable implements java.io.Serializable, IReservierung
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservierung(Integer id, Auffuehrung auffuehrung, Kunde kunde, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      AuffuehrungInReservierungSupervisor.getInstance().set(this, auffuehrung);
      KundeInReservierungSupervisor.getInstance().set(this, kunde);
      if(objectOnly) return;
   }
   public static Reservierung createFresh(Auffuehrung auffuehrung, Kunde kunde)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservierung", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Reservierung").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservierung me = new Reservierung(id, auffuehrung, kunde, false);
      KinoApp.getInstance().addReservierungProxy(new ReservierungProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getReservierungCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Reservierung toBeDeleted = KinoApp.getInstance().getReservierung(id);
      List<IBuchung> ownersInReservierungDerBuchung = ReservierungDerBuchungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInReservierungDerBuchung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association ReservierungDerBuchung");
      ReservierungDerBuchungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      AuffuehrungInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KundeInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      PlaetzeInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoApp.getInstance().getReservierungCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Reservierung", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservierung instantiateRuntimeCopy(ReservierungProxy proxy, Auffuehrung auffuehrung, Kunde kunde)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservierung(proxy.getId(), auffuehrung, kunde, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reservierung getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservierung)) return false;
      return ((IReservierung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Auffuehrung getAuffuehrung() throws PersistenceException{
      return AuffuehrungInReservierungSupervisor.getInstance().getAuffuehrung(this).getTheObject();
   }
   public void setAuffuehrung(Auffuehrung newAuffuehrung)throws PersistenceException{
      AuffuehrungInReservierungSupervisor.getInstance().change(this, this.getAuffuehrung(), newAuffuehrung);
   }
   public Kunde getKunde() throws PersistenceException{
      return KundeInReservierungSupervisor.getInstance().getKunde(this).getTheObject();
   }
   public void setKunde(Kunde newKunde)throws PersistenceException{
      KundeInReservierungSupervisor.getInstance().change(this, this.getKunde(), newKunde);
   }
   public List<Sitzplatz> getPlaetze() throws PersistenceException{
      List<Sitzplatz> result = new ArrayList<>();
      for (ISitzplatz i : PlaetzeInReservierungSupervisor.getInstance().getPlaetze(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToPlaetze(Sitzplatz arg) throws PersistenceException{
      PlaetzeInReservierungSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromPlaetze(Sitzplatz arg) throws PersistenceException{
      return PlaetzeInReservierungSupervisor.getInstance().remove(this, arg);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
