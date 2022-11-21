/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Datum;
import java.sql.ResultSet;
import java.util.Optional;
public class DatumProxy implements IDatum{
   private Integer id;
   private Optional<Datum> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public DatumProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public DatumProxy(Datum theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Datum getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Datum";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IDatum)) return false;
      return ((IDatum)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Datum load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Datum", this.id);
         Integer jahr = rs.get().getInt("jahr");
         Integer monat = rs.get().getInt("monat");
         Integer tag = rs.get().getInt("tag");
         return Datum.instantiateRuntimeCopy(this, jahr, monat, tag);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Integer getJahr() {
      return this.getTheObject().getJahr();
   }
   public void setJahr(Integer newJahr) throws PersistenceException{
      this.getTheObject().setJahr(newJahr);
   }
   public Integer getMonat() {
      return this.getTheObject().getMonat();
   }
   public void setMonat(Integer newMonat) throws PersistenceException{
      this.getTheObject().setMonat(newMonat);
   }
   public Integer getTag() {
      return this.getTheObject().getTag();
   }
   public void setTag(Integer newTag) throws PersistenceException{
      this.getTheObject().setTag(newTag);
   }
}
