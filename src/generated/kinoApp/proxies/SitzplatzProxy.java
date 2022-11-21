/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Sitzplatz;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Reihe;
import generated.kinoApp.relationControl.PlaetzeDerReiheSupervisor;
public class SitzplatzProxy implements ISitzplatz{
   private Integer id;
   private Optional<Sitzplatz> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public SitzplatzProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SitzplatzProxy(Sitzplatz theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Sitzplatz getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Sitzplatz";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISitzplatz)) return false;
      return ((ISitzplatz)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Sitzplatz load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Sitzplatz", this.id);
         String identifikation = rs.get().getString("identifikation");
         Reihe reihe = PlaetzeDerReiheSupervisor.getInstance().getReihe(this).getTheObject();
         return Sitzplatz.instantiateRuntimeCopy(this, identifikation, reihe);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getIdentifikation() {
      return this.getTheObject().getIdentifikation();
   }
   public void setIdentifikation(String newIdentifikation) throws PersistenceException{
      this.getTheObject().setIdentifikation(newIdentifikation);
   }
   public Reihe getReihe() throws PersistenceException{
      return this.getTheObject().getReihe();
   }
}
