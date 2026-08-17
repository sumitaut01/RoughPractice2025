package basics.enums;

public class EnumDemo {

    public static void main(String[] args) {

        String day = "Sunday";
        WEEKEND eDay = WEEKEND.valueOf(day.toUpperCase());
        System.out.println(eDay.description);


        String day2 = "Sunda";
        WEEKEND eDay2 = WEEKEND.valueOf(day2.toUpperCase());
        System.out.println(eDay.description);
        /*
        Exception in thread "main" java.lang.IllegalArgumentException: No enum constant basics.enums.WEEKEND.SUNDA
	at java.base/java.lang.Enum.valueOf(Enum.java:293)
	at basics.enums.WEEKEND.valueOf(EnumDemo.java:22)
	at basics.enums.EnumDemo.main(EnumDemo.java:13)
         */

    }
}


enum WEEKEND {
    SATURDAY("personal time off"),
    SUNDAY("family time off");
    String description;

    WEEKEND(String activity) {
        this.description = activity;
    }

    public String getActivity() {
        return description;
    }
}
