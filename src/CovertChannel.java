import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CovertChannel {

	public static void main(String[] args) {
		
		String filename;
		File infile, outfile;
		if (args[0].equalsIgnoreCase("v")){
			// do something
			filename = args[1];
		}
		else		
			filename = args[0];
		
		infile = new File(filename + ".txt");
		outfile = new File(filename + ".out");

		SecureSystem sys = new SecureSystem();
		
		SecureSystem.SecurityLevel low = SecureSystem.SecurityLevel.LOW;
		SecureSystem.SecurityLevel high = SecureSystem.SecurityLevel.HIGH;
		
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
		
		try {
			Scanner sc = new Scanner(infile);
			while (sc.hasNextLine()) {
				//String str = sc.nextLine();
				//byte[] currln = str.getBytes();
				
				
			}						
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}