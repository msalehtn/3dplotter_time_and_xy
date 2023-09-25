package calc.parser;

public class Variable extends ExpTree  {

	private String varName;
	@Override
	public double eVal(){
		for(int i = 0 ;i<VarDataBase.getVarNames().size();i++){
			if(varName.equalsIgnoreCase(VarDataBase.getVarNames().get(i))){
				return VarDataBase.getVarValues().get(i);
			}
		}
		return 0;
	}
	
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}





}
