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
import generated.kinoApp.relationControl.PlaetzeInReservierungSupervisor;
import generated.kinoApp.relationControl.PlaetzeDerReiheSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.SitzplatzProxy;
import observation.Observable;
import generated.kinoApp.proxies.ISitzplatz;
import db.executer.PersistenceException;
import generated.kinoApp.relationControl.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Sitzplatz extends Observable implements java.io.Serializable, ISitzplatz
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String identifikation;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Sitzplatz(Integer id, String identifikation, Reihe reihe, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      this.identifikation = identifikation;
      if(objectOnly) return;
      try{PlaetzeDerReiheSupervisor.getInstance().add(reihe,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Sitzplatz createFresh(String identifikation, Reihe reihe)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Sitzplatz", "id, typeKey, identifikation", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Sitzplatz").toString() + ", " + "'" + identifikation + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Sitzplatz me = new Sitzplatz(id, identifikation, reihe, false);
      KinoApp.getInstance().addSitzplatzProxy(new SitzplatzProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getSitzplatzCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Sitzplatz toBeDeleted = KinoApp.getInstance().getSitzplatz(id);
      PlaetzeInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      PlaetzeDerReiheSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoApp.getInstance().getSitzplatzCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Sitzplatz", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Sitzplatz instantiateRuntimeCopy(SitzplatzProxy proxy, String identifikation, Reihe reihe)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Sitzplatz(proxy.getId(), identifikation, reihe, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Sitzplatz getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISitzplatz)) return false;
      return ((ISitzplatz)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getIdentifikation() {
      return this.identifikation;
   }
   public void setIdentifikation(String newIdentifikation) throws PersistenceException{
      this.identifikation = newIdentifikation;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Sitzplatz", "identifikation", "'" + newIdentifikation + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Reihe getReihe() throws PersistenceException{
      return PlaetzeDerReiheSupervisor.getInstance().getReihe(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Ermittelt den Preis des Platzes - hat den Wert 0, wenn in der Reihenkategorie kein Preis eingetragen ist
 */
   public baseTypes.Rational gibPreis(){
	  if(this.getReihe().getKategorie().getPreis().isEmpty()) return new Rational(0); 
      return this.getReihe().getKategorie().getPreis().get();
   }
//90 ===== GENERATED: End of Your Operations ======
}
