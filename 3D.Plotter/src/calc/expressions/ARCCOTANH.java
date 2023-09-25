package calc.expressions;

import calc.parser.ExpTree;

public class ARCCOTANH extends ExpTree{ 

		public double eVal(){
			double a = this.left.eVal();
			
			return (double) (.5* Math.log((a-1)/(1+a)));
					
		}	

}
