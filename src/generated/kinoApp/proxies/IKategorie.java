/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Kategorie;
import java.util.Optional;
public interface IKategorie extends Identifiable{
   public Kategorie getTheObject();
   public Optional<baseTypes.Rational> getPreis() ;
   public void setPreis(baseTypes.Rational newPreis) throws PersistenceException;
   public Optional<String> getBezeichnung() ;
   public void setBezeichnung(String newBezeichnung) throws PersistenceException;
}
