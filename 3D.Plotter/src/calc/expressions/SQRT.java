package calc.expressions;

import calc.parser.ExpTree;

public class SQRT extends ExpTree {
			public double eVal(){
			return 	Math.sqrt(this.left.eVal());
			
	
}
}
