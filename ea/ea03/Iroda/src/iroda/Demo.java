package iroda;

/**
 *
 * @author Adam Ancsin
 */
public class Demo {
    public static void main(String[] args) {
        Iroda iroda = new Iroda("valahol", "Korporésön");
        
        Terem terem1 = new Terem(1, 20.0);
        Terem terem2 = new Terem(2, 20.7); 
        Terem terem3 = new Terem(3, 21.2);
       
        iroda.újTerem(terem1);
        iroda.újTerem(terem2);
        iroda.újTerem(terem3);
        
        terem1.újHőérzékelő(new Hőérzékelő(1, 1.0));
        terem1.újHőérzékelő(new Hőérzékelő(2, 0.9));
        terem2.újHőérzékelő(new Hőérzékelő(3, 5.0));
        terem2.újHőérzékelő(new Hőérzékelő(4, 3.9));
        terem2.újHőérzékelő(new Hőérzékelő(5, 2.3));
        terem3.újHőérzékelő(new Hőérzékelő(6, 0.001));
        
        terem1.újHőmérséklet(19.1);
        terem2.újHőmérséklet(19.9);
        terem3.újHőmérséklet(22.4);
        terem1.újHőmérséklet(19.6);
        terem2.újHőmérséklet(20.3);
        terem3.újHőmérséklet(24.1);
    }
}
