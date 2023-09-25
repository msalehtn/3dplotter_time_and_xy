package calc.expressions;

import calc.parser.ExpTree;

public class ARCCOTAN extends ExpTree {
			public double eVal(){
			return 	Math.PI/2-Math.atan(this.left.eVal());
			
			}
			
}
