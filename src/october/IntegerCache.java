package october;

public class IntegerCache {


    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        Integer c = 130;
        Integer d = 130;
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));

        System.out.println(a==b);
        System.out.println(c==d);




    }
}
