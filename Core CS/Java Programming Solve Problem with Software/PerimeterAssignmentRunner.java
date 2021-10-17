import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count_points = 0;
        for (Point currPt : s.getPoints()) {
            count_points = count_points + 1;
        }
        return count_points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double average = getPerimeter(s) / getNumPoints(s);
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largest) {
                largest = currDist;
            }
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        for (Point currPt : s.getPoints()) {
            double currentX = currPt.getX();
            if (currentX > largestX) {
                largestX = currentX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largest = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter_s = getPerimeter(s);
            if ( largest < perimeter_s ){
                largest = perimeter_s;
            }
        }
        return largest;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largest = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter_s = getPerimeter(s);
            if ( largest < perimeter_s ){
                largest = perimeter_s;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        // tell numbers points
        int num_points = getNumPoints(s);
        System.out.println("Number of Points = " + num_points);
        // tell average side
        double average = getAverageLength(s);
        System.out.println("Average of Lengh = " + average);
        //tell Largest Side
        double largest_side = getLargestSide(s);
        System.out.println("Largest Side = " + largest_side);
        //tell Largest X
        double largest_x = getLargestX(s);
        System.out.println("Largest X = " + largest_x);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest_perimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + largest_perimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largest_perimeter_file = getFileWithLargestPerimeter();
        System.out.println("File with Largest Perimeter = " + largest_perimeter_file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
