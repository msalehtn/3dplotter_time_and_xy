package calc.parser;

public class VariableX extends ExpTree  {


@Override
public double eVal(){
	return VarDataBase.getX();
}


}
