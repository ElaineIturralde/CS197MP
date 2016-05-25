public class InputChecker{

	public InputChecker(){

	}

	public boolean checkInput(String input){
		if(isNull(input)){
			return false;
		}
		else{
			if(!rightComma(input)){
				return false;
			}
			else{
				if(!noSymbol(input)){
					return false;
				}

				return true;
			}
		}
	}

	public boolean isNull(String input){
		if(input == null){
			return true;
		}
		return false;
	}

	public boolean rightComma(String input){
		String[] names = input.split(",");
			
		if(names.length != 2){
			return false;
		}
		return true;
	}

	public boolean noSymbol(String input){
		String[] names = input.split(",", 2);

		for(int i = 0; i < 2; i++){
			String x = names[i];
			x = x.replace(" ", "");

			if(x.length() == 0){
				return false;
			}
			for(int j = 0; j<x.length(); j++){
				if(!Character.isLetter(x.charAt(j))){
					return false;
				}
			}
		}

		return true;
	}

}