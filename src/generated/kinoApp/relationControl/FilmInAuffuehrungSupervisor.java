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
public class FilmInAuffuehrungSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static FilmInAuffuehrungSupervisor theInstance = new FilmInAuffuehrungSupervisor();
   private Relation<IAuffuehrung, IFilm> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private FilmInAuffuehrungSupervisor(){
      this.elements = new Relation<>("FilmInAuffuehrung");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static FilmInAuffuehrungSupervisor getInstance(){return theInstance;}
   public Relation<IAuffuehrung, IFilm> getRelationData() {
      return this.elements;
   }
   public IFilm getFilm(IAuffuehrung owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IAuffuehrung owner, IFilm target) throws PersistenceException{
      IFilm targetOld = this.getFilm(owner); IFilm targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IAuffuehrung owner, IFilm target) {
      IFilm targetOld = null; IFilm targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IAuffuehrung owner, IFilm targetOld, IFilm targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
