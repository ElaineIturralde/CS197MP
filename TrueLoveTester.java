public class TrueLoveTester{
	
	static TrueLove tl;

	public static void main(String args[]){
		tl = new TrueLove();

		System.out.println("test compute function");
		test_compute();

		System.out.println("test inputPrep function");
		test_lowercase();
		test_uppercase();
		test_camelcase();
		test_name_wspace();
		test_name_wospace();

		System.out.println("test doAlgo function");
		test_algo();

		System.out.println("test count function");
		test_same_all();
		test_same_none();
		test_same_some();

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

	public static void test_compute(){
		String result = tl.compute("john", "jane");
		assertt(result, "Your compatibility is: 12");
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

	public static void test_algo(){
		String result = tl.doAlgo("john", "jane");
		assertt(result, "12");
	}

	public static void test_same_all(){
		String result = tl.count("true", "truetrue")+"";
		assertt(result, "8");
	}

	public static void test_same_none(){
		String result = tl.count("love", "abcd")+"";
		assertt(result, "0");
	}

	public static void test_same_some(){
		String result = tl.count("true", "love")+"";
		assertt(result, "1");
	}

	public static void test_output(){
		String result = tl.getOutput("100");
		assertt(result, "Your compatibility is: 100");
	}

}