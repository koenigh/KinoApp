/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoApp;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import java.util.List;
import generated.kinoApp.proxies.IAuffuehrung;
import generated.kinoApp.relationControl.FilmInAuffuehrungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.FilmProxy;
import observation.Observable;
import generated.kinoApp.proxies.IFilm;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Film extends Observable implements java.io.Serializable, IFilm
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String bezeichnung;
   private Integer laenge;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Film(Integer id, String bezeichnung, Integer laenge, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.bezeichnung = bezeichnung;
      this.laenge = laenge;
      if(objectOnly) return;
   }
   public static Film createFresh(String bezeichnung, Integer laenge)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Film", "id, typeKey, bezeichnung, laenge", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Film").toString() + ", " + "'" + bezeichnung + "'" + ", " + laenge.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Film me = new Film(id, bezeichnung, laenge, false);
      KinoApp.getInstance().addFilmProxy(new FilmProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getFilmCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Film toBeDeleted = KinoApp.getInstance().getFilm(id);
      List<IAuffuehrung> ownersInFilmInAuffuehrung = FilmInAuffuehrungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInFilmInAuffuehrung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association FilmInAuffuehrung");
      FilmInAuffuehrungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoApp.getInstance().getFilmCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Film", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Film instantiateRuntimeCopy(FilmProxy proxy, String bezeichnung, Integer laenge){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Film(proxy.getId(), bezeichnung, laenge, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Film getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilm)) return false;
      return ((IFilm)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getBezeichnung() {
      return this.bezeichnung;
   }
   public void setBezeichnung(String newBezeichnung) throws PersistenceException{
      this.bezeichnung = newBezeichnung;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Film", "bezeichnung", "'" + newBezeichnung + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getLaenge() {
      return this.laenge;
   }
   public void setLaenge(Integer newLaenge) throws PersistenceException{
      this.laenge = newLaenge;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Film", "laenge", newLaenge.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
