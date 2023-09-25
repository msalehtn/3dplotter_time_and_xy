package calc.expressions;

import calc.parser.ExpTree;

public class IDIV extends ExpTree {
	public double eVal(){
		return taghsimsahih(this.left.eVal(), this.right.eVal(), 0);
	
	}
	
				private static long taghsimsahih(double a , double b,int c )
				{
			
					if (a<b)
						return c;
					else
					{
						a-=b;
						c++;
						return taghsimsahih(a, b, c);
					}
					
					
				}
}
