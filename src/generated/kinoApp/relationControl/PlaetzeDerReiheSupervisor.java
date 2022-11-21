/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoApp.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.kinoApp.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class PlaetzeDerReiheSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static PlaetzeDerReiheSupervisor theInstance = new PlaetzeDerReiheSupervisor();
   private Relation<IReihe, ISitzplatz> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private PlaetzeDerReiheSupervisor(){
      this.elements = new Relation<>("PlaetzeDerReihe");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static PlaetzeDerReiheSupervisor getInstance(){return theInstance;}
   public Relation<IReihe, ISitzplatz> getRelationData() {
      return this.elements;
   }
   public List<ISitzplatz> getSitzplaetze(IReihe owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IReihe owner, ISitzplatz target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IReihe owner, ISitzplatz target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IReihe owner, ISitzplatz target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public IReihe getReihe(ISitzplatz target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
