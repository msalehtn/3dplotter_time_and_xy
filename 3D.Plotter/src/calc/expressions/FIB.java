package calc.expressions;

import calc.parser.ExpTree;

public class FIB extends ExpTree {
			public double eVal(){
			return 	fib((int) this.left.eVal());
			
	
				}
			
			public static long fib(int a)
			{
			
							
			long x=1;
			long y=1;
				for (int i = 1 ;i<a-1;i++) 
				{
					y=x+y;
					x=y-x;
					
						


				}
				
				return y;	
				
				
							
			}
}