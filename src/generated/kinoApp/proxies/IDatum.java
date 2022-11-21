/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Datum;
public interface IDatum extends Identifiable{
   public Datum getTheObject();
   public Integer getId();
   public Integer getJahr() ;
   public void setJahr(Integer newJahr) throws PersistenceException;
   public Integer getMonat() ;
   public void setMonat(Integer newMonat) throws PersistenceException;
   public Integer getTag() ;
   public void setTag(Integer newTag) throws PersistenceException;
}
