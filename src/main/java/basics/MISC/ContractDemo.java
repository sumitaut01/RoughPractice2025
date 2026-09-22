//package basics.MISC;
//
//import org.jetbrains.annotations.Contract;
//
//public class ContractDemo {
//
//
//    @Contract("null -> false")
//    public boolean isValid(String value) {
//        return value != null && !value.isEmpty();
//    }
//
//    /*
//    This tells IntelliJ:
//
//If input is null, return value will always be false.
//     */
//
//    /*
//    @Contract helps IntelliJ perform smarter static analysis. It usually has no runtime effect.
//     */
//
//}
