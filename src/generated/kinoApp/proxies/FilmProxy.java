/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Film;
import java.sql.ResultSet;
import java.util.Optional;
public class FilmProxy implements IFilm{
   private Integer id;
   private Optional<Film> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public FilmProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public FilmProxy(Film theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Film getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Film";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilm)) return false;
      return ((IFilm)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Film load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Film", this.id);
         String bezeichnung = rs.get().getString("bezeichnung");
         Integer laenge = rs.get().getInt("laenge");
         return Film.instantiateRuntimeCopy(this, bezeichnung, laenge);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getBezeichnung() {
      return this.getTheObject().getBezeichnung();
   }
   public void setBezeichnung(String newBezeichnung) throws PersistenceException{
      this.getTheObject().setBezeichnung(newBezeichnung);
   }
   public Integer getLaenge() {
      return this.getTheObject().getLaenge();
   }
   public void setLaenge(Integer newLaenge) throws PersistenceException{
      this.getTheObject().setLaenge(newLaenge);
   }
}
