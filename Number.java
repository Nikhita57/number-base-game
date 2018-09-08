public class Number {

	private int base10Value;
	  private int base;
	  private String baseRepresentation;
	  
	  public Number() {
	    base10Value = 2;
	    base = 10;
	    baseRepresentation = represent(base10Value, base);
	  }
	  
	  public Number(int baseTenValue, int whatBase) {
	    base10Value = baseTenValue;
	    base = whatBase;
	    baseRepresentation = represent(base10Value, base);
	  
	  }
	  
	  public Number(String representation, int whatBase) {
		    baseRepresentation = representation;
		    base = whatBase;
		    base10Value = convertToBase10(baseRepresentation, base);
		  
		  }
	  
	  public int getBase10Value() {
	    return base10Value;
	  }
	  
	  public int getBase() {
	    return base;
	  }
	  
	  public String getBaseRepresentation() {
	    return baseRepresentation;
	  }
	  
	  public void setBase10Value(int baseTenValue) {
	    base10Value = baseTenValue;
	    baseRepresentation = represent(base10Value, base);
	  }
	  
	  public int convertToBase10 (String representation, int base) {
		  int value = 0;  
		  for (int i = representation.length()-1; i >= 0; i--) {
			  if (Character.isLetter(representation.charAt(i))) {
				  value += (int) ((representation.charAt(i)-55)*(Math.pow(base, representation.length()-i-1)));
			  } else {
				  value += (int) (Integer.parseInt(representation.substring(i, i+1))*(Math.pow(base, representation.length()-i-1)));
			  }
		  }
		  return value;
	  }
	  
	  public String represent(int baseTenValue, int whatBase) {
	    //This code comes from here: file:///C:/Users/bins010214/Downloads/truncation-rounding.html
	    //truncated = Math.round(nontruncated - 0.5f);
	    int v = baseTenValue;
	    String r = "";
	    int count = 0;
	    int d = 0;
	    while ((int) Math.pow(whatBase, count) <= v) {
	      count++;
	    }
	    
	    //For bases above 10, extra "digits," for lack of a better term, are necessary
	    //The standard is to use letters for these, with A as 10, B as 11, C as 12, and so on
	    //I use the ASCII encoding to easily place the letters where necessary
	    //ASCII table found here: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
	    for (int i = count-1; i >= 0; i--) {
	      d = (int) Math.round((v / Math.pow(whatBase, i))-0.5f);
	      v -= (d*(Math.pow(whatBase, i)));
	      if (d < 10) {
		    	r += Integer.toString(d);
		    } else {
		       char temp = (char) (d+55);
		       r += Character.toString(temp);
		    }
	    }
	    return r;
	    
	  }
	  
	  /* I don't currently want methods to directly change the base or the shown representation,
	     as changing the base could lead to "digits" invalid in the current base, and the representation
	     should depend entirely on the base 10 value and the base and should therefore be set only by the
	     represent() method. */
	  
	
}
