package calc.expressions;

import calc.parser.ExpTree;

public class ADD extends ExpTree {
			public double eVal(){
			return 	this.right.eVal()+ this.left.eVal();
			
	
}
}
