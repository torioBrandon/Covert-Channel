import java.util.ArrayList;

public class ReferenceMonitor {

	// members
	private ObjectManager om = new ObjectManager();
	
	// methods

	public Object getObject (String name) {
		Object o = null;
		for (int i = 0; i < om.objs.size(); ++i) {
			if (om.objs.get(i).name.equalsIgnoreCase(name)) {
				o = om.objs.get(i);
				break;
			}
		}
		return o;
	}
	
	public void createNewObject(String name, SecureSystem.SecurityLevel sl){
		om.newObject(name, sl);
	}
	
	public boolean hasObject (String name){
		boolean hasObj = false;
		for (int i = 0; i < om.objs.size(); ++i) {
			if (om.objs.get(i).name.equalsIgnoreCase(name)) {
				hasObj = true;
				break;
			}
		}
		return hasObj;
	}
	
	public void printObjectState(){
		for (Object o : om.objs){
			System.out.println("\t" + o.name + " has value: " + o.val);
		}
	}
	
	public void destroyObject (Object obj) {
		if (om.objs.contains(obj))
			om.objs.remove(obj);
	}
	
	public void evalInstruction(InstructionObject currInstruction){
		Subject s = currInstruction.subj;
		Object o = currInstruction.obj;
		if(currInstruction.instr == InstructionObject.instructionType.READ){
			if((s.sl).compareTo(o.sl) >= 0){
				s.temp = o.val;
			} else {
				s.temp = 0;
			}
			System.out.println(s.name + " reads " + o.name);
		} if(currInstruction.instr == InstructionObject.instructionType.WRITE){
			if((s.sl).compareTo(o.sl) <= 0){
				o.val = currInstruction.val;
			}
			System.out.println(s.name + " writes value " + currInstruction.val + " to " + o.name);
		} else if(currInstruction.instr == InstructionObject.instructionType.BAD){
			System.out.println("Bad Instruction");
		}
	}
	
	public ReferenceMonitor(){}
	
	private class ObjectManager {		
		// members
		ArrayList<Object> objs = new ArrayList<Object>();
		
		// methods
		private void newObject(String name, SecureSystem.SecurityLevel sl) {
			Object o = new Object(name, sl);
			objs.add(o);
		}
		
	}
	
}
