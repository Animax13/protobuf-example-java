package lal;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        //repeated field
        builder.addSampleList(1)
                .addSampleList(2)
                .addAllSampleList(Arrays.asList(3, 4, 5));

        // Print this as a json
        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        // Read from json to proto
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);
        System.out.println(builder2);
    }
}
