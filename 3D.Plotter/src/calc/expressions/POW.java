package calc.expressions;

import calc.parser.ExpTree;

public class POW extends ExpTree {
			public double eVal(){
			return 	Math.pow(this.right.eVal(), this.left.eVal());
			
	
}
}
