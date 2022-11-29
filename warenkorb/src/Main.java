
/*
 * Sie sollen eine Anwendung für einen Shop schreiben. Im Shop gibt es viele Artikel, die mit Id, Bezeichnung, Einkaufspreis, Gewinnsatz und Verkaufspreis gespeichert werden. Der Verkaufspreis wird dabei immer aus Einkaufspreis + Gewinn errechnet.
 *
 * Artikel, die gekauft werden, werden mit Mengenangabe in einen Warenkorb gelegt. Es sollen Artikel in den Warenkorb gelegt und wieder entfernt werden können. Ebenfalls soll es möglich sein, die Anzahl eines Artikels ändern zu können. Über den Warenkorb wird der Gesamtpreis aller sich dort befindenden Artikel ermittelt.
 *
 * Artikel im Warenkorb werden dort als Warenkorb-Items eingetragen. Ein Warenkorb-Item besteht aus dem Artikel selbst und der Anzahl. Ebenfalls soll der Gesamtpreis für diesen Artikel abgefragt werden können.
 *
 * Es ist nicht erforderlich, ein Eingabe-Menü zu basteln. Es reicht, die einzelnen Fälle über Code in der Main zu testen.
 * Wichtig für diese Übung: Beachten Sie die Prinzipien der OOP. Insbesondere die Klassenbildung und Datenkapselung / Geheimnisprinzip.
 * Ebenso sollen Sie die strikte Trennung von Funktionalität / Datenhaltung und Darstellung beachten. Heißt: Dort, wo die Daten gespeichert sind und Funktionalitäten liegen, wird KEINE Konsolenausgabe getätigt. Konsolenausgaben nur in dafür vorgesehenen eigenen Klassen oder zum Beispiel in der Main.
 * Diese Aufgabe lässt sich mit dem lösen, was wir bisher kennengelernt haben.
 * Erstellen Sie auch ein UML Klassendiagramm und gerne auch Anwendungsfall-, Sequenz- oder Aktivitätsdiagramm.
 */

public class Main
{
    public static void main(String[] args)
    {


        // Drei Artikel erstellen
        new Artikel(1, "Artikel 1", 99.99, 20);
        new Artikel(2, "Artikel 2", 49.99, 25);
        new Artikel(3, "Artikel 3", 9.99, 15);

        for (Artikel artikel : Artikel.artikelListe)
        {
            System.out.println(artikel.getArtikelString());
        }

        System.out.println();

        // Neuen Warenkorb erstellen
        Warenkorb warenkorb = new Warenkorb();

        // Artikel zum Warenkorb hinzufügen
        hinzufügen(warenkorb, 1, 2); // Zum Hinzufügen und Entfernen habe ich hier noch zwei extra Methoden geschrieben, um in der Main doppelten Code zu vermeiden (also das If-Else mit den Ausgaben ausgelagert)

        // Warenkorb ausgeben
        System.out.println(warenkorb.getWarenkorbString());

        hinzufügen(warenkorb, 3, 20);

        System.out.println(warenkorb.getWarenkorbString());

        // Artikel entfernen (Anzahl verringern)
        entfernen(warenkorb, 3, 10);

        System.out.println(warenkorb.getWarenkorbString());

        // Artikel hinzufügen (Anzahl erhöhen)
        hinzufügen(warenkorb, 3, 5);

        System.out.println(warenkorb.getWarenkorbString());

        // Artikel komplett entfernen
        entfernen(warenkorb, 3, 20);

        System.out.println(warenkorb.getWarenkorbString());

        // Entfernten Artikel erneut hinzufügen
        hinzufügen(warenkorb, 3, 1);

        System.out.println(warenkorb.getWarenkorbString());

        // Artikel entfernen, der nicht im Warenkorb ist
        entfernen(warenkorb, 2, 10);

        System.out.println(warenkorb.getWarenkorbString());

        // Artikel hinzufügen, der nicht existiert
        hinzufügen(warenkorb, 4, 1);

        System.out.println(warenkorb.getWarenkorbString());

        // Alle Artikel entfernen
        entfernen(warenkorb, 1, 2);
        entfernen(warenkorb, 3, 1);

        System.out.println(warenkorb.getWarenkorbString());

    }

    /// <summary>
    /// Methode zum Hinzufügen von Artikeln. Konsolenausgabe entsprechend dem Ergebnis.
    /// </summary>
    /// <param name="warenkorb"></param>
    /// <param name="artikelId"></param>
    /// <param name="anzahl"></param>
    static void hinzufügen(Warenkorb warenkorb, int artikelId, int anzahl)
    {
        if (warenkorb.artikelHinzufügen(artikelId, anzahl))
            System.out.println("Hinzufügen erfolgreich!");
        else
            System.out.println("Hinzufügen fehlgeschlagen!");
    }

    /// <summary>
    /// Methode zum Entfernen von Artikeln. Konsolenausgabe entsprechend dem Ergebnis.
    /// </summary>
    /// <param name="warenkorb"></param>
    /// <param name="artikelId"></param>
    /// <param name="anzahl"></param>
    static void entfernen(Warenkorb warenkorb, int artikelId, int anzahl)
    {
        if (warenkorb.artikelEntfernen(artikelId, anzahl))
            System.out.println("Entfernen erfolgreich!");
        else
            System.out.println("Entfernen fehlgeschlagen!");
    }
}

