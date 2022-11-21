/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Kunde;
public interface IKunde extends Identifiable{
   public Kunde getTheObject();
   public Integer getId();
   public String getFirstName() ;
   public void setFirstName(String newFirstName) throws PersistenceException;
   public String getLastName() ;
   public void setLastName(String newLastName) throws PersistenceException;
}
