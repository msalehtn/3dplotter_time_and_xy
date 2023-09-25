package calc.expressions;

import calc.parser.ExpTree;

public class ARCCOS extends ExpTree {
			public double eVal(){
			return 	Math.acos(this.left.eVal());
			
			}
			
}
