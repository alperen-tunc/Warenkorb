
import java.util.ArrayList;

class Artikel
{
    /// <summary>
    /// In dieser Liste werden alle Artikel abgespeichert.
    /// </summary>
    public static final ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();

    private int id; // privates Feld

    /// <summary>
    /// Die ID des Artikels
    /// </summary>
    public int getId() // Dazugehöriger, öffentlicher Getter
    {
        return id;

    }

    private String bezeichnung;

    /// <summary>
    /// Die Bezeichnung des Artikels
    /// </summary>
    public String getBezeichnung()
    {
        return bezeichnung;
    }

    private double einkaufspreis;

    /// <summary>
    /// Der Einkaufspreis des Artikels, muss größer 0 sein.
    /// </summary>
    public double getEinkaufspreis()
    {
        return einkaufspreis;

    }

    public void setEinkaufspreis(double einkaufspreis)
    {
        if (einkaufspreis > 0) // If-Bedingung im Setter, prüft, ob der übergebene Wert größer 0 ist und weist nur dann einkaufspreis den Wert zu.
            this.einkaufspreis = einkaufspreis;
    }

    private int gewinnsatz;

    /// <summary>
    /// Der Gewinnsatz des Artikels
    /// </summary>
    public int getGewinnsatz()
    {
        return gewinnsatz;

    }

    public void setGewinnsatz(int gewinnsatz)
    {
        this.gewinnsatz = gewinnsatz;
    }

    /// <summary>
    /// Gibt den Verkaufspreis des Artikels zurück. Berechnet aus Einkaufspreis + Gewinnsatz.
    /// </summary>
    public double getVerkaufspreis()
    {
        return Math.round(einkaufspreis + (einkaufspreis / 100 * gewinnsatz));
    }

    /// <summary>
    /// Sucht in der ArtikelListe nach dem Artikel mit der übergebenen ID und gibt diesen zurück.
    /// </summary>
    /// <param name="artikelId">Die ID des gesuchten Artikels.</param>
    /// <returns>Den gesuchten Artikel oder null.</returns>
    public static Artikel getArtikel(int artikelId)
    {
        for (Artikel artikel : artikelListe)
        {
            if (artikel.id == artikelId)
                return artikel;
        }
        return null;
    }

    /// <summary>
    /// Gibt einen String mit Informationen über den Artikel zurück.
    /// </summary>
    /// <returns>Einen string aus Id, Bezeichnung und Verkaufspreis.</returns>
    public String getArtikelString()
    {
        return String.format("ID : %d - Bezeichnung: %s - Einzelpreis: %.2f", id, bezeichnung, getVerkaufspreis());
    }

    /// <summary>
    /// Instanziiert einen Artikel und fügt ihn der ArtikelListe hinzu.
    /// </summary>
    /// <param name="id">ID des Artikels</param>
    /// <param name="bezeichnung">Bezeichnung des Artikels</param>
    /// <param name="einkaufspreis">Einkaufspreis des Artikels - muss größer 0 sein</param>
    /// <param name="gewinnsatz">Gewinnsatz des Artikels</param>
    public Artikel(int id, String bezeichnung, double einkaufspreis, int gewinnsatz)
    {
        this.id = id; // Zuweisung über privates Feld
        this.bezeichnung = bezeichnung;
        setEinkaufspreis(einkaufspreis); // Zuweisung über den Setter, da sich dort eine Überprüfung des Wertes auf größer 0 befindet
        setGewinnsatz(gewinnsatz);

        artikelListe.add(this); // Fügt die aktuelle Instanz / das aktuelle Objekt der Liste hinzu.
    }
}

