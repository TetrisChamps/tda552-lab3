package gui;

import model.Car;
import model.Saab95;
import model.Scania;
import model.Volvo240;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    //BufferedImage volvoImage;
    // To keep track of a single cars position
    //Point volvoPoint = new Point();
    private Map<Object, BufferedImage> carImages = new HashMap<>();
    private Map<Point, BufferedImage> imagePoints = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            carImages.put(Volvo240.class, ImageIO.read(new File("resources\\Volvo240.jpg")));
            carImages.put(Scania.class, ImageIO.read(new File("resources\\Scania.jpg")));
            carImages.put(Saab95.class, ImageIO.read(new File("resources\\Saab95.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    boolean isOutOfBounds(Class c, double x, double y) {
        BufferedImage i = carImages.get(c);
        if (x < 0) {
            return true;
        }
        if (this.getWidth() < x + i.getWidth()) {
            return true;
        }
        //if (y < 0) {
        //    return true;
        //}
        //if (this.getHeight() < y + i.getHeight()) {
        //    return true;
        //}
        return false;
    }

    BufferedImage getImageFromClass(Class c) {
        return carImages.get(c);
    }

    // TODO: Make this genereal for all cars
    void moveit(Class c, int x, int y) {
        imagePoints.put(new Point(x, y), getImageFromClass(c));
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Map.Entry<Point, BufferedImage> entry : imagePoints.entrySet()) {
            Point p = entry.getKey();
            BufferedImage i = entry.getValue();
            g.drawImage(i, p.x, p.y, null);
        }

        imagePoints.clear();
        //carPoints.forEach();
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
    }
}