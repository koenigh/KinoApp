package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseTypes.Rational;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.kinoApp.Auffuehrung;
import generated.kinoApp.Buchung;
import generated.kinoApp.Datum;
import generated.kinoApp.Film;
import generated.kinoApp.Kategorie1;
import generated.kinoApp.Kategorie2;
import generated.kinoApp.Kategorie3;
import generated.kinoApp.KinoApp;
import generated.kinoApp.Kinosaal;
import generated.kinoApp.Kunde;
import generated.kinoApp.Reihe;
import generated.kinoApp.Reservierung;
import generated.kinoApp.Sitzplatz;
import generated.kinoApp.VerfuegbarkeitAusnahme;

class KinoAppTest {
	private Kinosaal saal1;
	private Film lordOfTheRings;
	private Auffuehrung lordOfTheRingsInSaal1;
	private Kunde kunde1; 

	@BeforeEach
	void setUp() throws Exception {
		this.kategorienErzeugen();
		saal1 = Kinosaal.createFresh("Saal 1");
		this.saalKonfigurieren(saal1);
		lordOfTheRings = Film.createFresh("Lord of the Rings", 120);
		lordOfTheRingsInSaal1 = Auffuehrung.createFresh(lordOfTheRings, saal1, 1);
		kunde1 = Kunde.createFresh("Harald", "König");
	}
// Kinostruktur 
	@Test
	void test1() {
		assertEquals(new Rational("11/2"), Kategorie1.getInstance().getPreis().get());
		assertEquals(new Rational(8), Kategorie2.getInstance().getPreis().get());
		assertEquals(new Rational("21/2"), Kategorie3.getInstance().getPreis().get());
		
		assertEquals(6, saal1.getReihen().size());
		assertEquals(2, saal1.getReihen().stream().filter((r)->r.getKategorie()==Kategorie3.getInstance()).count());
		assertEquals(2, saal1.getReihen().stream().filter((r)->r.getKategorie()==Kategorie2.getInstance()).count());
		assertEquals(2, saal1.getReihen().stream().filter((r)->r.getKategorie()==Kategorie1.getInstance()).count());
		assertEquals(3, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("A")).findFirst().get().getSitzplaetze().size());
		assertEquals(4, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("B")).findFirst().get().getSitzplaetze().size());
		assertEquals(5, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("C")).findFirst().get().getSitzplaetze().size());
		assertEquals(6, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("D")).findFirst().get().getSitzplaetze().size());
		assertEquals(7, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("E")).findFirst().get().getSitzplaetze().size());
		assertEquals(8, saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("F")).findFirst().get().getSitzplaetze().size());
		assertEquals(new Rational("21/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("A")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational("21/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("A")).findFirst().get().getSitzplaetze().get(0).gibPreis());

		assertEquals(new Rational("21/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("A")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational("21/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("B")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational(8), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("C")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational(8), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("D")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational("11/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("E")).findFirst().get().getSitzplaetze().get(0).gibPreis());
		assertEquals(new Rational("11/2"), saal1.getReihen().stream().filter((r)->r.getBuchstabe().equals("F")).findFirst().get().getSitzplaetze().get(0).gibPreis());

		assertSame(saal1, lordOfTheRingsInSaal1.getKinosaal());
	}
// Reservieren
	@Test
	void test2() {
		try {
			Reservierung res1 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 4, Kategorie3.getInstance()); // Muss in Reihe B sein
			assertEquals(4, res1.getPlaetze().size());
		}catch(VerfuegbarkeitAusnahme va) {
			fail("Ausnahme trotz genügend verfügbarer Plätze");
		}
		Integer count = 0;
		for (Reservierung res : lordOfTheRingsInSaal1.getReservierungen()) count += res.getPlaetze().size();
		assertEquals(4, count); 
				
		lordOfTheRingsInSaal1.getReservierungen().stream().findFirst().get().getPlaetze().forEach((p)->assertTrue(p.getIdentifikation().startsWith("B")));
		
		try {
			Reservierung res2 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 2, Kategorie3.getInstance()); // Wird in Reihe A sein
			assertEquals(2, res2.getPlaetze().size());
			res2.getPlaetze().forEach((p)->assertTrue(p.getIdentifikation().startsWith("A")));
		}catch(VerfuegbarkeitAusnahme va) {
			fail("Ausnahme trotz genügend verfügbarer Plätze");
		}
		count = 0; 
		for (Reservierung res : lordOfTheRingsInSaal1.getReservierungen()) count += res.getPlaetze().size();
		assertEquals(6, count);
		
		try {
			Reservierung res3 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 2, Kategorie3.getInstance()); // Nicht mehr möglich
			fail("Verfügbarkeitsausnahme nicht geworfen");
		}catch(VerfuegbarkeitAusnahme va) {
			// ok
		}
	}
// Buchen 	
	@Test
	void test3() throws PersistenceException, VerfuegbarkeitAusnahme {
		KinoApp.getInstance().getBuchungCache().clear();
		Reservierung res1 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 2, Kategorie2.getInstance()); 
		Buchung buchung = Buchung.createFresh(Datum.createFresh(2022, 11, 21), res1);
		assertEquals("21.11.2022", buchung.getEingangsDatum().toString());
		assertEquals(new Rational(16), buchung.berechnePreis());
	}
// Summen 	
	@Test
	void test4() throws PersistenceException, VerfuegbarkeitAusnahme {
		KinoApp.getInstance().getBuchungCache().clear();
		Reservierung res1 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 3, Kategorie2.getInstance()); 
		Reservierung res2 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 2, Kategorie3.getInstance()); 
		Buchung buchung1 = Buchung.createFresh(Datum.createFresh(2022, 11, 21), res1);
		Buchung buchung2 = Buchung.createFresh(Datum.createFresh(2022, 10, 21), res2);
		assertEquals(new Rational(45), KinoApp.getInstance().berechneEinnahmenFuer(lordOfTheRings));
	}
	@Test
	void test5() throws PersistenceException, VerfuegbarkeitAusnahme {
		KinoApp.getInstance().getBuchungCache().clear();
		Reservierung res1 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 4, Kategorie2.getInstance()); 
		Reservierung res2 = KinoApp.getInstance().reservierungAnlegen(lordOfTheRingsInSaal1, kunde1, 2, Kategorie3.getInstance()); 
		Buchung buchung1 = Buchung.createFresh(Datum.createFresh(2022, 11, 21), res1);
		Buchung buchung2 = Buchung.createFresh(Datum.createFresh(2022, 10, 21), res2);
		assertEquals(new Rational(53), KinoApp.getInstance().berechneGesamteinnahmen());
	}
	
	private void kategorienErzeugen() {
		Kategorie1.getInstance().setBezeichnung("Hinten");
		Kategorie1.getInstance().setPreis(new Rational("11/2"));
		Kategorie2.getInstance().setBezeichnung("Mitte");
		Kategorie2.getInstance().setPreis(new Rational(8));
		Kategorie3.getInstance().setBezeichnung("Vorne");
		Kategorie3.getInstance().setPreis(new Rational("21/2"));
	}
	private void saalKonfigurieren(Kinosaal saal) throws PersistenceException, ConstraintViolation {
		Reihe r1 = Reihe.createFresh(Kategorie3.getInstance(), "A");
		Reihe r2 = Reihe.createFresh(Kategorie3.getInstance(), "B");
		Reihe r3 = Reihe.createFresh(Kategorie2.getInstance(), "C");
		Reihe r4 = Reihe.createFresh(Kategorie2.getInstance(), "D");
		Reihe r5 = Reihe.createFresh(Kategorie1.getInstance(), "E");
		Reihe r6 = Reihe.createFresh(Kategorie1.getInstance(), "F");
		this.plaetzeHinzufügen(r1, 3);
		this.plaetzeHinzufügen(r2, 4);
		this.plaetzeHinzufügen(r3, 5);
		this.plaetzeHinzufügen(r4, 6);
		this.plaetzeHinzufügen(r5, 7);
		this.plaetzeHinzufügen(r6, 8);
		saal1.addToReihen(r1);
		saal1.addToReihen(r2);
		saal1.addToReihen(r3);
		saal1.addToReihen(r4);
		saal1.addToReihen(r5);
		saal1.addToReihen(r6);
	}
	private void plaetzeHinzufügen(Reihe reihe, int anzahl) throws ConstraintViolation{
		for (int i = 0; i < anzahl; i++) Sitzplatz.createFresh(reihe.getBuchstabe()+"_"+i, reihe); // Wegen Containment werden die Sitzplätze automatisch zur reihe hinzugefügt!
	}
}
