package calc.expressions;

import calc.parser.ExpTree;

public class MCM extends ExpTree {
			public double eVal(){
				double a=this.left.eVal();
				double b= this.right.eVal();
				return a*b/(double)gcd((int)a,(int) b);
							
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