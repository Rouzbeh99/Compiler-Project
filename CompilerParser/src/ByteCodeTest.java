public class ByteCodeTest {

    public static void main(String[] args) {
        int firs = 1;
        double second = 0.5;

        int[] array = new int[firs];

        if (second > 0.5) {
            firs = 2;
        } else if (second > 0.2) {
            firs = 3;
        } else if (second > 1) {
            firs += 2;
        } else
            firs++;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        switch (firs) {
            case 1:
                second = 0.3;
                break;
            case 10:
                second++;
                break;
            case 20:
                second = 30;
                break;
            case 2:
                second = 10.3;
                break;
            case 5:
                second *= 10;
                break;
        }

        while (true) {
            boolean test = firs == 2 && second < 10.5;
            if (test)
                System.out.println("hello");
            else
                System.out.println("goodbye");
            if (firs == 3)
                break;
        }
    }

    public static int m1() {
        return 0;
    }

    public static int m2(int a) {
        return a + 2;
    }

    public static int fib(int n) {
        return n <= 1 ? 1 : fib(n - 1) + fib(n - 2);
    }
}
