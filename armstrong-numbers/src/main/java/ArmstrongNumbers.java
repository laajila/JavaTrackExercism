class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		int numberOfdigits= (int) Math.log10(numberToCheck)+1;
		int checks=numberToCheck;
		int sum=0;
		int digit=0;
		for(int i=numberOfdigits-1;i>=0;i--){
			digit=(int) (checks/Math.pow(10,i));
			sum+=Math.pow(digit,numberOfdigits);
			checks=(int) (checks%Math.pow(10,i));
		}

		return  sum==numberToCheck;
		
	}

}
