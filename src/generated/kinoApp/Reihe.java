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
import generated.kinoApp.proxies.ISitzplatz;
import generated.kinoApp.relationControl.PlaetzeDerReiheSupervisor;
import generated.kinoApp.relationControl.KategorieDerReiheSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.ReiheProxy;
import observation.Observable;
import generated.kinoApp.proxies.IReihe;
import generated.kinoApp.relationControl.*;
import generated.kinoApp.proxies.*;
import db.executer.PersistenceException;
import java.util.ArrayList;
import generated.kinoApp.relationControl.ReihenDesSaalsSupervisor;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reihe extends Observable implements java.io.Serializable, IReihe
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String buchstabe;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reihe(Integer id, Kategorie kategorie, String buchstabe, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      KategorieDerReiheSupervisor.getInstance().set(this, kategorie);
      this.buchstabe = buchstabe;
      if(objectOnly) return;
   }
   public static Reihe createFresh(Kategorie kategorie, String buchstabe)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reihe", "id, typeKey, buchstabe", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Reihe").toString() + ", " + "'" + buchstabe + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reihe me = new Reihe(id, kategorie, buchstabe, false);
      KinoApp.getInstance().addReiheProxy(new ReiheProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getReiheCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Reihe toBeDeleted = KinoApp.getInstance().getReihe(id);
      ReihenDesSaalsSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<ISitzplatz> targetsInPlaetzeDerReihe = PlaetzeDerReiheSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInPlaetzeDerReihe.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association PlaetzeDerReihe");
      PlaetzeDerReiheSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KategorieDerReiheSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoApp.getInstance().getReiheCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Reihe", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reihe instantiateRuntimeCopy(ReiheProxy proxy, Kategorie kategorie, String buchstabe)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reihe(proxy.getId(), kategorie, buchstabe, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reihe getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReihe)) return false;
      return ((IReihe)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Sitzplatz> getSitzplaetze() throws PersistenceException{
      List<Sitzplatz> result = new ArrayList<>();
      for (ISitzplatz i : PlaetzeDerReiheSupervisor.getInstance().getSitzplaetze(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException{
      PlaetzeDerReiheSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException{
      return PlaetzeDerReiheSupervisor.getInstance().remove(this, arg);
   }
   public Kategorie getKategorie() throws PersistenceException{
      return KategorieDerReiheSupervisor.getInstance().getKategorie(this).getTheObject();
   }
   public void setKategorie(Kategorie newKategorie)throws PersistenceException{
      KategorieDerReiheSupervisor.getInstance().change(this, this.getKategorie(), newKategorie);
   }
   public String getBuchstabe() {
      return this.buchstabe;
   }
   public void setBuchstabe(String newBuchstabe) throws PersistenceException{
      this.buchstabe = newBuchstabe;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Reihe", "buchstabe", "'" + newBuchstabe + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
