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
public class KundeInReservierungSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static KundeInReservierungSupervisor theInstance = new KundeInReservierungSupervisor();
   private Relation<IReservierung, IKunde> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private KundeInReservierungSupervisor(){
      this.elements = new Relation<>("KundeInReservierung");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static KundeInReservierungSupervisor getInstance(){return theInstance;}
   public Relation<IReservierung, IKunde> getRelationData() {
      return this.elements;
   }
   public IKunde getKunde(IReservierung owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservierung owner, IKunde target) throws PersistenceException{
      IKunde targetOld = this.getKunde(owner); IKunde targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IReservierung owner, IKunde target) {
      IKunde targetOld = null; IKunde targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservierung owner, IKunde targetOld, IKunde targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
