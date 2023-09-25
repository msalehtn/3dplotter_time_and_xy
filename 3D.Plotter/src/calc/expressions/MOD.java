package calc.expressions;

import calc.parser.ExpTree;

public class MOD extends ExpTree {
	public double eVal(){
	return 	this.left.eVal()% this.right.eVal();
	
	}
}