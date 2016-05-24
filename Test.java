import java.util.*;

public class Test{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);


		System.out.println("Select Algorithm:");
		System.out.println("[1] FLAMES");
		System.out.println("[2] True Love");
		System.out.println("I choose: ");

		String algo = sc.nextLine();
		String input;
		String result;

		if(algo.equals("")){
			algo = "1";
		}
		if(!algo.equals("1") && !algo.equals("2")){
			System.out.println("Invalid input");
		}
		else{
			System.out.println("Enter two comma separated names: ");
			input = sc.nextLine();

			InputTester it = new InputTester();
			if(!it.checkInput(input)){
				System.out.println("Invalid input");
			}
			else{

				String[] inputNames = input.split(",", 2);

				if(algo.equals("1")){
					Flames fl = new Flames();
					result = fl.compute(inputNames[0], inputNames[1]);
				}
				else{
					TrueLove tl = new TrueLove();
					result = tl.compute(inputNames[0], inputNames[1]);
				}

				System.out.println(result);
			}
		}

	}
}