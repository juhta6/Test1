package application;

import java.io.*;
import java.awt.GraphicsEnvironment;

public class Launch {
    public static void main (String [] args) throws Throwable{
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = Launch.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        }else{
            Main.main(new String[0]);
            System.out.close();
        }
    }
}