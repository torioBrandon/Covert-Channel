UTEID: ofl74; bct562; 
FIRSTNAME: Olivia; Brandon; 
LASTNAME: Labath; Torio;
CSACCOUNT: ofl74; btorio;
EMAIL: olivialabath@utexas.edu; nodnarbtorio@yahoo.com;

Our SecureSystem class holds an arbitrary number of Subjects, which have a	name, a SecurityLevel (LOW or HIGH), and an int value temp. The	ReferenceMonitor class holds an instance of the ObjectManager class, which holds an arbitrary number of Objects. Objects have a name, an int value, and a SecurityLevel (LOW or HIGH). In the main method of our SecureSystem class, we create Subjects Hal and Lyle, with SecurityLevel's HIGH and LOW respectively, and Objects Hobj and Lobj, with SecurityLevel's HIGH and LOW respectively. Then we read in the argument given in the command line to create our file name, then read inputs from that file. While the file has input, first we tokenize a command (a line of input). If the command is valid, then we create a new READ or WRITE InstructionObject (the InstructionObject class has an instructionType, a Subject, and in value, and an Object). If it's invalid, then we create an InstructionObject of type BAD. Then we pass the InstructionObject to the ReferenceMonitor, which evaluates the instruction. If the Subject has clearance to read or write the Object, then it does so. Otherwise it does nothing. Then we print the state of the SecureSystem, and loop until no input remains.

We have finished all requirements.

/*
** TEST CASES

WRITE HAL HOBJ 1
write hal hobj 2
write hal lobj 3
write lyle lobj 4
READ LYLE LOBJ
read lyle hobj
write lyle lobj 5
write lyle hobj 6
read hal lobj
read hal hobj
read hal hobj 7
write blah blah blah

*/

/*
** TEST OUTPUT

Hal writes value 1 to Hobj
The current state is: 
Lobj has value: 0
Hobj has value: 1
Lyle has recently read: 0
Hal has recently read: 0

Hal writes value 2 to Hobj
The current state is: 
Lobj has value: 0
Hobj has value: 2
Lyle has recently read: 0
Hal has recently read: 0

Hal writes value 3 to Lobj
The current state is: 
Lobj has value: 0
Hobj has value: 2
Lyle has recently read: 0
Hal has recently read: 0

Lyle writes value 4 to Lobj
The current state is: 
Lobj has value: 4
Hobj has value: 2
Lyle has recently read: 0
Hal has recently read: 0

Lyle reads Lobj
The current state is: 
Lobj has value: 4
Hobj has value: 2
Lyle has recently read: 4
Hal has recently read: 0

Lyle reads Hobj
The current state is: 
Lobj has value: 4
Hobj has value: 2
Lyle has recently read: 0
Hal has recently read: 0

Lyle writes value 5 to Lobj
The current state is: 
Lobj has value: 5
Hobj has value: 2
Lyle has recently read: 0
Hal has recently read: 0

Lyle writes value 6 to Hobj
The current state is: 
Lobj has value: 5
Hobj has value: 6
Lyle has recently read: 0
Hal has recently read: 0

Hal reads Lobj
The current state is: 
Lobj has value: 5
Hobj has value: 6
Lyle has recently read: 0
Hal has recently read: 5

Hal reads Hobj
The current state is: 
Lobj has value: 5
Hobj has value: 6
Lyle has recently read: 0
Hal has recently read: 6

Bad Instruction
The current state is: 
Lobj has value: 5
Hobj has value: 6
Lyle has recently read: 0
Hal has recently read: 6

Bad Instruction
The current state is: 
Lobj has value: 5
Hobj has value: 6
Lyle has recently read: 0
Hal has recently read: 6

*/

