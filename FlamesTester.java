public class FlamesTester{

	static Flames fl;

	public static void main(String args[]){
		fl = new Flames();
		//assume inputs are validated before reaching Flames calculator

		test_firstname();
		test_wholename();
		test_lowercase();
		test_uppercase();
		test_camelcase();
		test_name_wspace();
		test_same_name();
	}

	public static void assertt(String result, String expected){
		if(result.equals(expected)){
			System.out.println("Passed");
		}
		else{
			System.out.println("Failed");
		}
	}

	public static void test_firstname(){
		String result = fl.compute("john", "jane");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_wholename(){
		String result = fl.compute("john doe", "jane deer");
		assertt(result, "FLAMES result is: Friendship");
	}

	public static void test_lowercase(){
		String result = fl.compute("john", "jane");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_uppercase(){
		String result = fl.compute("JOHN", "JANE");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_camelcase(){
		String result = fl.compute("John", "Jane");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_name_wspace(){
		String result = fl.compute("john doe adeer", "jane deer");
		assertt(result, "FLAMES result is: Friendship");
	}

	public static void test_same_name(){
		String result = fl.compute("john", "john");
		assertt(result, "FLAMES result is: Friendship");	//di ko sure kung ano talaga dapat sagot dito
	}
}