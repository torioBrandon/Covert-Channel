import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CovertChannel {

	public static void main(String[] args) {
		
		File file;
		if (args[0].equalsIgnoreCase("v")){
			// do something
			file = new File(args[1]);
		}
		else		
			file = new File(args[0]);

		SecureSystem sys = new SecureSystem();
		
		SecureSystem.SecurityLevel low = SecureSystem.SecurityLevel.LOW;
		SecureSystem.SecurityLevel high = SecureSystem.SecurityLevel.HIGH;
		
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
		
		try {
			Scanner sc = new Scanner(file);
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