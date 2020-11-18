package lal;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {
        System.out.println("Example for enums");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345);
        //example with enums
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumMessage enumMessage = builder.build();
        System.out.println(enumMessage);
    }
}
