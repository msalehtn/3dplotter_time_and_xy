package calc.expressions;

import calc.parser.ExpTree;

public class CEIL extends ExpTree {
			public double eVal(){
			return 	Math.ceil(this.left.eVal());
			
	
}
}
