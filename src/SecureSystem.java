import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Integer;

//import InstructionObject.instructionType;

public class SecureSystem {
	
	// members
	ArrayList<Subject> subs = new ArrayList<Subject>();
	ReferenceMonitor rm = new ReferenceMonitor();
	
	public enum SecurityLevel {
		LOW, HIGH
	}
	
	
	// methods
	public void printState() {
		System.out.println("The current state is: ");
		rm.printObjectState();
		for(Subject s : subs){
			System.out.println("\t" + s.name + " has recently read: " + s.temp);
		}
		System.out.println();
	}
	
	public void create(String subj, String obj) {
		if (!rm.hasObject(obj)){
			Subject s = getSubject(subj);
			rm.createNewObject(obj, s.sl);
		}
	}
	
	public void destroy(String subj, String obj) {
		Subject s = getSubject(subj);
		if (rm.hasObject(obj)) {
			Object o = rm.getObject(obj);
			if (s.sl.compareTo(o.sl) <= 0)
				rm.destroyObject(o);
		}
	}
	

	
	public void createSubject(String str, SecurityLevel l) {
		Subject s = new Subject(str, l);
		subs.add(s);
	}
	
	public boolean isValid (String[] args, ReferenceMonitor rm) {
		
		// return false if the first word isn't read or write or if read and write
		// have an invalid number of arguments
		if (!args[0].equalsIgnoreCase("read") && !args[0].equalsIgnoreCase("write"))
			return false;
		if (args[0].equalsIgnoreCase("read") && args.length != 3)
			return false;
		if (args[0].equalsIgnoreCase("write") && args.length != 4)
			return false;
		
		// iterate through subs
		Subject s = null;
		for (int i = 0; i < subs.size(); ++i) {
			if (subs.get(i).name.equalsIgnoreCase(args[1])) {
				s = subs.get(i);
				break;
			}
		}
		if (s == null)
			return false;
		
		// iterate through objs
		Object o = rm.getObject(args[2]);
		if (o == null)
			return false;
		
		// otherwise, return true 
		return true;
		
	}
	
	public Subject getSubject(String name){
		for(int i = 0; i < subs.size(); i++){
			if(subs.get(i).name.equalsIgnoreCase(name))
				return subs.get(i);
		}
		return null;
	}
	
	
	public InstructionObject createInstruction(String[] args, ReferenceMonitor rm){
		InstructionObject currInstruction;
		if(args[0].equalsIgnoreCase("read")){
			currInstruction = new InstructionObject(InstructionObject.instructionType.READ, getSubject(args[1]), rm.getObject(args[2]));
		}else if(args[0].equalsIgnoreCase("write")){
			currInstruction = new InstructionObject(InstructionObject.instructionType.WRITE, getSubject(args[1]), rm.getObject(args[2]), Integer.parseInt(args[3])); 
		}else currInstruction = null;
		return currInstruction;
	}
	
	// main
	public static void main(String[] args) {
		
		String f = args[0] + ".txt";
		File file = new File(f);
		
		SecureSystem sys = new SecureSystem();
		
		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;
		
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
		
		sys.rm.createNewObject("Lobj", low);
		sys.rm.createNewObject("Hobj", high);
		
		try {
		
			Scanner sc = new Scanner(file);
//			Subject sub1 = new Subject("Lyle", 0);
			while (sc.hasNextLine()) {
				// tokenize the line
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				args = new String[st.countTokens()];
				int i = 0;
				while (st.hasMoreTokens()) {
					args[i] = st.nextToken();
					++i;
				}
				
				InstructionObject currInstruction;
				if(sys.isValid(args, sys.rm)) {
					//create the instruction object
					currInstruction = sys.createInstruction(args, sys.rm);
				}else{
					currInstruction = new InstructionObject();
				}
				sys.rm.evalInstruction(currInstruction);
				sys.printState();
			}
				
			
			sc.close();
			
			
			//"SecureSystem reads successive instructions from the instruction list,
			//parses them, and submits them to the reference monitor"
			//resourceMonitor.acceptInstruction(/*instruction object*/);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
