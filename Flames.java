public class Flames extends Calculator{

	public Flames(){

	}

	public String doAlgo(String x, String y){
		String[] input = new String[2];

		input = swap(x, y);
		
		input = removeSameChar(input);

		int count = getCount(input);
		
		String raw_result = crossOutFlames(count);

		return raw_result;
	}

	public String[] swap(String x, String y){
		//swapping: x should be shorter

		String[] arr = new String[2];
		arr[0] = x;
		arr[1] = y;

		if(y.length() < x.length()){
			arr[0] = y;
			arr[1] = x;
		}

		return arr;
	}

	public String[] removeSameChar(String[] arr){
		//removing same characters
		for(int i = 0; i<arr[0].length(); i++){
			int y_length = arr[1].length();
			
			arr[1] = arr[1].replaceFirst(arr[0].charAt(i)+"", "");
			
			if(arr[1].length() < y_length){
				arr[0] = arr[0].replaceFirst(arr[0].charAt(i)+"", "");
				i--;
			}
		}

		return arr;
	}

	public int getCount(String[] arr){
		String to_count = arr[0] + arr[1] + "";
		return to_count.length();
	}

	public String crossOutFlames(int count){
		String flames = "FLAMES";
		int start = 0;
		
		while(flames.length() > 1){
			int remove_charAt = removeWhichChar(start, count, flames.length());
			flames = removeChar(flames, remove_charAt);
			start = getStart(flames, remove_charAt);
		}

		return flames;
	}

	public int removeWhichChar(int start, int count, int length){
		int remove_charAt = ((start+count)-1)%length;
		return remove_charAt;
	}

	public String removeChar(String flames, int remove_charAt){
		if(remove_charAt == -1){
			flames = "";
		}
		else if(remove_charAt == flames.length()-1){
			flames = flames.substring(0, remove_charAt);
		}
		else if(remove_charAt == 0){
			flames = flames.substring(1, flames.length());
		}
		else{
			flames = flames.substring(0, remove_charAt) + flames.substring(remove_charAt+1, flames.length());
		}

		return flames;
	}

	public int getStart(String flames, int remove_charAt){
		if(remove_charAt == flames.length()){
			return 0;
		}
		else{
			return remove_charAt;
		}
	}

	public String getOutput(String raw){
		String[] map = {"Friendship", "Love", "Affection", "Marriage", "Enemy", "Sibling"};
		if(raw.equals("")){
			return "FLAMES result is: ";
		}
		else{
			return "FLAMES result is: " + map["FLAMES".indexOf(raw)];
		}	
	}


}