package lal;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello World");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        //repeated field
        builder.addSampleList(1)
                .addSampleList(2)
                .addAllSampleList(Arrays.asList(3, 4, 5));

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();

        // write the protocol buffers binary to a file
        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send as byte array
//        byte[] bytes = message.toByteArray();

        try {
            System.out.println("Reading from file...");
            FileInputStream inputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);
            System.out.println(messageFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
