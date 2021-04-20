package ro.ase.csie.cts.g1094.dp.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Model3dFlyweight implements ModelFlyweightActions {

	String name;
	
	
	public Model3dFlyweight(String name) {
		super();
		this.name = name;
	}

	public Model3dFlyweight(String name, List<Double> modelPoints) {
		super();
		this.name = name;
		this.modelPoints = modelPoints;
	}

	//3D Model Data
	List<Double> modelPoints = new ArrayList<>();

	@Override
	public void loadModel() {
		
		
	}

	@Override
	public void display(ScreenData data) {
		System.out.println(String.format("Printing %s at coordinates (%f, %f, %f)",
				name, data.x, data.y, data.z));
		
	}
	
}
