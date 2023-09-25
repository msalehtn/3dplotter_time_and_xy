package calc.expressions;

import calc.parser.ExpTree;

public class SIN extends ExpTree {
			public double eVal(){
			return 	Math.sin(this.left.eVal());
			
	
}
}
