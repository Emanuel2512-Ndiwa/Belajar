package Basic;
public class PassPrimitif {
    public static void ubah(int x) {
        x = 100;
        System.out.println("Di method: " + x);
    }

    public static void main(String[] args) {
        int x = 10;

        ubah(x);
        System.out.println("Setelah method: " + x);


    }
}
/*    STACK (main)        STACK (method)

        angka = 10          x = 100 */
