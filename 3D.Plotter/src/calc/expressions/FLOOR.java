package calc.expressions;

import calc.parser.ExpTree;

public class FLOOR extends ExpTree {
			public double eVal(){
			return 	Math.floor(this.left.eVal());
			
	
}
}
