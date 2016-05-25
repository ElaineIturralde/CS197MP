public class FlamesTester{

	static Flames fl;

	public static void main(String args[]){
		fl = new Flames();
		//assume inputs are validated before reaching Flames calculator

		System.out.println("test compute function");
		test_compute();

		System.out.println("test inputPrep function");
		test_lowercase();
		test_uppercase();
		test_camelcase();
		test_name_wspace();
		test_name_wospace();

		System.out.println("test doAlgo function: swapping");
		test_first_isLonger();
		test_second_isLonger();
		test_same_length();

		System.out.println("test doAlgo function: removing same characters");
		test_all_removed();
		test_none_removed();
		test_some_removed();

		System.out.println("test doAlgo function: loop");
		test_cross_last();
		test_cross_first();
		test_cross_mid();
		test_count_lt_six();
		test_count_mt_six();

		System.out.println("test getOutput function");
		test_friendship();
		test_love();
		test_affection();
		test_marriage();
		test_enemy();
		test_sibling();
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
		String result = fl.compute("john", "jane");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_lowercase(){
		String result = fl.inputPrep("john");
		assertt(result, "john");
	}

	public static void test_uppercase(){
		String result = fl.inputPrep("JOHN");
		assertt(result, "john");
	}

	public static void test_camelcase(){
		String result = fl.inputPrep("John");
		assertt(result, "john");
	}

	public static void test_name_wspace(){
		String result = fl.inputPrep("john doe adeer");
		assertt(result, "johndoeadeer");
	}

	public static void test_name_wospace(){
		String result = fl.inputPrep("johndoeadeer");
		assertt(result, "johndoeadeer");
	}

	public static void test_first_isLonger(){
		String result = fl.doAlgo("ABCDEF", "ABC");
		assertt(result, "F");
	}

	public static void test_second_isLonger(){
		String result = fl.doAlgo("ABC", "ABCDEF");
		assertt(result, "F");
	}

	public static void test_same_length(){
		String result = fl.doAlgo("ABCDEF", "GHIJKL");
		assertt(result, "A");
	}

	public static void test_all_removed(){
		String result = fl.doAlgo("john", "john");
		assertt(result, "F");	//di ko sure kung ano talaga dapat sagot dito
	}

	public static void test_none_removed(){
		String result = fl.doAlgo("alice", "bob");
		assertt(result, "A");
	}

	public static void test_some_removed(){
		String result = fl.doAlgo("alice", "alan");
		assertt(result, "E");
	}

	public static void test_cross_last(){
		String result = fl.doAlgo("abc", "def");
		assertt(result, "M");
	}

	public static void test_cross_first(){
		String result = fl.doAlgo("abb", "bbb");
		assertt(result, "S");
	}

	public static void test_cross_mid(){
		String result = fl.doAlgo("abc", "abcdef");
		assertt(result, "F");
	}

	public static void test_count_lt_six(){
		String result = fl.doAlgo("abcdef", "abc");
		assertt(result, "F");
	}

	public static void test_count_mt_six(){
		String result = fl.doAlgo("abc", "defg");
		assertt(result, "E");
	}

	public static void test_friendship(){
		String result = fl.getOutput("F");
		assertt(result, "FLAMES result is: Friendship");
	}

	public static void test_love(){
		String result = fl.getOutput("L");
		assertt(result, "FLAMES result is: Love");
	}

	public static void test_affection(){
		String result = fl.getOutput("A");
		assertt(result, "FLAMES result is: Affection");
	}

	public static void test_marriage(){
		String result = fl.getOutput("M");
		assertt(result, "FLAMES result is: Marriage");
	}

	public static void test_enemy(){
		String result = fl.getOutput("E");
		assertt(result, "FLAMES result is: Enemy");
	}

	public static void test_sibling(){
		String result = fl.getOutput("S");
		assertt(result, "FLAMES result is: Sibling");
	}
}