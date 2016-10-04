

public class Bank
{
    private int kontenzahl;
    public Konto konten[];
    private double sparzins;
    private double dispozins;
   
    public Bank(int kz, double sz, double dz)
    {
        kontenzahl=kz;
        konten = new Konto [kz];
        sparzins=sz;
        dispozins=dz;
        
        erstelleSparKonto(0,"Karl",1000);
        erstelleSparKonto(1,"Sabine",1000);
    }
    
    public void einzahlen(int konto, double betrag)
    {
        konten[konto].kontostand=konten[konto].kontostand+betrag;
    }
    
    public String gibInhaber(int konto)
    {
        return konten[konto].kontoinhaber;
    }
    
    public double gibKontostand(int konto)
    {
        return konten[konto].kontostand;
    }
    
    public void auszahlen(int konto, double betrag)
    {
        konten[konto].auszahlen(betrag);
    }
    
    public void erstelleGiroKonto(int nr, String ki, double ks, double db)
    {
        konten[nr]= new Girokonto(ki, nr, ks, dispozins, db);
    }
    
    public void erstelleSparKonto(int nr, String ki, double ks)
    {
        konten[nr]= new Sparkonto(ki, nr, ks, dispozins);
    }
    
    public void ueberweisen(int quelle, int ziel, double betrag)
    {
        auszahlen(quelle, betrag);
        if (konten[quelle].gelungen=true)
        {
            einzahlen(ziel, betrag);
        }
        else
        {
            System.out.println("FEHLER: Ueberweisung gescheitert");
        }
    }
}
