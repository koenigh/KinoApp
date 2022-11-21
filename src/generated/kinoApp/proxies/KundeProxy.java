/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Kunde;
import java.sql.ResultSet;
import java.util.Optional;
public class KundeProxy implements IKunde{
   private Integer id;
   private Optional<Kunde> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public KundeProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public KundeProxy(Kunde theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Kunde getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Kunde";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKunde)) return false;
      return ((IKunde)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Kunde load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Kunde", this.id);
         String firstName = rs.get().getString("firstName");
         String lastName = rs.get().getString("lastName");
         return Kunde.instantiateRuntimeCopy(this, firstName, lastName);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getFirstName() {
      return this.getTheObject().getFirstName();
   }
   public void setFirstName(String newFirstName) throws PersistenceException{
      this.getTheObject().setFirstName(newFirstName);
   }
   public String getLastName() {
      return this.getTheObject().getLastName();
   }
   public void setLastName(String newLastName) throws PersistenceException{
      this.getTheObject().setLastName(newLastName);
   }
}
