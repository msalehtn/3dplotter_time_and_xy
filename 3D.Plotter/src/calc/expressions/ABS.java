package calc.expressions;

import calc.parser.ExpTree;

public class ABS extends ExpTree {
			public double eVal(){
			return 	Math.abs( this.left.eVal());
			
	
}
}
