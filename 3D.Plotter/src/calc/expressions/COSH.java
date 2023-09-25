package calc.expressions;

import calc.parser.ExpTree;

public class COSH extends ExpTree {
			public double eVal(){
			return 	Math.cosh(this.left.eVal());
			
	
}
}
