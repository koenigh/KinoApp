/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Sitzplatz;
import generated.kinoApp.Reihe;
public interface ISitzplatz extends Identifiable{
   public Sitzplatz getTheObject();
   public Integer getId();
   public String getIdentifikation() ;
   public void setIdentifikation(String newIdentifikation) throws PersistenceException;
   public Reihe getReihe() throws PersistenceException;
}
