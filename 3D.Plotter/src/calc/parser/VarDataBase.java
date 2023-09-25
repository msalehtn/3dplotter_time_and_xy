package calc.parser;

import java.util.ArrayList;

public class VarDataBase {
private static double x;
private static double c;
private static double t;
private static ArrayList<String> varNames;
public static boolean otherVarsFlag = false;

public static ArrayList<String> getVarNames() {
	return varNames;
}
public static void setVarNames(ArrayList<String> varNames) {
	VarDataBase.varNames = varNames;
}
public static ArrayList<Double> getVarValues() {
	return varValues;
}
public static void setVarValues(ArrayList<Double> varValues) {
	VarDataBase.varValues = varValues;
}
public static ArrayList<Double> varValues;

/**
 * @return the x
 */
public static double getX() {
	return x;
}
/**
 * @param x the x to set
 */
public static void setX(double x) {
	VarDataBase.x = x;
}
/**
 * @return the c
 */
public static double getC() {
	return c;
}
/**
 * @param c the c to set
 */
public static void setC(double c) {
	VarDataBase.c = c;
}
/**
 * @return the t
 */
public static double getT() {
	return t;
}
/**
 * @param t the t to set
 */
public static void setT(double t) {
	VarDataBase.t = t;
}



}
