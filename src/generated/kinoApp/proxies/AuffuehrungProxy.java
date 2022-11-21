/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Auffuehrung;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Film;
import generated.kinoApp.relationControl.FilmInAuffuehrungSupervisor;
import generated.kinoApp.Kinosaal;
import generated.kinoApp.relationControl.SaalInAuffuehrungSupervisor;
import generated.kinoApp.Reservierung;
import java.util.Set;
public class AuffuehrungProxy implements IAuffuehrung{
   private Integer id;
   private Optional<Auffuehrung> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public AuffuehrungProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public AuffuehrungProxy(Auffuehrung theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Auffuehrung getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Auffuehrung";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IAuffuehrung)) return false;
      return ((IAuffuehrung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Auffuehrung load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Auffuehrung", this.id);
         Film film = FilmInAuffuehrungSupervisor.getInstance().getFilm(this).getTheObject();
         Kinosaal kinosaal = SaalInAuffuehrungSupervisor.getInstance().getKinosaal(this).getTheObject();
         Integer auffuehrungId = rs.get().getInt("auffuehrungId");
         return Auffuehrung.instantiateRuntimeCopy(this, film, kinosaal, auffuehrungId);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Film getFilm() throws PersistenceException{
      return this.getTheObject().getFilm();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      this.getTheObject().setFilm(newFilm);
   }
   public Kinosaal getKinosaal() throws PersistenceException{
      return this.getTheObject().getKinosaal();
   }
   public void setKinosaal(Kinosaal newKinosaal)throws PersistenceException{
      this.getTheObject().setKinosaal(newKinosaal);
   }
   public Integer getAuffuehrungId() {
      return this.getTheObject().getAuffuehrungId();
   }
   public void setAuffuehrungId(Integer newAuffuehrungId) throws PersistenceException{
      this.getTheObject().setAuffuehrungId(newAuffuehrungId);
   }
   public Set<Reservierung> getReservierungen() throws PersistenceException{
      return this.getTheObject().getReservierungen();
   }
}
