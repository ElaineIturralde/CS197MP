public class InputTester{

	public InputTester(){

	}

	public boolean checkInput(String input){
		if(input == null){
			return false;
		}
		else{
			String[] names = input.split(",", 2);
			
			if(names.length != 2){
				return false;
			}
			else{
				for(int i = 0; i < 2; i++){
					String x = names[i];
					x = x.replace(" ", "");

					if(x.length() == 0){
						return false;
					}
					for(int j = 0; j<x.length(); j++){
						if(!Character.isLetter(x.charAt(j))){
							System.out.println(x.charAt(j));
							return false;
						}
					}
				}

				return true;
			}
		}
	}

}