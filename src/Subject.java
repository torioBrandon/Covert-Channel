import java.util.BitSet;

public class Subject {

	int temp;
	public String name;
	SecureSystem.SecurityLevel sl;
	int bitCounter = 0;
	BitSet b = new BitSet();
	
	public Subject(){
		temp = 0;	//this is the bit for the covert channel
		name = "who";
	}
	
	public Subject(String name, SecureSystem.SecurityLevel sl){
		this.sl = sl;
		this.name = name;
		this.temp = 0;
	}
	
	public void run(){
		
		if(bitCounter == 7)
			if(b.isEmpty()){
				//TERMINATE
			}
			//write complete byte to file
			bitCounter = 0;
			b.clear();
		}
		if(this.temp > 0){
			b.set(bitCounter);
		}
		bitCounter ++;
		
	}
	
	
}
