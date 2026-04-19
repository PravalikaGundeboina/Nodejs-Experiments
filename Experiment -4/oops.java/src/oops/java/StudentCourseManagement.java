package oops.java;
import java.util.Scanner;
public class StudentCourseManagement {
    static class Course {
        private int id;
        private String name;
        private double price;
        public Course(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public void setId(int id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setPrice(double price) { this.price = price; }
    }
    interface StudentCourse {
        void addCourse(Course course) throws Exception;
        Course[] viewCourses() throws Exception;
        double addFee(double fee) throws Exception;
    }
    static class Semester implements StudentCourse {
        private Course[] courses = new Course[5]; 
        private int count = 0;
        public void addCourse(Course course) throws Exception {
            if (count >= courses.length) {
                throw new Exception("Course limit reached.");
            }
            courses[count++] = course;
        }
        public Course[] viewCourses() throws Exception {
            if (count == 0) {
                throw new Exception("No courses available.");
            }
            return courses;
        }
        public double addFee(double fee) throws Exception {
            if (fee < 1000 || fee > 3000) {
                throw new Exception("Fee must be between 1000 and 3000.");
            }
            if (fee > 1500) {
                return fee - (fee * 0.10); 
            }
            return fee;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Semester semester = new Semester();
        try {
            System.out.print("How many courses do you want to add (max 5)? ");
            int numCourses = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < numCourses; i++) {
                System.out.println("\nEnter details for Course " + (i + 1));
                System.out.print("Course ID: ");
                int id = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Course Name: ");
                String name = sc.nextLine();
                System.out.print("Course Fee: ");
                double price = sc.nextDouble();
                sc.nextLine(); 
                Course course = new Course(id, name, price);
                semester.addCourse(course);
            }
            System.out.println("\n COURSE SUMMARY");
            Course[] allCourses = semester.viewCourses();
            for (Course c : allCourses) {
                if (c != null) {
                    double finalFee = semester.addFee(c.getPrice());
                    System.out.println("Course: " + c.getName() + ", Final Fee: " + finalFee);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
        	sc.close();
        }
     }
 }

