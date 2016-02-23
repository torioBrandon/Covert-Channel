
public class InstructionObject {

	// members
	public enum instructionType {
		READ, WRITE, BAD
	}
	
	instructionType instr;
	Subject subj;
	int val;
	Object obj;
	
	//write constructor
	public InstructionObject (instructionType instr, Subject subj, Object obj, int val) {
		this.instr = instr;
		this.subj = subj;
		this.obj = obj;
		this.val = val;
	}
	//read constructino
	public InstructionObject (instructionType instr, Subject subj, Object obj) {
		this.instr = instr;
		this.subj = subj;
		this.obj = obj;
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
