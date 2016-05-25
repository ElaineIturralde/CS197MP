public class TrueLoveTester{
	
	static TrueLove tl;

	public static void main(String args[]){
		tl = new TrueLove();

		System.out.println("test inputPrep function");
		test_lowercase();
		test_uppercase();
		test_camelcase();
		test_name_wspace();
		test_name_wospace();

		System.out.println("test doAlgo function");
		System.out.println("test getOutput function");
		test_output();
	}

	public static void assertt(String result, String expected){
		if(result.equals(expected)){
			System.out.println("Passed");
		}
		else{
			System.out.println("Failed");
		}
	}

	public static void test_lowercase(){
		String result = tl.inputPrep("john");
		assertt(result, "john");
	}

	public static void test_uppercase(){
		String result = tl.inputPrep("JOHN");
		assertt(result, "john");
	}

	public static void test_camelcase(){
		String result = tl.inputPrep("John");
		assertt(result, "john");
	}

	public static void test_name_wspace(){
		String result = tl.inputPrep("john doe adeer");
		assertt(result, "johndoeadeer");
	}

	public static void test_name_wospace(){
		String result = tl.inputPrep("johndoeadeer");
		assertt(result, "johndoeadeer");
	}

	public static void test_output(){
		String result = tl.getOutput("100");
		assertt(result, "Your compatibility is: 100");
	}

}