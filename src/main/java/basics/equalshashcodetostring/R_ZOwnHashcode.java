package basics.equalshashcodetostring;

//Start with a seed (commonly 17).
//
//For each field:
//
//If it’s an object (String, etc.), call its own hashCode().
//If it’s a primitive (int, etc.), use it directly.
//Multiply result by 31 and add the field’s contribution.
//End with a single integer.


public class R_ZOwnHashcode {

    public static void main(String[] args) {

        System.out.println(new Dummy("sumit", "raut",31 ).hashCode());
        System.out.println(new Dummy("sumit", "raut",31 ).hashCode());
        //-887701783
        //-887701783

        //Why can hashCode() be negative?
        //In Java, hashCode() returns an int
        //int is a 32-bit signed integer, range:
        //-2,147,483,648  to  +2,147,483,647
        //

        //When you multiply and add numbers in your formula (31 * result + fieldHash), the result may exceed this range.
        //Java integers overflow (wrap around), so you can get a negative number.
        //🔹 Is that a problem?
        //
        //👉 Not at all.
        //
        //The contract of hashCode() doesn’t say the value must be positive.
        //Negative values are totally valid.
        //Collections like HashMap and HashSet handle it internally by applying a bit-mixing algorithm before deciding the bucket index.
        //So whether your hashCode is 12345 or -98765, HashMap works fine.
    }
}


class Dummy {
    String firsName;
    String lasTName;
    int someValue;

    public Dummy(String firsName, String lasTName, int someValue) {
        this.firsName = firsName;
        this.lasTName = lasTName;
        this.someValue = someValue;
    }

    @Override
    public int hashCode() {
        int result = 17;   // start with a non-zero seed
        result = result * 31 + (firsName == null ? 0 : firsName.hashCode());
        result = result * 31 + (lasTName == null ? 0 : lasTName.hashCode());
        return result;
    }
}
