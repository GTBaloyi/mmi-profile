package com.mmi.profiles.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public String savePicture(MultipartFile profilePicture, String username) {
        String fileExtension = profilePicture.getOriginalFilename().split("\\.")[1];
        String pictureDir = "C:\\tmp\\"+username+"."+fileExtension;
        File file = new File(pictureDir);
        try(FileOutputStream outputStream = new FileOutputStream(file)){
            outputStream.write(profilePicture.getBytes());
            return pictureDir;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public void deleteOldProfile(String oldPath) {
        try{
            Files.delete(Paths.get(oldPath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
