public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, " + args[0]);
        int length = args.length;
        for (int i = 0; i < length; i++) {
            System.out.print(args[i] + " ");
        }
    }
}