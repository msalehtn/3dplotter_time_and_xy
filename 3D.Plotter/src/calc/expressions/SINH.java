package calc.expressions;

import calc.parser.ExpTree;

public class SINH extends ExpTree {
			public double eVal(){
			return 	Math.sinh(this.left.eVal());
			
	
}
}
