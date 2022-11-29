
import java.util.ArrayList;

class Warenkorb
{
    /// <summary>
    /// Eine Liste aller Artikel im Warenkorb.
    /// </summary>
    private ArrayList<WarenkorbItem> itemListe;

    /// <summary>
    /// Gibt den Gesamtpreis aller Artikel im Warenkorb zurück.
    /// </summary>
    public double getGesamtpreis() // Als Property (Eigenschaft)
    {

        double summe = 0;
        for (WarenkorbItem item : itemListe)
        {
            summe += item.getItempreis();
        }

        return summe;

    }

    /// <summary>
    /// Fügt einen über die Artikel-ID identifizierten Artikel mit einer gewünschten Anzahl dem Warenkorb hinzu. Befindet sich der Artikel bereits im Warenkorb, wird die Anzahl erhöht.
    /// <br/>Gibt true zurück, wenn erfolgreich, sonst false.
    /// </summary>
    /// <param name="artikelId">Die ID des Artikels.</param>
    /// <param name="anzahl">Die gewünschte Anzahl.</param>
    /// <returns>True wenn erfolgreich, sonst False.</returns>
    public boolean artikelHinzufügen(int artikelId, int anzahl)
    {
        // Sucht in der ArtikelListe der Klasse Artikel nach dem Objekt mit der passenden artikelID und gibt den Artikel zurück, wenn er gefunden wurde, sonst null.
        Artikel artikel = Artikel.getArtikel(artikelId);
        // Und wenn der Artikel gefunden wurde...
        return artikelHinzufügen(artikel, anzahl); // Aufruf der zweiten 'ArtikelHinzufügen' Methode
    }

    // Methodenüberladung
    /// <summary>
    /// Fügt einen Artikel mit einer gewünschten Anzahl dem Warenkorb hinzu. Befindet sich der Artikel bereits im Warenkorb, wird die Anzahl erhöht.
    /// <br/>Gibt true zurück, wenn erfolgreich, sonst false.
    /// </summary>
    /// <param name="artikel">Der Artikel.</param>
    /// <param name="anzahl">Die gewünschte Anzahl.</param>
    /// <returns>True wenn erfolgreich, sonst False.</returns>
    public boolean artikelHinzufügen(Artikel artikel, int anzahl)
    {
        if (artikel != null)
        {
            // dann prüfen wir, ob der gesuchte Artikel bereits im Warenkorb ist, indem wir uns jedes Item im Warenkorb anschauen...
            for (WarenkorbItem item : itemListe)
            {
                // und wenn ein Item im Warenkorb dem gefundenen Artikel entspricht...
                if (item.getItem() == artikel)
                {
                    // dann erhöhen wir einfach die Anzahl
                    item.setAnzahl(item.getAnzahl() + anzahl);
                    return true;
                }
            }
            // Sonst fügen wir den Artikel neu dem Warenkorb hinzu
            itemListe.add(new WarenkorbItem(artikel, anzahl));
            return true;
        }
        // Wenn wir keinen Artikel mit der artikelId gefunden haben, geben wir false zurück
        return false;
    }

    /// <summary>
    /// Entfernt einen Artikel aus dem Warenkorb.
    /// </summary>
    /// <param name="artikelId"></param>
    /// <param name="anzahl"></param>
    /// <returns></returns>
    public boolean artikelEntfernen(int artikelId, int anzahl)
    {
        // Sucht in der ArtikelListe der Klasse Artikel nach dem Objekt mit der passenden artikelID und gibt den Artikel zurück, wenn er gefunden wurde, sonst null.
        Artikel artikel = Artikel.getArtikel(artikelId);
        // Und wenn der Artikel gefunden wurde...
        return artikelEntfernen(artikel, anzahl);
    }

    /// <summary>
    /// Entfernt einen Artikel aus dem Warenkorb.
    /// </summary>
    /// <param name="artikelId"></param>
    /// <param name="anzahl"></param>
    /// <returns></returns>
    public boolean artikelEntfernen(Artikel artikel, int anzahl)
    {
        if (artikel != null)
        {
            for (WarenkorbItem item : itemListe)
            {
                // und wenn ein Item im Warenkorb dem Artikel entspricht...
                if (item.getItem() == artikel)
                {
                    // wenn die verbleibende Anzahl kleiner gleich 0 ist
                    if (item.getAnzahl() - anzahl <= 0)
                    {
                        // dann entfernen wir den Artikel komplett aus dem Warenkorb
                        itemListe.remove(item);
                    }
                    // Sonst verringern wir die Anzahl im Warenkorb um die gewünschte Anzahl
                    else
                    {
                        item.setAnzahl(item.getAnzahl() - anzahl);
                    }

                    return true;
                }
            }

            // Wenn sich der Artikel nicht im Warenkorb befindet...
            return false;
        }

        // Wenn der Artikel nicht gefunden wurde...
        return false;
    }


    /// <summary>
    /// Gibt einen String mit Informationen zu allen Artikeln im Warenkorb zurück, inklusive der Summe.
    /// </summary>
    /// <returns></returns>
    public String getWarenkorbString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Aktueller Warenkorb: \n");

        // Ruft für jedes Item im Warenkorb die GetWarenkorbItemString-Methode auf...
        for (WarenkorbItem item : itemListe)
        {
            // und fügt den Rückgabewert dem String hinzu
            sb.append(item.getWarenkorbItemString()).append("\n");
        }
        sb.append(String.format("Summe: %.2f", getGesamtpreis()));
        return sb.toString();
    }

    /// <summary>
    /// Erzeugt eine Warenkorb-Instanz und instanziiert die ItemListe.
    /// </summary>
    public Warenkorb()
    {
        itemListe = new ArrayList<WarenkorbItem>();
    }
}

