package com.mmi.profiles.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

public class Commons {

    //code to compress image so that it fits in the column size
    public byte[] comptressBytes (byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte [] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer,0,count);
        }

        try{
            outputStream.close();
        }
        catch (IOException e) {

        }

        return  outputStream.toByteArray();

    }
}
