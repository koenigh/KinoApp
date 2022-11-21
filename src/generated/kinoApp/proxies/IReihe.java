/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.kinoApp.Reihe;
import generated.kinoApp.Sitzplatz;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.kinoApp.Kategorie;
public interface IReihe extends Identifiable{
   public Reihe getTheObject();
   public Integer getId();
   public List<Sitzplatz> getSitzplaetze() throws PersistenceException;
   public void addToSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException;
   public Kategorie getKategorie() throws PersistenceException;
   public void setKategorie(Kategorie newKategorie)throws PersistenceException;
   public String getBuchstabe() ;
   public void setBuchstabe(String newBuchstabe) throws PersistenceException;
}
