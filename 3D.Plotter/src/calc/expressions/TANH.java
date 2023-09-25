package calc.expressions;

import calc.parser.ExpTree;

public class TANH extends ExpTree {
			public double eVal(){
			return 	Math.tanh(this.left.eVal());
			
	
}
}
