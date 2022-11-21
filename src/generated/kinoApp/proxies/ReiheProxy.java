/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.kinoApp.Reihe;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoApp.Sitzplatz;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.kinoApp.Kategorie;
import generated.kinoApp.relationControl.KategorieDerReiheSupervisor;
public class ReiheProxy implements IReihe{
   private Integer id;
   private Optional<Reihe> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReiheProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReiheProxy(Reihe theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reihe getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reihe";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReihe)) return false;
      return ((IReihe)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reihe load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reihe", this.id);
         Kategorie kategorie = KategorieDerReiheSupervisor.getInstance().getKategorie(this).getTheObject();
         String buchstabe = rs.get().getString("buchstabe");
         return Reihe.instantiateRuntimeCopy(this, kategorie, buchstabe);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Sitzplatz> getSitzplaetze() throws PersistenceException{
      return this.getTheObject().getSitzplaetze();
   }
   public void addToSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToSitzplaetze(arg);
   }
   public boolean removeFromSitzplaetze(Sitzplatz arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromSitzplaetze(arg);
   }
   public Kategorie getKategorie() throws PersistenceException{
      return this.getTheObject().getKategorie();
   }
   public void setKategorie(Kategorie newKategorie)throws PersistenceException{
      this.getTheObject().setKategorie(newKategorie);
   }
   public String getBuchstabe() {
      return this.getTheObject().getBuchstabe();
   }
   public void setBuchstabe(String newBuchstabe) throws PersistenceException{
      this.getTheObject().setBuchstabe(newBuchstabe);
   }
}
