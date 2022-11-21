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
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class AuffuehrungInReservierungSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static AuffuehrungInReservierungSupervisor theInstance = new AuffuehrungInReservierungSupervisor();
   private Relation<IReservierung, IAuffuehrung> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private AuffuehrungInReservierungSupervisor(){
      this.elements = new Relation<>("AuffuehrungInReservierung");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static AuffuehrungInReservierungSupervisor getInstance(){return theInstance;}
   public Relation<IReservierung, IAuffuehrung> getRelationData() {
      return this.elements;
   }
   public IAuffuehrung getAuffuehrung(IReservierung owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservierung owner, IAuffuehrung target) throws PersistenceException{
      IAuffuehrung targetOld = this.getAuffuehrung(owner); IAuffuehrung targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IReservierung owner, IAuffuehrung target) {
      IAuffuehrung targetOld = null; IAuffuehrung targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservierung owner, IAuffuehrung targetOld, IAuffuehrung targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IReservierung> getReservierungen(IAuffuehrung target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
