package calc.parser;

public class VariableT extends ExpTree {


	@Override
	public double eVal(){
		return VarDataBase.getT();
	}




}
