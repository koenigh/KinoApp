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
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class ReihenDesSaalsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static ReihenDesSaalsSupervisor theInstance = new ReihenDesSaalsSupervisor();
   private Relation<IKinosaal, IReihe> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private ReihenDesSaalsSupervisor(){
      this.elements = new Relation<>("ReihenDesSaals");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static ReihenDesSaalsSupervisor getInstance(){return theInstance;}
   public Relation<IKinosaal, IReihe> getRelationData() {
      return this.elements;
   }
   public List<IReihe> getReihen(IKinosaal owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IKinosaal owner, IReihe target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IKinosaal owner, IReihe target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IKinosaal owner, IReihe target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
