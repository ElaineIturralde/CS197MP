public class InputValidatorTester{
	
	static InputValidator ic;

	public static void main(String args[]){
		ic = new InputValidator();

		//integration test
		System.out.println("Test checkInput function");
		test_with_space();
		test_no_space();

		//equivalence partitioning
		System.out.println("\nTest isNull function");
		test_null();
		test_not_null();

		//equivalence partitioning
		System.out.println("\nTest rightComma function");
		test_no_comma();
		test_one_comma();
		test_many_comma();

		//equivalence partitioning
		System.out.println("\nTest noSymbol function");
		test_all_space();
		test_wsymbol();
		test_wosymbol();
	}

	public static void assertt(boolean result, boolean expected){
		if(result == expected){
			System.out.println("Passed");
		}
		else{
			System.out.println("Failed");
		}
	}

	public static void test_with_space(){
		boolean result = ic.checkInput("john doe,jane deer");
		assertt(result, true);
	}

	public static void test_no_space(){
		boolean result = ic.checkInput("johndoe,janedeer");
		assertt(result, true);
	}

	public static void test_null(){
		boolean result = ic.isNull(null);
		assertt(result, true);
	}

	public static void test_not_null(){
		boolean result = ic.isNull("notnull");
		assertt(result, false);
	}

	public static void test_no_comma(){
		boolean result = ic.rightComma("nocomma");
		assertt(result, false);
	}

	public static void test_one_comma(){
		boolean result = ic.rightComma("one,comma");
		assertt(result, true);
	}

	public static void test_many_comma(){
		boolean result = ic.rightComma("has,many,comma");
		assertt(result, false);
	}

	public static void test_all_space(){
		boolean result = ic.noSymbol("    ,    ");
		assertt(result, false);
	}	

	public static void test_wsymbol(){
		boolean result = ic.noSymbol("asd!!,?asd?");
		assertt(result, false);
	}

	public static void test_wosymbol(){
		boolean result = ic.noSymbol("asd,asd");
		assertt(result, true);
	}


}