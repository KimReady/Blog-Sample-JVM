
class JavaA {
    int a = 5;
}

class JavaB extends JavaA {
    int b = 10;
}

public class Main {
    public static void main(String[] args) {
        JavaA obj = new JavaB();
        if (obj instanceof JavaB) {
            JavaB obj2 = (JavaB) obj;
            System.out.println(obj2.b);
        }
    }
}