package calc.expressions;

import calc.parser.ExpTree;

public class COTAN extends ExpTree {
			public double eVal(){
			return 	1/Math.tan(this.left.eVal());
			
			}
			
}
