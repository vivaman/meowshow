package io.viva.meowshow.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.annotation.SuppressLint;
import android.content.Context;

/**
 * Serialize Utils
 * 
 * @author Trinea 2012-5-14
 */
public class SerializeUtils {

    /**
     * deserialization from file
     * 
     * @param filePath
     * @return
     * @throws RuntimeException if an error occurs
     */
    public static Object deserialization(Context c, String filePath) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(c.openFileInput(filePath));
            Object o = in.readObject();
            in.close();
            return o;
        } catch (Exception e) {
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }

    /**
     * serialize to file
     * 
     * @param filePath
     * @param obj
     * @return
     * @throws RuntimeException if an error occurs
     */
    @SuppressLint("WorldWriteableFiles") 
    public static void serialization(Context c, String filePath, Object obj) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(c.openFileOutput(filePath, Context.MODE_WORLD_WRITEABLE));
            out.writeObject(obj);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }
}
