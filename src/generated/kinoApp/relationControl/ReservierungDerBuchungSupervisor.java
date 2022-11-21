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
public class ReservierungDerBuchungSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static ReservierungDerBuchungSupervisor theInstance = new ReservierungDerBuchungSupervisor();
   private Relation<IBuchung, IReservierung> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private ReservierungDerBuchungSupervisor(){
      this.elements = new Relation<>("ReservierungDerBuchung");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static ReservierungDerBuchungSupervisor getInstance(){return theInstance;}
   public Relation<IBuchung, IReservierung> getRelationData() {
      return this.elements;
   }
   public IReservierung getReservierung(IBuchung owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IBuchung owner, IReservierung target) throws PersistenceException{
      IReservierung targetOld = this.getReservierung(owner); IReservierung targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IBuchung owner, IReservierung target) {
      IReservierung targetOld = null; IReservierung targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IBuchung owner, IReservierung targetOld, IReservierung targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
