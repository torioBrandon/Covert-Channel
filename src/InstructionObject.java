
public class InstructionObject {

	// members
	public enum instructionType {
		READ, WRITE, BAD, CREATE, DESTROY, RUN
	}
	
	instructionType instr;
	Subject subj;
	int val;
	Object obj;
	String objName;
	
	// write constructor
	public InstructionObject (instructionType instr, Subject subj, Object obj, int val) {
		this.instr = instr;
		this.subj = subj;
		this.obj = obj;
		this.val = val;
	}
	
	// read/destroy constructor
	public InstructionObject (instructionType instr, Subject subj, Object obj) {
		this.instr = instr;
		this.subj = subj;
		this.obj = obj;
		this.val = 0;
	}
	
	// create constructor
	public InstructionObject (instructionType instr, Subject subj, String name) {
		this.instr = instr;
		this.subj = subj;
		this.obj = null;
		this.val = 0;
		this.objName = name;
	}
	
	// run constructor
	public InstructionObject (instructionType instr, Subject subj) {
		this.instr = instr;
		this.subj = subj;
		this.obj = null;
		this.val = 0;
	}
	
	//bad constructor
	public InstructionObject(){
		this.instr = instructionType.BAD;
		this.subj = null;
		this.obj = null;
		this.val = 0;
	}
	
	

/*
 * instruction type
 * the subject's name
 * the object's name
 * value (if any)
 */
	
//	methods
	
}
