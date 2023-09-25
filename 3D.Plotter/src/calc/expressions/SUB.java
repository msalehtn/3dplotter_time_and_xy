package calc.expressions;

import calc.parser.ExpTree;

public class SUB extends ExpTree {
			public double eVal(){
			return 	this.left.eVal()- this.right.eVal() ;
			
	
}
}
