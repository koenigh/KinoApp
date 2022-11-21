/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Kinosaal;
import generated.kinoApp.Reihe;
import java.util.List;
public interface IKinosaal extends Identifiable{
   public Kinosaal getTheObject();
   public Integer getId();
   public List<Reihe> getReihen() throws PersistenceException;
   public void addToReihen(Reihe arg) throws PersistenceException;
   public boolean removeFromReihen(Reihe arg) throws PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}
