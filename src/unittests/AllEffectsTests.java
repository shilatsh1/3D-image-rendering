/**
 * 
 */
package unittests;



import org.junit.jupiter.api.Test;


import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.SpotLight;
import primitives.Color;
import primitives.Double3;
import primitives.Material;
import primitives.Point;
import primitives.Vector;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import scene.Scene;

/**
 * @author shilat and Avigail
 *
 */
class AllEffectsTests {

	private Scene scene = new Scene("Test scene");

	@Test
	public void OurPicture() {
		try {
		Camera camera = new Camera(new Point(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0));
		camera.setVPDistance(1000).setVPSize(200,200);
		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), new Double3(0.15)));
		scene.geometries.add( //
				 //
				new Sphere(new Point(25, -30, 100),30).setEmission(new Color(255,51,153))
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(20).setKt(0).setKr(0)), 
				new Triangle(new Point(-45, -20, 100), new Point(45, -20,100), new Point(0, 115, 150))
				.setEmission(new Color(153,76,0)).setMaterial(new Material().setKd(0).setKs(0.8).setShininess(6)),
				new Sphere(new Point(-25, -30, 100),30).setEmission(new Color(java.awt.Color.BLACK))
                .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(30)), 
				new Sphere(new Point(0, -70, 100),30).setEmission(new Color(255,153,51))
				.setMaterial(new Material().setKd(0.2).setKs(0.4).setShininess(30).setKt(0).setKr(0))
				);
		scene.lights.add(new SpotLight(new Color(700, 400, 400),new Point(40,-40,-160), new Vector(-1, 1, 4))
				.setKc(1).setKl(4E-4).setKq(2E-5));
		scene.lights.add(new SpotLight(new Color(700, 400, 400),new Point(300, 30,0), new Vector(-2, 3, 3))
				.setKc(1).setKl(4E-4).setKq(2E-5));
		camera.setImageWriter(new ImageWriter("iceCream", 600, 600)) 
		.setRayTracer(new RayTracerBasic(scene)); 
camera.renderImage(); //
camera.writeToImage();
}
	catch(Exception ex) {}
		
	}

}
