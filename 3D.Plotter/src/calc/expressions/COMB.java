package calc.expressions;

import calc.parser.ExpTree;

public class COMB extends ExpTree {
			public double eVal(){
				
			return 	tarkib((int)this.left.eVal(),(int)this.right.eVal()) ;
			}
			
			public static int tarkib(int a , int b)
			{
				if (a==b)
					return 1;
				
				if (a==1)
					return b;
				
				return tarkib(a-1,b-1)+tarkib(a,b-1);
				
			}
			
}
