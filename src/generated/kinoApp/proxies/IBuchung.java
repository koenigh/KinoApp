/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Buchung;
import generated.kinoApp.Datum;
import generated.kinoApp.Reservierung;
public interface IBuchung extends Identifiable{
   public Buchung getTheObject();
   public Integer getId();
   public Datum getEingangsDatum() throws PersistenceException;
   public void setEingangsDatum(Datum newEingangsDatum)throws PersistenceException;
   public Reservierung getReservierung() throws PersistenceException;
   public void setReservierung(Reservierung newReservierung)throws PersistenceException;
}
