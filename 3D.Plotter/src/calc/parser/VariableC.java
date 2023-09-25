package calc.parser;

public class VariableC extends ExpTree  {

	
	@Override
	public double eVal(){
		return VarDataBase.getC();
	}





}
