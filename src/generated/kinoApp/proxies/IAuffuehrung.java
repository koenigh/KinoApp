/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Auffuehrung;
import generated.kinoApp.Film;
import generated.kinoApp.Kinosaal;
import generated.kinoApp.Reservierung;
import java.util.Set;
public interface IAuffuehrung extends Identifiable{
   public Auffuehrung getTheObject();
   public Integer getId();
   public Film getFilm() throws PersistenceException;
   public void setFilm(Film newFilm)throws PersistenceException;
   public Kinosaal getKinosaal() throws PersistenceException;
   public void setKinosaal(Kinosaal newKinosaal)throws PersistenceException;
   public Integer getAuffuehrungId() ;
   public void setAuffuehrungId(Integer newAuffuehrungId) throws PersistenceException;
   public Set<Reservierung> getReservierungen() throws PersistenceException;
}
