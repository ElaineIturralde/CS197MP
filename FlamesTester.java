public class FlamesTester{

	static Flames fl;

	public static void main(String args[]){
		fl = new Flames();
		//assume inputs are validated before reaching Flames calculator

		//Integration test
		System.out.println("\nTest compute function");
		test_compute();

		//equivalence partitioning
		System.out.println("\nTest inputPrep function");
		test_lowercase();
		test_uppercase();
		test_camelcase();
		test_name_wspace();
		test_name_wospace();

		//(< > ==) equivalence partitioning??
		System.out.println("\nTest swap function");
		test_first_isLonger();
		test_second_isLonger();
		test_same_length();

		//equivalence partitioning??
		System.out.println("\nTest removeSameChar function");
		test_all_removed();
		test_none_removed();
		test_some_removed();

		//(++ 0+ +0 00) equivalence partitioning??
		System.out.println("\nTest getCount function");
		test_both_positive();
		test_one_zero();
		test_both_zero();

		//(< > ==) equivalence partitioning??
		System.out.println("\nTest removeWhichChar function");
		test_count_lt_length();
		test_count_mt_length();
		test_count_eq_length();

		//boundary values
		System.out.println("\nTest removeChar function");
		test_cross_last();
		test_cross_first();
		test_cross_mid();
		test_neg_charAt();

		//boundary values
		System.out.println("\nTest getStart function");
		test_removed_last();
		test_removed_first();
		test_removed_mid();
		test_removed_outOfBounds();
		
		//equivalence partitioning
		System.out.println("\nTest getOutput function");
		test_friendship();
		test_love();
		test_affection();
		test_marriage();
		test_enemy();
		test_sibling();
		test_wspace();
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
		String arr[] = new String[2];
		arr = fl.swap("ABCDEF", "ABC");
		String result = arr[0] + arr[1];
		assertt(result, "ABCABCDEF");
	}

	public static void test_second_isLonger(){
		String arr[] = new String[2];
		arr = fl.swap("ABC", "ABCDEF");
		String result = arr[0] + arr[1];
		assertt(result, "ABCABCDEF");
	}

	public static void test_same_length(){
		String arr[] = new String[2];
		arr = fl.swap("ABCDEF", "GHIJKL");
		String result = arr[0] + arr[1];
		assertt(result, "ABCDEFGHIJKL");
	}

	public static void test_all_removed(){
		String arr[] = new String[2];

		arr[0] = "john";
		arr[1] = "john";

		arr = fl.removeSameChar(arr);
		String result = arr[0] + arr[1];
		assertt(result, "");
	}

	public static void test_none_removed(){
		String arr[] = new String[2];

		arr[0] = "alice";
		arr[1] = "bob";

		arr = fl.removeSameChar(arr);
		String result = arr[0] + arr[1];
		assertt(result, "alicebob");
	}

	public static void test_some_removed(){
		String arr[] = new String[2];

		arr[0] = "alice";
		arr[1] = "alan";

		arr = fl.removeSameChar(arr);
		String result = arr[0] + arr[1];
		assertt(result, "icean");
	}

	public static void test_both_positive(){
		String arr[] = new String[2];

		arr[0] = "john";
		arr[1] = "jane";

		String result = fl.getCount(arr) + "";
		assertt(result, "8");
	}

	public static void test_one_zero(){
		String arr[] = new String[2];

		arr[0] = "john";
		arr[1] = "";

		String result = fl.getCount(arr) + "";
		assertt(result, "4");

		arr[0] = "";
		arr[1] = "jane";

		result = fl.getCount(arr) + "";
		assertt(result, "4");
	}

	public static void test_both_zero(){
		String arr[] = new String[2];

		arr[0] = "";
		arr[1] = "";

		String result = fl.getCount(arr) + "";
		assertt(result, "0");
	}

	public static void test_count_lt_length(){
		String result = fl.removeWhichChar(0, 3, 6) + "";
		assertt(result, "2");
	}

	public static void test_count_mt_length(){
		String result = fl.removeWhichChar(3, 3, 4) + "";
		assertt(result, "1");
	}

	public static void test_count_eq_length(){
		String result = fl.removeWhichChar(3, 4, 6) + "";
		assertt(result, "0");
	}

	public static void test_cross_last(){
		String result = fl.removeChar("abc", 2);
		assertt(result, "ab");
	}

	public static void test_cross_first(){
		String result = fl.removeChar("abc", 0);
		assertt(result, "bc");
	}

	public static void test_cross_mid(){
		String result = fl.removeChar("abc", 1);
		assertt(result, "ac");
	}

	public static void test_neg_charAt(){
		String result = fl.removeChar("abc", -1);
		assertt(result, "");
	}

	public static void test_removed_last(){
		String result = fl.getStart("abc", 3) + "";
		assertt(result, "0");
	}

	public static void test_removed_first(){
		String result = fl.getStart("bcd", 0) + "";
		assertt(result, "0");
	}

	public static void test_removed_mid(){
		String result = fl.getStart("acd", 1) + "";
		assertt(result, "1");
	}

	public static void test_removed_outOfBounds(){
		String result = fl.getStart("abcd", -1) + "";
		assertt(result, "-1");
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

	public static void test_wspace(){
		String result = fl.getOutput("");
		assertt(result, "FLAMES result is: ");
	}
}