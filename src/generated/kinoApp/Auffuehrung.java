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
import java.util.stream.Collector;
import java.util.stream.Collectors;

import generated.kinoApp.proxies.IReservierung;
import generated.kinoApp.relationControl.AuffuehrungInReservierungSupervisor;
import generated.kinoApp.relationControl.FilmInAuffuehrungSupervisor;
import generated.kinoApp.relationControl.SaalInAuffuehrungSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.kinoApp.proxies.AuffuehrungProxy;
import observation.Observable;
import generated.kinoApp.proxies.IAuffuehrung;
import generated.kinoApp.relationControl.*;
import generated.kinoApp.proxies.*;
import db.executer.PersistenceException;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Auffuehrung extends Observable implements java.io.Serializable, IAuffuehrung
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer auffuehrungId;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Auffuehrung(Integer id, Film film, Kinosaal kinosaal, Integer auffuehrungId, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      FilmInAuffuehrungSupervisor.getInstance().set(this, film);
      SaalInAuffuehrungSupervisor.getInstance().set(this, kinosaal);
      this.auffuehrungId = auffuehrungId;
      if(objectOnly) return;
   }
   public static Auffuehrung createFresh(Film film, Kinosaal kinosaal, Integer auffuehrungId)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Auffuehrung", "id, typeKey, auffuehrungId", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoApp", "Auffuehrung").toString() + ", " + auffuehrungId.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Auffuehrung me = new Auffuehrung(id, film, kinosaal, auffuehrungId, false);
      KinoApp.getInstance().addAuffuehrungProxy(new AuffuehrungProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoApp.getInstance().getAuffuehrungCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Auffuehrung toBeDeleted = KinoApp.getInstance().getAuffuehrung(id);
      List<IReservierung> ownersInAuffuehrungInReservierung = AuffuehrungInReservierungSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInAuffuehrungInReservierung.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association AuffuehrungInReservierung");
      AuffuehrungInReservierungSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      FilmInAuffuehrungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      SaalInAuffuehrungSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoApp.getInstance().getAuffuehrungCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Auffuehrung", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Auffuehrung instantiateRuntimeCopy(AuffuehrungProxy proxy, Film film, Kinosaal kinosaal, Integer auffuehrungId)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Auffuehrung(proxy.getId(), film, kinosaal, auffuehrungId, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Auffuehrung getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IAuffuehrung)) return false;
      return ((IAuffuehrung)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Film getFilm() throws PersistenceException{
      return FilmInAuffuehrungSupervisor.getInstance().getFilm(this).getTheObject();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      FilmInAuffuehrungSupervisor.getInstance().change(this, this.getFilm(), newFilm);
   }
   public Kinosaal getKinosaal() throws PersistenceException{
      return SaalInAuffuehrungSupervisor.getInstance().getKinosaal(this).getTheObject();
   }
   public void setKinosaal(Kinosaal newKinosaal)throws PersistenceException{
      SaalInAuffuehrungSupervisor.getInstance().change(this, this.getKinosaal(), newKinosaal);
   }
   public Integer getAuffuehrungId() {
      return this.auffuehrungId;
   }
   public void setAuffuehrungId(Integer newAuffuehrungId) throws PersistenceException{
      this.auffuehrungId = newAuffuehrungId;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Auffuehrung", "auffuehrungId", newAuffuehrungId.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<Reservierung> getReservierungen() throws PersistenceException{
      Set<Reservierung> result = new HashSet<>();
      for (IReservierung i : AuffuehrungInReservierungSupervisor.getInstance().getReservierungen(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Liefert alle Reihen in dieser Auffuehrung zu der angegebenen Kategorie
 */
   public Collection<Reihe> gibReihenFuer(Kategorie kategorie){
	  return this.getKinosaal().getReihen().stream().filter((r)->r.getKategorie()==kategorie).collect(Collectors.toList());
   }
//90 ===== GENERATED: End of Your Operations ======
}
