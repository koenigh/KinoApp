/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Film;
public interface IFilm extends Identifiable{
   public Film getTheObject();
   public Integer getId();
   public String getBezeichnung() ;
   public void setBezeichnung(String newBezeichnung) throws PersistenceException;
   public Integer getLaenge() ;
   public void setLaenge(Integer newLaenge) throws PersistenceException;
}
