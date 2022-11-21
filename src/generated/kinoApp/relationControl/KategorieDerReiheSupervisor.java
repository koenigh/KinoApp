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
public class KategorieDerReiheSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static KategorieDerReiheSupervisor theInstance = new KategorieDerReiheSupervisor();
   private Relation<IReihe, IKategorie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private KategorieDerReiheSupervisor(){
      this.elements = new Relation<>("KategorieDerReihe");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static KategorieDerReiheSupervisor getInstance(){return theInstance;}
   public Relation<IReihe, IKategorie> getRelationData() {
      return this.elements;
   }
   public IKategorie getKategorie(IReihe owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReihe owner, IKategorie target) throws PersistenceException{
      IKategorie targetOld = this.getKategorie(owner); IKategorie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IReihe owner, IKategorie target) {
      IKategorie targetOld = null; IKategorie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReihe owner, IKategorie targetOld, IKategorie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
