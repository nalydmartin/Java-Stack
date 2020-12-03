
public class ProjClassTest {

	public static void main(String[] args) {
		
		// 1st constructor
		ProjClass emptyProj = new ProjClass();
		
		// 2nd constructor
		ProjClass nameProj = new ProjClass("Lexus");
		
		// 3rd constructor
		ProjClass test = new ProjClass("Dylan", "is cool!");
		
		// --------------------TESTS----------------------------
		
		// For 3rd constructor
		String whatName = test.getName();
		String whatDesc = test.getDescription();
		System.out.println(whatName + ": " + whatDesc);
		String nameDesc = test.elevatorPitch();
		System.out.println(nameDesc);
		
		
		// For 2nd constructor
		String aName = nameProj.getName();
		System.out.println(aName);
		nameProj.setDescription("Drive like you stole it!");
		System.out.println(nameProj.elevatorPitch());
		
		
		// For 1st constructor
		emptyProj.setName("BMW");
		String projName = emptyProj.getName();
		System.out.println(projName);
		
		emptyProj.setDescription("Bougie ass b-");
		String projDesc = emptyProj.getDescription();
		System.out.println(projDesc);
		
		System.out.println(emptyProj.elevatorPitch());
	}

}
