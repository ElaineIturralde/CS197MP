public class Flames implements Calculator{

	public Flames(){

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
		if(y.length() < x.length()){
			String foo = x;
			x = y;
			y = foo;
		}

		for(int i = 0; i<x.length(); i++){
			int y_length = y.length();
			
			y = y.replace(x.charAt(i)+"", "");
			
			if(y.length() < y_length){
				x = x.replace(x.charAt(i)+"", "");
				i--;
			}
		}

		String to_count = x + y + "";
		int count = to_count.length();
		String flames = "FLAMES";
		int start = 0;

		if(count == 0){
			return "F";
		}

		while(flames.length() != 1){
			int remove_charAt = ((start+count)-1)%flames.length();
			
			if(remove_charAt == flames.length()-1){
				flames = flames.substring(0, remove_charAt);
				start = 0;
			}
			else if(remove_charAt == 0){
				flames = flames.substring(1, flames.length());
				start = 0;
			}
			else{
				flames = flames.substring(0, remove_charAt) + flames.substring(remove_charAt+1, flames.length());
				start = remove_charAt;
			}
		}

		return flames;
	}
	

	public String getOutput(String raw){
		String[] map = {"Friendship", "Love", "Affection", "Marriage", "Enemy", "Sibling"};
		return "FLAMES result is: " + map["FLAMES".indexOf(raw)];
	}


}