package Basic;


public class PassObject {
    int nilai;

    public static void ubah(PassObject data2) {

        data2= new PassObject();
        data2.nilai = 200;
         System.out.println(data2.nilai);
    }


 /*STACK (main)        STACK (method)

data  ───────┐       data2 ───┐
             │                │
             └──────────┬─────┘
                        ▼

                        HEAP
                    Object Data
                    nilai = 10 */  

    public static void main(String[] args) {

        PassObject data = new PassObject();
        data.nilai = 10;

        ubah(data);

        System.out.println(data.nilai);
    }
}
