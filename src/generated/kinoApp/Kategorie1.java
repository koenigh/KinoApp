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
import java.util.Optional;
import java.sql.ResultSet;
import idManagement.IDManagerTransient;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.IKategorie1;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Kategorie1 extends Kategorie implements java.io.Serializable, IKategorie1
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Kategorie1> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Kategorie1(Integer id, Optional<baseTypes.Rational> preis, Optional<String> bezeichnung, boolean objectOnly)
   {
      super(id, preis, bezeichnung, objectOnly);
      if(objectOnly) return;
   }
   private static Kategorie1 instantiateRuntimeCopy(Integer id, Optional<baseTypes.Rational> preis, Optional<String> bezeichnung){
      return new Kategorie1(id, preis, bezeichnung, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Kategorie1 getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Kategorie1 load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Kategorie1");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Kategorie", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         Optional<baseTypes.Rational> preis = Optional.empty();
         if(rs.isPresent()) preis = (rs.get().getObject("preis") == null ? Optional.empty() : Optional.of(new baseTypes.Rational(rs.get().getString("preis"))));
         Optional<String> bezeichnung = Optional.empty();
         if(rs.isPresent()) bezeichnung = (rs.get().getObject("bezeichnung") == null ? Optional.empty() : Optional.of(rs.get().getString("bezeichnung")));
         return Kategorie1.instantiateRuntimeCopy(id, preis, bezeichnung);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Kategorie1 getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
