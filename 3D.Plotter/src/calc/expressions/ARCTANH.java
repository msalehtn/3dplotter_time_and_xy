package calc.expressions;

import calc.parser.ExpTree;

public class ARCTANH extends ExpTree{ 

		public double eVal(){
			double a = this.left.eVal();
			
			return (double) (.5* Math.log((1+a)/(1-a)));
					
		}	

}
