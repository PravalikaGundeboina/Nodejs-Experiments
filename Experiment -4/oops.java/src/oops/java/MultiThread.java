package oops.java;

import java.util.Random;
class NumberGenerator extends Thread {
 Random rand = new Random();
 public void run() {
	 for (int i = 0; i < 10; i++) { 
         int num = rand.nextInt(100); 
         System.out.println("\nGenerated Number: " + num);
         if (num % 2 == 0) {
            SquareThread sq = new SquareThread(num);
             sq.start();
         } else {
             CubeThread cb = new CubeThread(num);
             cb.start();
         }
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }  }  }  }
class SquareThread extends Thread {
 int num;
 SquareThread(int num) {
     this.num = num;
 }
 public void run() {
     int square = num * num;
     System.out.println("Square of " + num + " = " + square);
 }}
class CubeThread extends Thread {
 int num;
 CubeThread(int num) {
     this.num = num;
 }
 public void run() {
    int cube = num * num * num;
     System.out.println("Cube of " + num + " = " + cube);
 }}
public class MultiThread {
 public static void main(String[] args) {
     NumberGenerator generator = new NumberGenerator();
     generator.start();  
 }}
