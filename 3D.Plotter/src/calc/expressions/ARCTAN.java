package calc.expressions;

import calc.parser.ExpTree;

public class ARCTAN extends ExpTree {
			public double eVal(){
			return 	Math.atan(this.left.eVal());
			
			}
			
}
