package calc.expressions;

import calc.parser.ExpTree;

public class FACT extends ExpTree {
			public double eVal(){
			return 	fact((int)this.left.eVal());
			
			}
			
			private  static long fact(int a){
				if (a==0)
					return 1;
				else
					return a*fact(a-1);
			}
			
}
