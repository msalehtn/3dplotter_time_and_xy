package calc.gui;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
public class OptionDB implements Serializable {

	public String getxMin() {
		return xMin;
	}
	public void setxMin(String xMin) {
		this.xMin = xMin;
	}
	public String getxMax() {
		return xMax;
	}
	public void setxMax(String xMax) {
		this.xMax = xMax;
	}
	public String gettMin() {
		return tMin;
	}
	public void settMin(String tMin) {
		this.tMin = tMin;
	}
	public String gettMax() {
		return tMax;
	}
	public void settMax(String tMax) {
		this.tMax = tMax;
	}
	public String getyMin() {
		return yMin;
	}
	public void setyMin(String yMin) {
		this.yMin = yMin;
	}
	public String getyMax() {
		return yMax;
	}
	public void setyMax(String yMax) {
		this.yMax = yMax;
	}
	public String getxStep() {
		return xStep;
	}
	public void setxStep(String xStep) {
		this.xStep = xStep;
	}
	public String gettStep() {
		return tStep;
	}
	public void settStep(String tStep) {
		this.tStep = tStep;
	}
	public String gettStepTime() {
		return tStepTime;
	}
	public void settStepTime(String tStepTime) {
		this.tStepTime = tStepTime;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public HashMap<Double, Color> getColors() {
		return colors;
	}
	public void setColors(HashMap<Double, Color> colors) {
		this.colors = colors;
	}
	public ArrayList<String> getJlistData() {
		return JlistData;
	}
	public void setJlistData(ArrayList<String> jlistData) {
		JlistData = jlistData;
	}
	private String xMin;
	private String xMax;
	private String tMin;
	private String tMax;
	private String yMin;
	private String yMax;
	private String xStep;
	private String tStep;
	private String tStepTime;
	private String expression;
	HashMap<Double,Color> colors;
	ArrayList<String> JlistData;
}
