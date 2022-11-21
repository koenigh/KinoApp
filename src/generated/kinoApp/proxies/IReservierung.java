/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Reservierung;
import generated.kinoApp.Auffuehrung;
import generated.kinoApp.Kunde;
import generated.kinoApp.Sitzplatz;
import java.util.List;
public interface IReservierung extends Identifiable{
   public Reservierung getTheObject();
   public Integer getId();
   public Auffuehrung getAuffuehrung() throws PersistenceException;
   public void setAuffuehrung(Auffuehrung newAuffuehrung)throws PersistenceException;
   public Kunde getKunde() throws PersistenceException;
   public void setKunde(Kunde newKunde)throws PersistenceException;
   public List<Sitzplatz> getPlaetze() throws PersistenceException;
   public void addToPlaetze(Sitzplatz arg) throws PersistenceException;
   public boolean removeFromPlaetze(Sitzplatz arg) throws PersistenceException;
}
