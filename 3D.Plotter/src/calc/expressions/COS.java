package calc.expressions;

import calc.parser.ExpTree;

public class COS extends ExpTree {
			public double eVal(){
			return Math.cos(this.left.eVal());
			
	
}
}
