public class Sparkonto extends Konto
{
    
    public Sparkonto(String ki, int nr, double ks, double zs)
    {
        super(ki,nr,ks,zs);
    }
    
    public void auszahlen(double betrag)
    {
        if(kontostand-betrag>=0)
        {
            kontostand=kontostand-betrag;
            gelungen=true;
        }else
        {
            System.out.println("FEHLER: Kontostand reicht nicht aus");
            gelungen=false;
        }
    }
    
    public void verrechneZins()
    {
        kontostand=kontostand*zinssatz+kontostand;
    }
    
}