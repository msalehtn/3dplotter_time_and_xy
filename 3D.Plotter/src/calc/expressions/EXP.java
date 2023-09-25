package calc.expressions;

import calc.parser.ExpTree;

public class EXP extends ExpTree {
			public double eVal(){
			return 	Math.exp(this.left.eVal());
			
			}
			
}
