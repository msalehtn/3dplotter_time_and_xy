package calc.expressions;

import calc.parser.ExpTree;

public class ROUND extends ExpTree {
			public double eVal(){
			return 	Math.round(this.left.eVal());
			
	
}
}
