package cn.plusman.interview.file;

import sun.nio.ch.DirectBuffer;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;

/**
 * cn.plusman.interview.file
 *
 * @author plusman
 * @since 12/26/20
 */
public class CopyFileDemo {
    public static void copyFileByStream(File source, File dest) throws
        IOException {
        try (
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }


    public static void copyFileByChannel(File source, File dest) throws
        IOException {
        try (FileChannel sourceChannel = new FileInputStream(source)
            .getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel
                 ();){
            for (long count = sourceChannel.size() ;count>0 ;) {
                long transferred = sourceChannel.transferTo(
                    sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }

    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(20);
        bf.capacity();

        DoubleBuffer dbf = DoubleBuffer.allocate(100);
    }
}
