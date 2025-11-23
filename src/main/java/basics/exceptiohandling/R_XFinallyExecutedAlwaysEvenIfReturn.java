package basics.exceptiohandling;

//finally always executes even when there is return before it
public class R_XFinallyExecutedAlwaysEvenIfReturn {
    public static void main(String[] args) {
        int a=10,b=0;
        try{
            int x=a/b;
        }
        catch (Exception e){
            System.out.println("Inside catch.Return is the next line");
            return;
        }
        finally {
            System.out.println("inside finally");
        }
    }
    //Inside catch.Return is the next line
    //inside finally
}
