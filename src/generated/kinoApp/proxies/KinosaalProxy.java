/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Kinosaal;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Reihe;
import java.util.List;
public class KinosaalProxy implements IKinosaal{
   private Integer id;
   private Optional<Kinosaal> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public KinosaalProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public KinosaalProxy(Kinosaal theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Kinosaal getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Kinosaal";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKinosaal)) return false;
      return ((IKinosaal)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Kinosaal load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Kinosaal", this.id);
         String name = rs.get().getString("name");
         return Kinosaal.instantiateRuntimeCopy(this, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Reihe> getReihen() throws PersistenceException{
      return this.getTheObject().getReihen();
   }
   public void addToReihen(Reihe arg) throws PersistenceException{
      this.getTheObject().addToReihen(arg);
   }
   public boolean removeFromReihen(Reihe arg) throws PersistenceException{
      return this.getTheObject().removeFromReihen(arg);
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
}
