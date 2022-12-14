/**
 * 
 */
package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import primitives.Point;
import primitives.Ray;

/**
 * @author shilat and avigail
 * Geometries interface
 */
public class Geometries extends Intersectable {
	
	private List<Intersectable> sceneGeometries;
	
	
	/**
	 * ctor
	 */
	public Geometries() {
		super();
		//we chosen in ArrayList because this class works better when the application demands storing the data and accessing it.
		sceneGeometries = new ArrayList<Intersectable>();
	}

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		List<GeoPoint> temp = new ArrayList<GeoPoint>();
		for (Intersectable intersectable : sceneGeometries) 
		{
			List<GeoPoint> intersection = intersectable.findGeoIntersections(ray);
			if (intersection != null)
				temp.addAll(intersection); 
		}
		
		if (temp.isEmpty())
			return null;
		return temp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sceneGeometries);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometries other = (Geometries) obj;
		return Objects.equals(sceneGeometries, other.sceneGeometries);
	}
	
	/**
	 * parameters ctor
	 * @param geometries types of geometries in the scene
	 */
	public Geometries(Intersectable... geometries){
		sceneGeometries =  new ArrayList<Intersectable>(Arrays.asList(geometries));
	}
	
	/**
	 * a function that returns an iterator to the geometries
	 * @return an iterator
	 */
	public Iterator<Intersectable> iterator(){
		return sceneGeometries.iterator();
	}
	
	/**
	 * a function that adds a new geometry to the scene
	 * @param geometries
	 */
	public void add(Intersectable... geometries){
		if (geometries != null)
		{
			sceneGeometries.addAll(Arrays.asList(geometries));
		}
	
	}
	
	/**
	 * a function that returns the geometries
	 * @return scene geometries
	 */
	public List<Intersectable> getSceneGeometries() {
		return sceneGeometries;
	}

}
