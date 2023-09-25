package calc.parser;

public class Value extends ExpTree {
	double val;
	
	public void setVal(String expStr) {
	val = Double.parseDouble(expStr);
	}
	
	
	public double eVal(){
		return 	val;
		}
	
}
