package lal;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {
        System.out.println("Complex Example");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        // singular message field
        ComplexMessage.Builder builder = ComplexMessage.newBuilder();
        builder.setOneDummy(oneDummy);

        //repeated field
        builder.addMultipleDummy(newDummyMessage(66, "second dummy"));
        builder.addMultipleDummy(newDummyMessage(67, "third dummy"));
        builder.addMultipleDummy(newDummyMessage(68, "fourth dummy"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(69, "other dummy"),
                newDummyMessage(70, "other other dummy")
        ));

        ComplexMessage message = builder.build();
        System.out.println(message);
    }

    public static DummyMessage newDummyMessage (Integer id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();
        return builder.setName(name)
                .setId(id)
                .build();
    }
}
