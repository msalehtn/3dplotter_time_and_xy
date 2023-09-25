package calc.expressions;

import calc.parser.ExpTree;

public class TAN extends ExpTree {
			public double eVal(){
			return 	Math.tan(this.left.eVal());
			
			}
			
}
