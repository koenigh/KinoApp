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
import generated.kinoApp.relationControl.DatumInBuchungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.DatumProxy;
import observation.Observable;
import generated.kinoApp.proxies.IDatum;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Datum extends Observable implements java.io.Serializable, IDatum
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer jahr;
   private Integer monat;
   private Integer tag;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Datum(Integer id, Integer jahr, Integer monat, Integer tag, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.jahr = jahr;
      this.monat = monat;
      this.tag = tag;
      if(objectOnly) return;
   }
   public static Datum createFresh(Integer jahr, Integer monat, Integer tag)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Datum", "id, typeKey, jahr, monat, tag", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Datum").toString() + ", " + jahr.toString() + ", " + monat.toString() + ", " + tag.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Datum me = new Datum(id, jahr, monat, tag, false);
      KinoApp.getInstance().addDatumProxy(new DatumProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getDatumCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Datum toBeDeleted = KinoApp.getInstance().getDatum(id);
      List<IBuchung> ownersInDatumInBuchung = DatumInBuchungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInDatumInBuchung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association DatumInBuchung");
      DatumInBuchungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoApp.getInstance().getDatumCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Datum", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Datum instantiateRuntimeCopy(DatumProxy proxy, Integer jahr, Integer monat, Integer tag){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Datum(proxy.getId(), jahr, monat, tag, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Datum getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IDatum)) return false;
      return ((IDatum)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Integer getJahr() {
      return this.jahr;
   }
   public void setJahr(Integer newJahr) throws PersistenceException{
      this.jahr = newJahr;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Datum", "jahr", newJahr.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getMonat() {
      return this.monat;
   }
   public void setMonat(Integer newMonat) throws PersistenceException{
      this.monat = newMonat;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Datum", "monat", newMonat.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getTag() {
      return this.tag;
   }
   public void setTag(Integer newTag) throws PersistenceException{
      this.tag = newTag;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Datum", "tag", newTag.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
   public String toString() {
	   return this.tag + "." + this.monat + "." + this.jahr;
   }
//90 ===== GENERATED: End of Your Operations ======
}
