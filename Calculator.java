public abstract class Calculator{
	public String compute(String x, String y){
		x = inputPrep(x);
		y = inputPrep(y);

		String raw_result = doAlgo(x, y);

		return getOutput(raw_result);
	}

	public String inputPrep(String str){
		str = str.toLowerCase().replace(" ", "");
		return str;
	}

	public abstract String doAlgo(String x, String y);

	public abstract String getOutput(String str);
}