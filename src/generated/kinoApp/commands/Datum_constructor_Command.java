/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.kinoApp.commands;
import generated.kinoApp.*;
import commands.*;
public class Datum_constructor_Command extends ServiceCommand<Datum>{
   private static final long serialVersionUID = -344092928L;
   private Integer  jahr;
   private Integer  monat;
   private Integer  tag;
   public Datum_constructor_Command(Integer  jahr, Integer  monat, Integer  tag){
      super();
      this.jahr = jahr;
      this.monat = monat;
      this.tag = tag;
   }
   public void execute(){
      try{this.result = Datum.createFresh(jahr, monat, tag);
      }catch(Exception e){this.e = e;
      }finally{KinoApp.getInstance().notifyObservers(this);}
   }
}
