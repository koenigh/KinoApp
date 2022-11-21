/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoApp;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;

import baseTypes.Rational;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import generated.kinoApp.relationControl.DatumInBuchungSupervisor;
import generated.kinoApp.relationControl.ReservierungDerBuchungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.BuchungProxy;
import observation.Observable;
import generated.kinoApp.proxies.IBuchung;
import generated.kinoApp.relationControl.*;
import generated.kinoApp.proxies.*;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Buchung extends Observable implements java.io.Serializable, IBuchung
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Buchung(Integer id, Datum eingangsDatum, Reservierung reservierung, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      DatumInBuchungSupervisor.getInstance().set(this, eingangsDatum);
      ReservierungDerBuchungSupervisor.getInstance().set(this, reservierung);
      if(objectOnly) return;
   }
   public static Buchung createFresh(Datum eingangsDatum, Reservierung reservierung)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Buchung", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Buchung").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Buchung me = new Buchung(id, eingangsDatum, reservierung, false);
      KinoApp.getInstance().addBuchungProxy(new BuchungProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getBuchungCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Buchung toBeDeleted = KinoApp.getInstance().getBuchung(id);
      DatumInBuchungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      ReservierungDerBuchungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoApp.getInstance().getBuchungCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Buchung", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Buchung instantiateRuntimeCopy(BuchungProxy proxy, Datum eingangsDatum, Reservierung reservierung)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Buchung(proxy.getId(), eingangsDatum, reservierung, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Buchung getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBuchung)) return false;
      return ((IBuchung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Datum getEingangsDatum() throws PersistenceException{
      return DatumInBuchungSupervisor.getInstance().getEingangsDatum(this).getTheObject();
   }
   public void setEingangsDatum(Datum newEingangsDatum)throws PersistenceException{
      DatumInBuchungSupervisor.getInstance().change(this, this.getEingangsDatum(), newEingangsDatum);
   }
   public Reservierung getReservierung() throws PersistenceException{
      return ReservierungDerBuchungSupervisor.getInstance().getReservierung(this).getTheObject();
   }
   public void setReservierung(Reservierung newReservierung)throws PersistenceException{
      ReservierungDerBuchungSupervisor.getInstance().change(this, this.getReservierung(), newReservierung);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Preis der Buchung - setzt sich zusammen aus allen darauf gebuchten Platzpreisen
 */
   public baseTypes.Rational berechnePreis(){
      Rational result = new Rational(0);
      for (Sitzplatz platz : this.getReservierung().getPlaetze()) result = Rational.add(result, platz.gibPreis());
      return result;
   }
//90 ===== GENERATED: End of Your Operations ======
}
