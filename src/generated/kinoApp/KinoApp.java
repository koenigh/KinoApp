/**--- Generated at Mon Nov 21 11:48:47 CET 2022 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoApp;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.kinoApp.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.kinoApp.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceDMLExecuter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import baseTypes.Rational;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class KinoApp extends Observable{
   private PersistenceDMLExecuter dmlExecuter;
   private Map<Integer,FilmProxy> filmCache;
   private Map<Integer,KinosaalProxy> kinosaalCache;
   private Map<Integer,AuffuehrungProxy> auffuehrungCache;
   private Map<Integer,ReservierungProxy> reservierungCache;
   private Map<Integer,BuchungProxy> buchungCache;
   private Map<Integer,DatumProxy> datumCache;
   private Map<Integer,KundeProxy> kundeCache;
   private Map<Integer,SitzplatzProxy> sitzplatzCache;
   private Map<Integer,ReiheProxy> reiheCache;
   private static KinoApp theInstance = new KinoApp();
   private KinoApp(){
      this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      try{
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("KinoApp");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static KinoApp getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.filmCache = new InitialProxyLoader<FilmProxy>("generated", "KinoApp", "kinoApp", "Film", "Film").perform();
      this.kinosaalCache = new InitialProxyLoader<KinosaalProxy>("generated", "KinoApp", "kinoApp", "Kinosaal", "Kinosaal").perform();
      this.auffuehrungCache = new InitialProxyLoader<AuffuehrungProxy>("generated", "KinoApp", "kinoApp", "Auffuehrung", "Auffuehrung").perform();
      this.reservierungCache = new InitialProxyLoader<ReservierungProxy>("generated", "KinoApp", "kinoApp", "Reservierung", "Reservierung").perform();
      this.buchungCache = new InitialProxyLoader<BuchungProxy>("generated", "KinoApp", "kinoApp", "Buchung", "Buchung").perform();
      this.datumCache = new InitialProxyLoader<DatumProxy>("generated", "KinoApp", "kinoApp", "Datum", "Datum").perform();
      this.kundeCache = new InitialProxyLoader<KundeProxy>("generated", "KinoApp", "kinoApp", "Kunde", "Kunde").perform();
      this.sitzplatzCache = new InitialProxyLoader<SitzplatzProxy>("generated", "KinoApp", "kinoApp", "Sitzplatz", "Sitzplatz").perform();
      this.reiheCache = new InitialProxyLoader<ReiheProxy>("generated", "KinoApp", "kinoApp", "Reihe", "Reihe").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("ReihenDesSaals").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Kinosaal", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reihe", "KinoApp");
         try{this.addReihenDesSaalsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("FilmInAuffuehrung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Auffuehrung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Film", "KinoApp");
         try{this.addFilmInAuffuehrungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("SaalInAuffuehrung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Auffuehrung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Kinosaal", "KinoApp");
         try{this.addSaalInAuffuehrungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("AuffuehrungInReservierung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservierung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Auffuehrung", "KinoApp");
         try{this.addAuffuehrungInReservierungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("DatumInBuchung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Buchung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Datum", "KinoApp");
         try{this.addDatumInBuchungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ReservierungDerBuchung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Buchung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservierung", "KinoApp");
         try{this.addReservierungDerBuchungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("KundeInReservierung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservierung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Kunde", "KinoApp");
         try{this.addKundeInReservierungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("PlaetzeInReservierung").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservierung", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Sitzplatz", "KinoApp");
         try{this.addPlaetzeInReservierungElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("PlaetzeDerReihe").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reihe", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Sitzplatz", "KinoApp");
         try{this.addPlaetzeDerReiheElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("KategorieDerReihe").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reihe", "KinoApp");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Kategorie", "KinoApp");
         try{this.addKategorieDerReiheElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addReihenDesSaalsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IKinosaal proxy1 = null; IReihe proxy2 = null; 
      if(className1.equals("Kinosaal"))  proxy1 = this.kinosaalCache.get(id1);
      if(className2.equals("Reihe"))  proxy2 = this.reiheCache.get(id2);
      ReihenDesSaalsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addFilmInAuffuehrungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IAuffuehrung proxy1 = null; IFilm proxy2 = null; 
      if(className2.equals("Film"))  proxy2 = this.filmCache.get(id2);
      if(className1.equals("Auffuehrung"))  proxy1 = this.auffuehrungCache.get(id1);
      FilmInAuffuehrungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addSaalInAuffuehrungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IAuffuehrung proxy1 = null; IKinosaal proxy2 = null; 
      if(className2.equals("Kinosaal"))  proxy2 = this.kinosaalCache.get(id2);
      if(className1.equals("Auffuehrung"))  proxy1 = this.auffuehrungCache.get(id1);
      SaalInAuffuehrungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addAuffuehrungInReservierungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservierung proxy1 = null; IAuffuehrung proxy2 = null; 
      if(className2.equals("Auffuehrung"))  proxy2 = this.auffuehrungCache.get(id2);
      if(className1.equals("Reservierung"))  proxy1 = this.reservierungCache.get(id1);
      AuffuehrungInReservierungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addDatumInBuchungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBuchung proxy1 = null; IDatum proxy2 = null; 
      if(className1.equals("Buchung"))  proxy1 = this.buchungCache.get(id1);
      if(className2.equals("Datum"))  proxy2 = this.datumCache.get(id2);
      DatumInBuchungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservierungDerBuchungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBuchung proxy1 = null; IReservierung proxy2 = null; 
      if(className2.equals("Reservierung"))  proxy2 = this.reservierungCache.get(id2);
      if(className1.equals("Buchung"))  proxy1 = this.buchungCache.get(id1);
      ReservierungDerBuchungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addKundeInReservierungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservierung proxy1 = null; IKunde proxy2 = null; 
      if(className1.equals("Reservierung"))  proxy1 = this.reservierungCache.get(id1);
      if(className2.equals("Kunde"))  proxy2 = this.kundeCache.get(id2);
      KundeInReservierungSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addPlaetzeInReservierungElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservierung proxy1 = null; ISitzplatz proxy2 = null; 
      if(className1.equals("Reservierung"))  proxy1 = this.reservierungCache.get(id1);
      if(className2.equals("Sitzplatz"))  proxy2 = this.sitzplatzCache.get(id2);
      PlaetzeInReservierungSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addPlaetzeDerReiheElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReihe proxy1 = null; ISitzplatz proxy2 = null; 
      if(className2.equals("Sitzplatz"))  proxy2 = this.sitzplatzCache.get(id2);
      if(className1.equals("Reihe"))  proxy1 = this.reiheCache.get(id1);
      PlaetzeDerReiheSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addKategorieDerReiheElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReihe proxy1 = null; IKategorie proxy2 = null; 
      if(className1.equals("Reihe"))  proxy1 = this.reiheCache.get(id1);
      if(className2.equals("Kategorie1"))  proxy2 = Kategorie1.getInstance();
      if(className2.equals("Kategorie2"))  proxy2 = Kategorie2.getInstance();
      if(className2.equals("Kategorie3"))  proxy2 = Kategorie3.getInstance();
      KategorieDerReiheSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Film getFilm(Integer id){
      return this.filmCache.get(id).getTheObject();
   }
   public void addFilmProxy(FilmProxy p) throws PersistenceException{
      this.filmCache.put(p.getId(), p);
   }
   public Map<Integer,FilmProxy> getFilmCache(){
      return this.filmCache;
   }
   public Kinosaal getKinosaal(Integer id){
      return this.kinosaalCache.get(id).getTheObject();
   }
   public void addKinosaalProxy(KinosaalProxy p) throws PersistenceException{
      this.kinosaalCache.put(p.getId(), p);
   }
   public Map<Integer,KinosaalProxy> getKinosaalCache(){
      return this.kinosaalCache;
   }
   public Auffuehrung getAuffuehrung(Integer id){
      return this.auffuehrungCache.get(id).getTheObject();
   }
   public void addAuffuehrungProxy(AuffuehrungProxy p) throws PersistenceException{
      this.auffuehrungCache.put(p.getId(), p);
   }
   public Map<Integer,AuffuehrungProxy> getAuffuehrungCache(){
      return this.auffuehrungCache;
   }
   public Reservierung getReservierung(Integer id){
      return this.reservierungCache.get(id).getTheObject();
   }
   public void addReservierungProxy(ReservierungProxy p) throws PersistenceException{
      this.reservierungCache.put(p.getId(), p);
   }
   public Map<Integer,ReservierungProxy> getReservierungCache(){
      return this.reservierungCache;
   }
   public Buchung getBuchung(Integer id){
      return this.buchungCache.get(id).getTheObject();
   }
   public void addBuchungProxy(BuchungProxy p) throws PersistenceException{
      this.buchungCache.put(p.getId(), p);
   }
   public Map<Integer,BuchungProxy> getBuchungCache(){
      return this.buchungCache;
   }
   public Datum getDatum(Integer id){
      return this.datumCache.get(id).getTheObject();
   }
   public void addDatumProxy(DatumProxy p) throws PersistenceException{
      this.datumCache.put(p.getId(), p);
   }
   public Map<Integer,DatumProxy> getDatumCache(){
      return this.datumCache;
   }
   public Kunde getKunde(Integer id){
      return this.kundeCache.get(id).getTheObject();
   }
   public void addKundeProxy(KundeProxy p) throws PersistenceException{
      this.kundeCache.put(p.getId(), p);
   }
   public Map<Integer,KundeProxy> getKundeCache(){
      return this.kundeCache;
   }
   public Sitzplatz getSitzplatz(Integer id){
      return this.sitzplatzCache.get(id).getTheObject();
   }
   public void addSitzplatzProxy(SitzplatzProxy p) throws PersistenceException{
      this.sitzplatzCache.put(p.getId(), p);
   }
   public Map<Integer,SitzplatzProxy> getSitzplatzCache(){
      return this.sitzplatzCache;
   }
   public Reihe getReihe(Integer id){
      return this.reiheCache.get(id).getTheObject();
   }
   public void addReiheProxy(ReiheProxy p) throws PersistenceException{
      this.reiheCache.put(p.getId(), p);
   }
   public Map<Integer,ReiheProxy> getReiheCache(){
      return this.reiheCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Bucht die angegebene Reservierung
 */
   public void buchen(Reservierung reservierung){
	  Calendar now = Calendar.getInstance();
	  Datum datum = Datum.createFresh(now.get(Calendar.YEAR), Calendar.MONTH, Calendar.DAY_OF_MONTH);
	  Buchung.createFresh(datum, reservierung); 
   }
/**
 * Berechnet alle Einnahmen
 */
   public baseTypes.Rational berechneGesamteinnahmen(){
	  Rational result = new Rational(0); 
      for (FilmProxy film : KinoApp.getInstance().filmCache.values()) 
    	  result = Rational.add(result, this.berechneEinnahmenFuer(film.getTheObject())); 
      return result;
   }
/**
 * Berechnet alle Einnahmen fuer den angegebenen Film.
 */
   public baseTypes.Rational berechneEinnahmenFuer(Film film){
     return KinoApp.getInstance()
    			.getBuchungCache()
    			.values()
    			.stream()
    			.map((b)->b.getTheObject())
    			.filter((b)->b.getReservierung().getAuffuehrung().getFilm().equals(film))
    			.map((b)->b.berechnePreis())
    			.reduce(new Rational(0), Rational::add);
   }
/**
 * Erzeugt eine Reservierung in der angegebeben Auffuehrung fuer den angegebenen Kunden mit der angegebenen Anzahl Plaetzen und der gewuenschten Kategorie
 */
   public Reservierung reservierungAnlegen(Auffuehrung auffuehrung, Kunde kunde, Integer anzahlPlaetze, Kategorie kategorie)throws VerfuegbarkeitAusnahme{
	  Optional<Reihe> zielreihe = Optional.empty(); 
      for (Reihe moeglicheReihe : auffuehrung.gibReihenFuer(kategorie)) {
    	  int reserviert = 0;
    	  for (Reservierung reservierung : auffuehrung.getReservierungen()) {
			 reserviert += reservierung.getPlaetze().stream().filter((p)->p.getReihe()==moeglicheReihe).count();
    	  }
    	  if(moeglicheReihe.getSitzplaetze().size() - reserviert >= anzahlPlaetze) {
    		    zielreihe = Optional.of(moeglicheReihe);
    	  		return reservierungErzeugen(auffuehrung, kunde, anzahlPlaetze, zielreihe.get());
    	  }
      }
      throw new VerfuegbarkeitAusnahme();
   }
   private Reservierung reservierungErzeugen(Auffuehrung auffuehrung, Kunde kunde, Integer anzahlPlaetze, Reihe inReihe) {
	   Collection<Sitzplatz> gebuchtePlaetze = new ArrayList<>();
	   auffuehrung.getReservierungen().forEach((r)->gebuchtePlaetze.addAll(r.getPlaetze()));
	   Reservierung reservierung = Reservierung.createFresh(auffuehrung, kunde);
	   Integer gebucht = 0;
	   for (Sitzplatz sitzplatz : inReihe.getSitzplaetze()) {
		   if(gebucht.equals(anzahlPlaetze)) break;
		   if(!(gebuchtePlaetze.contains(sitzplatz))) {
			   reservierung.addToPlaetze(sitzplatz);
			   gebucht++;
		   }
	   }
	   return reservierung;
   }
//90 ===== GENERATED: End of Your Operations ======
}
