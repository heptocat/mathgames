

public abstract class Konto
{
    protected int kontonummer;
    public String kontoinhaber;
    protected double kontostand;
    protected double zinssatz;
    protected boolean gelungen=true;
   
    public Konto(String ki, int nr, double ks, double zs)
    {
       kontoinhaber=ki;
       kontonummer=nr;
       kontostand=ks;
       zinssatz=zs;
    }
   
    public int gibKontonummer()
    {
       return kontonummer;
    }
    
    public String gibKontoInhaber()
    {
       return kontoinhaber;
    }
   
    public void setzeKontoinhaber(String ki)
    {
       kontoinhaber=ki;
    }
   
    public double gibKontoStand()
    {
       return kontostand;
    }
   
    public double gibZinsSatz()
    {
       return zinssatz;
    }
   
    public void SetzeZinsSatz(double zs)
    {
       zinssatz=zs;
    }
    
    public void einzahlen(double betrag)
    {
        kontostand=kontostand+betrag;
    }
    
    
    abstract public void auszahlen(double betrag);
    
    abstract public void verrechneZins();
        
}
