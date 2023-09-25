package calc.parser;
//String Functions
/**
 * * * * * * * * * * * * * * * * * * *
 * SF.java
 * @author MohammadSaleh Talebinezhad
 * Dec 24, 2014
 * * * * * * * * * * * * * * * * * * *
 */
public class SF {

	public static boolean isNum(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch(NumberFormatException e) { 
	    		return false;

	    }
	    return true;
	}
		
	public static boolean checkIfTwoInput(String oPerator) {
			
			
			// ToDO : tak input ha !
			
			if (oPerator.equalsIgnoreCase("add"))
				return true;
			if (oPerator.equalsIgnoreCase("sub"))
				return true;
			if (oPerator.equalsIgnoreCase("mul"))
				return true;
			if (oPerator.equalsIgnoreCase("div"))
				return true;
			if (oPerator.equalsIgnoreCase("pow"))
				return true;
			if (oPerator.equalsIgnoreCase("mod"))
				return true;
			if (oPerator.equalsIgnoreCase("idiv"))
				return true;
			if (oPerator.equalsIgnoreCase("gcd"))
				return true;
			if (oPerator.equalsIgnoreCase("mcm"))
				return true;
			if (oPerator.equalsIgnoreCase("comb"))
				return true;
		
			
			return false;
		}
	
		public static String replace(String str, int index, char replace){     
		    if(str==null){
		        return str;
		    }else if(index<0 || index>=str.length()){
		        return str;
		    }
		    char[] chars = str.toCharArray();
		    chars[index] = replace;
		    return String.valueOf(chars);       
		}
		

		public static boolean isItTheRightComma(String testing) {
			int p1=0;
			int p2=0;
			while(testing.indexOf("(")!= -1 || testing.indexOf(")")!= -1){
				
			if(testing.indexOf("(")!= -1){
				
				p1++;
				
				testing = replace(testing, testing.indexOf("("), 'e');
				
				
		      
		       
			}
			if(testing.indexOf(")")!= -1){
				p2++;
				testing = replace(testing, testing.indexOf(")"), 'e');
				
			}
			
			}
			
			if(p1==p2)
				return true;
			
			return false;
		}
	
}
