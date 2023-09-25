package calc.expressions;

import calc.parser.ExpTree;

public class ARCSINH extends ExpTree{ 

		public double eVal(){
			double a = this.left.eVal();
			
			return Math.log(a+ Math.sqrt(a*a+1));	
		}	

}
