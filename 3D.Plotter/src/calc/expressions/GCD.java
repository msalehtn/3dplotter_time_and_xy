package calc.expressions;

import calc.parser.ExpTree;

public class GCD extends ExpTree {
			public double eVal(){
			return gcd((int)this.right.eVal(), (int)this.left.eVal());
			
			}
			
			private static int gcd(int a,int b)
			{
			
					// swap a and b if b is bigger
					if (b>a){
						b=a+b;
						a=b-a;
						b=b-a;
					}
					
					if (a%b==0)
						return b;
					else
						return gcd(b,a%b);
	
	
				}
			
			
}