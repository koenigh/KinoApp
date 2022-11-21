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
import generated.kinoApp.proxies.IAuffuehrung;
import generated.kinoApp.relationControl.SaalInAuffuehrungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.KinosaalProxy;
import observation.Observable;
import generated.kinoApp.proxies.IKinosaal;
import db.executer.PersistenceException;
import generated.kinoApp.relationControl.ReihenDesSaalsSupervisor;
import generated.kinoApp.relationControl.*;
import generated.kinoApp.proxies.*;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Kinosaal extends Observable implements java.io.Serializable, IKinosaal
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Kinosaal(Integer id, String name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      if(objectOnly) return;
   }
   public static Kinosaal createFresh(String name)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Kinosaal", "id, typeKey, name", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Kinosaal").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Kinosaal me = new Kinosaal(id, name, false);
      KinoApp.getInstance().addKinosaalProxy(new KinosaalProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getKinosaalCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Kinosaal toBeDeleted = KinoApp.getInstance().getKinosaal(id);
      List<IAuffuehrung> ownersInSaalInAuffuehrung = SaalInAuffuehrungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInSaalInAuffuehrung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association SaalInAuffuehrung");
      SaalInAuffuehrungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      ReihenDesSaalsSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoApp.getInstance().getKinosaalCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Kinosaal", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Kinosaal instantiateRuntimeCopy(KinosaalProxy proxy, String name){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Kinosaal(proxy.getId(), name, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Kinosaal getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKinosaal)) return false;
      return ((IKinosaal)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Reihe> getReihen() throws PersistenceException{
      List<Reihe> result = new ArrayList<>();
      for (IReihe i : ReihenDesSaalsSupervisor.getInstance().getReihen(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToReihen(Reihe arg) throws PersistenceException{
      ReihenDesSaalsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromReihen(Reihe arg) throws PersistenceException{
      return ReihenDesSaalsSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Kinosaal", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
