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
import generated.kinoApp.proxies.IReservierung;
import generated.kinoApp.relationControl.KundeInReservierungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.KundeProxy;
import observation.Observable;
import generated.kinoApp.proxies.IKunde;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Kunde extends Observable implements java.io.Serializable, IKunde
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String firstName;
   private String lastName;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Kunde(Integer id, String firstName, String lastName, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.firstName = firstName;
      this.lastName = lastName;
      if(objectOnly) return;
   }
   public static Kunde createFresh(String firstName, String lastName)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Kunde", "id, typeKey, firstName, lastName", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Kunde").toString() + ", " + "'" + firstName + "'" + ", " + "'" + lastName + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Kunde me = new Kunde(id, firstName, lastName, false);
      KinoApp.getInstance().addKundeProxy(new KundeProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getKundeCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Kunde toBeDeleted = KinoApp.getInstance().getKunde(id);
      List<IReservierung> ownersInKundeInReservierung = KundeInReservierungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInKundeInReservierung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association KundeInReservierung");
      KundeInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoApp.getInstance().getKundeCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Kunde", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Kunde instantiateRuntimeCopy(KundeProxy proxy, String firstName, String lastName){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Kunde(proxy.getId(), firstName, lastName, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Kunde getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKunde)) return false;
      return ((IKunde)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getFirstName() {
      return this.firstName;
   }
   public void setFirstName(String newFirstName) throws PersistenceException{
      this.firstName = newFirstName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Kunde", "firstName", "'" + newFirstName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getLastName() {
      return this.lastName;
   }
   public void setLastName(String newLastName) throws PersistenceException{
      this.lastName = newLastName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Kunde", "lastName", "'" + newLastName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
