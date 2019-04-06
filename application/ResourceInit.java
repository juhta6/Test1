package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JOptionPane;

public class ResourceInit {

	private final ClassLoader cl = getClass().getClassLoader();
	private final URL URL = cl.getResource("image.png");
	
	//checks the source and creates the virtual file
	public ResourceInit() {
		System.out.println("Loading "+getClass());
		try {
		    InputStream inputStream = URL.openStream();
		    try {
		        JOptionPane.showMessageDialog(null, "The file '"+URL+"' exists: "+checkFile(URL).toString().toUpperCase());
		    } finally {
		        inputStream.close();
		    }
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	//checks if the file exists in the system
	private final Boolean checkFile(URL URL) throws IOException {
		if(URL.getFile().endsWith("image.png")) return true;
		else return false;
	}
	
	
	public final String getURL() {
		return URL.toString();
	}

}
