/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import generated.kinoApp.Kategorie;
import java.util.Optional;
public abstract class KategorieProxy implements IKategorie{
   public abstract Kategorie getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IKategorie)) return false;
      return ((IKategorie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<baseTypes.Rational> getPreis() {
      return this.getTheObject().getPreis();
   }
   public void setPreis(baseTypes.Rational newPreis) throws PersistenceException{
      this.getTheObject().setPreis(newPreis);
   }
   public Optional<String> getBezeichnung() {
      return this.getTheObject().getBezeichnung();
   }
   public void setBezeichnung(String newBezeichnung) throws PersistenceException{
      this.getTheObject().setBezeichnung(newBezeichnung);
   }
}
