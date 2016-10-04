import java.awt.*;
import javax.swing.*;   
import java.awt.event.*;

public class Terminal extends JFrame implements ActionListener
{
    JTextField q  = new JTextField();
    JTextField z = new JTextField();
    JTextField b  = new JTextField();
    JTextField k1 = new JTextField();
    JTextField n = new JTextField();
    JTextField ks = new JTextField();
    
    JLabel zl = new JLabel("target account");
    JLabel ql = new JLabel("source account");
    JLabel bl = new JLabel("amount");
    JLabel k1l = new JLabel("accountNr");
    
    JLabel b31 = new JLabel("accountNr");
    JLabel b32 = new JLabel("owner");
    
    JTextField t31 = new JTextField();
    JTextField t32 = new JTextField();  
    
    JPanel p = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    
    
    
    JButton knopf1 = new JButton("transfer");
    JButton knopf2 = new JButton("pay in");
    JButton knopf3 = new JButton("pay out");
    JButton knopf4 = new JButton("refresh");
    JButton knopf5 = new JButton("create");
    Bank MeineBank=new Bank(10, 0.01, 0.02);
    
    
    Terminal() //Konstruktor
    {
        this.setTitle("Terminal"); //ruft den Konstruktor von JFrame auf

        this.setBounds(100, 100, 600, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        
         p.add(ql); p.add(q); p.add(zl); p.add(z); p.add(knopf1);
         p2.add(k1l);p2.add(k1);p2.add(n);p2.add(ks);p2.add(knopf2); p2.add(knopf3);
         p3.add(b31); p3.add(t31); p3.add(b32); p3.add(t32); p3.add(knopf5);

        this.add(bl); this.add(b); this.add(p);this.add(p2);this.add(knopf4); this.add(p3);
        
        knopf1.addActionListener(this); //Hier wird der Actionlistener hinzugefügt
        knopf2.addActionListener(this);
        knopf3.addActionListener(this);
        knopf4.addActionListener(this);
        knopf5.addActionListener(this);
                
        ql.setHorizontalAlignment(JLabel.CENTER);
        zl.setHorizontalAlignment(JLabel.CENTER);
        bl.setHorizontalAlignment(JLabel.CENTER);
        
        ql.setFont(new Font("Courier", Font.BOLD, 18));
        zl.setFont(new Font("Courier", Font.BOLD, 18));
        bl.setFont(new Font("Courier", Font.BOLD, 18));
        k1l.setFont(new Font("Courier", Font.BOLD, 18));
        b31.setFont(new Font("Courier", Font.BOLD, 18));
        b32.setFont(new Font("Courier", Font.BOLD, 18));
            
        q.setFont(new Font("Courier", Font.PLAIN, 18));
        z.setFont(new Font("Courier", Font.PLAIN, 18));
        b.setFont(new Font("Courier", Font.PLAIN, 18));
        k1.setFont(new Font("Courier", Font.PLAIN, 18));
        n.setFont(new Font("Courier", Font.PLAIN, 18));
        ks.setFont(new Font("Courier", Font.PLAIN, 18));
        t31.setFont(new Font("Courier", Font.PLAIN, 18));
        t32.setFont(new Font("Courier", Font.PLAIN, 18));

        q.setColumns(3); z.setColumns(3); b.setColumns(6);k1.setColumns(3);n.setColumns(8);ks.setColumns(6);
        t31.setColumns(3); t32.setColumns(8);
        ks.setEnabled(false); n.setEnabled(false);
        
        this.setVisible(true); this.toFront();
        
      
    }
    
    public void erstelleSparKonto(int nr, String ki, double ks)
    {MeineBank.erstelleSparKonto(nr, ki, ks);}
    
    public void erstelleGiroKonto(int nr, String ki, double ks, double db)
    {
        MeineBank.erstelleGiroKonto(nr, ki, ks, db);
    }
    public double gibks(int i)
    {
      return MeineBank.gibKontostand(i); 
    }
   public String gibi(int i)
    {
      return MeineBank.gibInhaber(i); 
    }
    public void actionPerformed(ActionEvent ev)
    {
        Integer x=0, y=1,k=0, nr=100;String i="", na=""; double f=0.0;
        double h=0;
        
        
       
        try
        {
            
            x= Integer.valueOf(q.getText());
            y= Integer.valueOf(z.getText());
            h= Double.valueOf(b.getText());
            
            k= Integer.valueOf(k1.getText());
            i=gibi(Integer.valueOf(k1.getText()));
            f=gibks(Integer.valueOf(k1.getText()));        
            na= String.valueOf(t32.getText());
            nr= Integer.valueOf(t31.getText());
            
             if      (ev.getSource() == knopf1){MeineBank.ueberweisen(x,y,h); }
             if (ev.getSource() == knopf2){MeineBank.einzahlen(k,h);}
             if (ev.getSource() == knopf3){MeineBank.auszahlen(k,h);}
             if (ev.getSource() == knopf4){}
             if (ev.getSource() == knopf5) {MeineBank.erstelleSparKonto(nr, na, 0);}
            }
            
        
        catch (Exception ex) 
            { 
           
            }
           
       n.setText(i);
       ks.setText(Double.toString(f));
    }
}
