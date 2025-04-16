package edu.kunsan.cie.examp;

/**
 * Hello world!
 *
 */
import java.io.File;
import edu.kunsan.cie.example.ExifParse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final File[] IMAGES = new File("c:/test/1").listFiles();

    public static void main( String[] args )
    {
        for (File image : IMAGES) {
			System.out.print(image.getName() + " ");
			try {
                System.out.println("Tags: " + ExifParse.parse(image));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
        System.out.println( "Hello World!" );
    }
}
