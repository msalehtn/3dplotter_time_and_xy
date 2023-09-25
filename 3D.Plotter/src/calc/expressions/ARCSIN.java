package calc.expressions;

import calc.parser.ExpTree;

public class ARCSIN extends ExpTree {
			public double eVal(){
			return 	Math.asin(this.left.eVal());
			
			}
			
}
