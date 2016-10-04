

public class Girokonto extends Konto
{
    protected double dispobetrag;
    
    public Girokonto(String ki, int nr, double ks, double zs, double db)
    {
        super(ki,nr,ks,zs);
        dispobetrag=db;
    }
    
    public double gibDispoBetrag()
    {
        return dispobetrag;
    }
    
    public void setzeDispoBetrag(double db)
    {
        dispobetrag=db;
    }
    
    public void auszahlen(double betrag)
    {
        if(kontostand-betrag>=-dispobetrag)
        {
            kontostand=kontostand-betrag;
            gelungen=true;
        }else
        {
            System.out.println("FEHLER: Dispobetrag reicht nicht aus");
            gelungen=false;
        }
    }
    
    public void verrechneZins()
    {
        kontostand=kontostand*zinssatz+kontostand;
    }
    
}
