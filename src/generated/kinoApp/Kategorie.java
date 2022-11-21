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
import observation.Observable;
import generated.kinoApp.proxies.IKategorie;
import java.util.Optional;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Kategorie extends Observable implements java.io.Serializable, IKategorie
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<baseTypes.Rational> preis;
   private Optional<String> bezeichnung;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Kategorie(Integer id, Optional<baseTypes.Rational> preis, Optional<String> bezeichnung, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.preis = preis;
      this.bezeichnung = bezeichnung;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Kategorie getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKategorie)) return false;
      return ((IKategorie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<baseTypes.Rational> getPreis() {
      return this.preis;
   }
   public void setPreis(baseTypes.Rational newPreis) throws PersistenceException{
      this.preis = Optional.of(newPreis);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Kategorie", "preis", "'" + newPreis.toString() + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Optional<String> getBezeichnung() {
      return this.bezeichnung;
   }
   public void setBezeichnung(String newBezeichnung) throws PersistenceException{
      this.bezeichnung = Optional.of(newBezeichnung);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Kategorie", "bezeichnung", "'" + newBezeichnung + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
