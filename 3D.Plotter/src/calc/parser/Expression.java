package calc.parser;

import calc.expressions.ADD;
import calc.expressions.ARCCOS;
import calc.expressions.ARCCOSH;
import calc.expressions.ARCCOTAN;
import calc.expressions.ARCCOTANH;
import calc.expressions.ARCSIN;
import calc.expressions.ARCSINH;
import calc.expressions.ARCTAN;
import calc.expressions.ARCTANH;
import calc.expressions.CEIL;
import calc.expressions.COMB;
import calc.expressions.COS;
import calc.expressions.COSH;
import calc.expressions.COTAN;
import calc.expressions.COTANH;
import calc.expressions.DIV;
import calc.expressions.EXP;
import calc.expressions.FACT;
import calc.expressions.FIB;
import calc.expressions.FLOOR;
import calc.expressions.GCD;
import calc.expressions.IDIV;
import calc.expressions.LN;
import calc.expressions.MCM;
import calc.expressions.MOD;
import calc.expressions.MUL;
import calc.expressions.POW;
import calc.expressions.ROUND;
import calc.expressions.SIN;
import calc.expressions.SINH;
import calc.expressions.SQRT;
import calc.expressions.SUB;
import calc.expressions.TAN;
import calc.expressions.TANH;

public class Expression extends ExpTree {
String expStr = "";

	public Expression(String substring) {
		expStr = substring;
	}
	
	


	public double eVal(){
		
		return 0;
	}
	
	public ExpTree convert(){
		ExpTree node = null;

	if(expStr.contains("(")){

		String myOp=expStr.substring(0, expStr.indexOf("("));//myOp = my Operator
		String inPranthes = expStr.substring(expStr.indexOf("(")+1,expStr.length()-1);//What is in the myOperator ( )
		String tempVFP = inPranthes; // We make tempValueForPassing to find the middle ","

			if(SF.checkIfTwoInput(myOp)){
		
			String testComma = inPranthes.substring(0, inPranthes.indexOf(","));
			
			while(!SF.isItTheRightComma(testComma)){
			
				tempVFP = tempVFP.replaceFirst(",", "E");
		
				testComma = tempVFP.substring(0, tempVFP.indexOf(","));
				
			}
			int middle = tempVFP.indexOf(",");

			if (myOp.equalsIgnoreCase("add")){
				
				node = new ADD();
				
			}
			if (myOp.equalsIgnoreCase("sub")){
							
				node = new SUB();
							
			}
			if (myOp.equalsIgnoreCase("mul")){
				
				node = new MUL();
				
			}
			if (myOp.equalsIgnoreCase("div")){
				
				node = new DIV();
				
			}
			if (myOp.equalsIgnoreCase("pow")){
				
				node = new POW();
				
			}
			if (myOp.equalsIgnoreCase("mod")){
				
				node = new MOD();
				
			}
			if (myOp.equalsIgnoreCase("idiv")){
				
				node = new IDIV();
				
			}
			if (myOp.equalsIgnoreCase("gcd")){
				
				node = new GCD();
				
			}
			if (myOp.equalsIgnoreCase("mcm")){
				
				node = new MCM();
				
			}
			if (myOp.equalsIgnoreCase("comb")){
				
				node = new COMB();
				
			}

			
			
			node.right = new Expression(inPranthes.substring(0,middle)).convert();
			node.left = new Expression(inPranthes.substring(middle+1,inPranthes.length())).convert();
		
			
			}
			else
			{
			
			if (myOp.equalsIgnoreCase("fib")){
				
				node = new FIB();
				
			}
			if (myOp.equalsIgnoreCase("ln")){
				
				node = new LN();
				
			}
			if (myOp.equalsIgnoreCase("sqrt")){
							
				node = new SQRT();
							
			}
			if (myOp.equalsIgnoreCase("round")){
				
				node = new ROUND();
				
			}
			if (myOp.equalsIgnoreCase("ceil")){
				
				node = new CEIL();
				
			}
			if (myOp.equalsIgnoreCase("floor")){
				
				node = new FLOOR();
				
			}
			if (myOp.equalsIgnoreCase("fact")){
				
				node = new FACT();
				
			}
			if (myOp.equalsIgnoreCase("sin")){
				
				node = new SIN();
				
			}
			if (myOp.equalsIgnoreCase("cos")){
				
				node = new COS();
				
			}
			if (myOp.equalsIgnoreCase("tan")){
				
				node = new TAN();
				
			}
			if (myOp.equalsIgnoreCase("cotan")){
				
				node = new COTAN();
				
			}
			if (myOp.equalsIgnoreCase("arcsin")){
				
				node = new ARCSIN();
				
			}
			if (myOp.equalsIgnoreCase("arccos")){
				
				node = new ARCCOS();
				
			}
			if (myOp.equalsIgnoreCase("arctan")){
				
				node = new ARCTAN();
				
			}
			if (myOp.equalsIgnoreCase("arccotan")){
				
				node = new ARCCOTAN();
				
			}
			if (myOp.equalsIgnoreCase("sinh")){
				
				node = new SINH();
				
			}
			if (myOp.equalsIgnoreCase("cosh")){
				
				node = new COSH();
				
			}
			if (myOp.equalsIgnoreCase("tanh")){
				
				node = new TANH();
				
			}
			if (myOp.equalsIgnoreCase("cotanh")){
				
				node = new COTANH();
				
			}
			if (myOp.equalsIgnoreCase("arcsinh")){
				
				node = new ARCSINH();
				
			}
			if (myOp.equalsIgnoreCase("arccosh")){
				
				node = new ARCCOSH();
				
			}
			if (myOp.equalsIgnoreCase("arctanh")){
				
				node = new ARCTANH();
				
			}
			if (myOp.equalsIgnoreCase("arccotanh")){
				
				node = new ARCCOTANH();
				
			}
			if (myOp.equalsIgnoreCase("exp")){
							
				node = new EXP();
							
			}

			node.left = new Expression(inPranthes).convert();
			
			
		}
			
			

				
			
		}else if(SF.isNum(expStr)){
			
			Value x = new Value();
			x.setVal(this.expStr);
			node = x;
			
		}else
		{
			
			if(expStr.equalsIgnoreCase("x")){
				node = new VariableX();
			}
			else if(expStr.equalsIgnoreCase("c")){
				node = new VariableC();
			}
			else if(expStr.equalsIgnoreCase("t")){
				node = new VariableT();
			}else
			{
				 Variable othrVar = new Variable();
				 othrVar.setVarName(expStr);
				node =  othrVar;
				VarDataBase.otherVarsFlag = true;
				System.out.println(expStr);
				
			}
			
		}
		
		
	return node;

	}
}
