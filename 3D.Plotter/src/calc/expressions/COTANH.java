package calc.expressions;

import calc.parser.ExpTree;

public class COTANH extends ExpTree {
			public double eVal(){
			return 	1/Math.tanh(this.left.eVal());
			
	
}
}
