public class TrueLove implements Calculator{

	public TrueLove(){

	}

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
	
	public String doAlgo(String x, String y){
		String xy = x + y + "";

		int truee = count("true", xy);
		int love = count("love", xy);

		return "" + truee + love;
	}

	public static int count(String x, String y){
		int ans = 0;

		for(int i = 0; i<x.length(); i++){
			for(int j = 0; j<y.length(); j++){
				if(y.charAt(j) == x.charAt(i)){
					ans++;
				}
			}
		}

		return ans;
	}

	public String getOutput(String raw){
		return "Your compatibility is: " + raw;
	}

}