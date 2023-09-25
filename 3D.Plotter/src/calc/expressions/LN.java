package calc.expressions;

import calc.parser.ExpTree;

public class LN extends ExpTree {
			public double eVal(){
			return 	Math.log(this.left.eVal());
			
	
}
}
