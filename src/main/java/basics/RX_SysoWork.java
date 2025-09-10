package basics;
public class RX_SysoWork {
    public static void main(String[] args) {
        SystemNew.Out.println();
    }
}

final class SystemNew {
static PrintStreamNew Out;
}

class PrintStreamNew {
     void println() {
        System.out.println("PrintStream.println");
    }
}


