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
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class DatumInBuchungSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static DatumInBuchungSupervisor theInstance = new DatumInBuchungSupervisor();
   private Relation<IBuchung, IDatum> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private DatumInBuchungSupervisor(){
      this.elements = new Relation<>("DatumInBuchung");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static DatumInBuchungSupervisor getInstance(){return theInstance;}
   public Relation<IBuchung, IDatum> getRelationData() {
      return this.elements;
   }
   public IDatum getEingangsDatum(IBuchung owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IBuchung owner, IDatum target) throws PersistenceException{
      IDatum targetOld = this.getEingangsDatum(owner); IDatum targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IBuchung owner, IDatum target) {
      IDatum targetOld = null; IDatum targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IBuchung owner, IDatum targetOld, IDatum targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
