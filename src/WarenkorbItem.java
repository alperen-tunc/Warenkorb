
class WarenkorbItem
{
    private Artikel item;

    /// <summary>
    /// Der sich im Warenkorb befindende Artikel.
    /// </summary>
    public Artikel getItem()
    {
        return item;
    }

    private int anzahl;

    /// <summary>
    /// Die Anzahl, wie oft der Artikel im Warenkorb liegt. Anzahl muss größer 0 sein.
    /// </summary>
    public int getAnzahl()
    {
        return anzahl;

    }

    public void setAnzahl(int anzahl)
    {


        if (anzahl > 0)
            this.anzahl = anzahl;

    }

    /// <summary>
    /// Gibt den Gesamtpreis des Artikels zurück. Berechnet durch Verkaufspreis * Anzahl.
    /// </summary>
    public double getItempreis()
    {
        return item.getVerkaufspreis() * anzahl;
    }


    /// <summary>
    /// Gibt einen String mit Informationen über den Artikel im Warenkorb zurück.
    /// </summary>
    /// <returns>Einen String aus Id, Bezeichnung, Verkaufspreis, Anzahl und Gesamtpreis.</returns>
    public String getWarenkorbItemString()
    {
        return String.format(item.getArtikelString() + " - Anzahl: %d - Gesamtpreis: %.2f", anzahl, getItempreis());
    }

    /// <summary>
    /// Instanziiert ein neues Warenkorb-Item.
    /// </summary>
    /// <param name="item">Der Artikel im Warenkorb.</param>
    /// <param name="anzahl">Die Anzahl, wie oft sich der Artikel im Warenkorb befindet.</param>
    public WarenkorbItem(Artikel item, int anzahl)
    {
        this.item = item;
        setAnzahl(anzahl);
    }
}

