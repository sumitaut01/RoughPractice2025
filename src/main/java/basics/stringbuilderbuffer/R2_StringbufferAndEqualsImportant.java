package basics.stringbuilderbuffer;

//public final class StringBuffer
//    extends AbstractStringBuilder
//    implements Appendable, Serializable, Comparable<StringBuffer>, CharSequence
//{
//thread safe
//mutable
//slower than s builder as  thred safe
public class R2_StringbufferAndEqualsImportant {

    public static void main(String[] args) {


        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("f").append("u");


        //Very important:

        String orig="A man, a plan, a canal: Panama".replaceAll("[^A-Za-z0-9]", "");// note space between A-Z a-z will not remove spaces
        StringBuffer rev=new StringBuffer();
        for(int i=orig.length()-1;i>=0;i--){
            rev=rev.append(orig.charAt(i));
        }
        System.out.println(orig);
        System.out.println(rev);
        System.out.println(rev.equals(orig));//it gives false always as equals not written for content comparison in buffer
        //1) You're comparing different types (and StringBuffer.equals is not content-based)
        //
        //rev is a StringBuffer, orig is a String. StringBuffer does not override equals() to compare contents, so rev.equals(orig) just uses Object.equals (reference equality) and will always be false when comparing different objects/types.
        //
        //So even if their textual content matched, rev.equals(orig) would still be false.


        //Right Reason:
        System.out.println(rev.toString().equalsIgnoreCase(orig));//true

    }
}
