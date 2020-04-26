package com.robot;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Robot {
    public static void main(String[] args) {
        battleSystem();
    }
    public static void objectDetection(){
        Scanner objectInput = new Scanner(System.in);
        System.out.println("What is in front of you? ");
        String object = objectInput.nextLine();
        switch (object) {
            case "Chair":
                System.out.println("Jump");
                break;
            case "Wall":
                System.out.println("Go sideways");
                break;
            case "Nothing":
                System.out.println("Foward");
                break;
            default:
                System.out.println("Insert an object");
        }
    }
    public static void battleSystem(){
        int hitsDone = 0, pixel;
        String Continue;
       do{
           objectDetection();
        Scanner pixelInput = new Scanner(System.in);
        System.out.println("Insert the number of pixels ");
        pixel = pixelInput.nextInt();
        if( pixel % 2 == 0){
            System.out.println("Target acquired ");
            batteryCheck(hitsDone);
            if(hitsDone <4) {
                int Strike = ThreadLocalRandom.current().nextInt(0, 10);
                if (Strike == 5) {
                    System.out.println("Can't successfully hit without damaging the furniture ");
                } else {
                    System.out.println("Mouse has been terminated");
                    hitsDone++;
                    batteryRemainingCheck(hitsDone);
                    robotTalks();
                }
            }else {
                System.out.println("No battery");
                chargingOutlet();
            }

        }
        else System.out.println("No mouse found");
        System.out.println("Should I continue searching?");
        Scanner input = new Scanner(System.in);
        Continue = input.nextLine();
       } while (0 != pixel % 2 || hitsDone < 4 || Continue == "Yes");
    }
    public static void batteryCheck(int batteryLevel ){
        switch (batteryLevel){
            case 0:
                System.out.println("Battery for 4 strikes remaining");
                break;
            case 1:
                System.out.println("Battery for 3 strikes remaining");
                break;
            case 2:
                System.out.println("Battery for 2 strikes remaining");
                break;
            case 3:
                System.out.println("Battery for 1 strikes remaining");
                break;
            default:
                System.out.println("No battery remains");
                break;
        }
    }
    public static void batteryRemainingCheck(int remainingBattery){
        switch (remainingBattery){
            case 0:
                System.out.println("Battery for 4 strikes remaining");
                break;
            case 1:
                System.out.println("Battery for 3 strikes remaining");
                break;
            case 2:
                System.out.println("Battery for 2 strikes remaining");
                break;
            case 3:
                System.out.println("Battery for 1 strikes remaining");
                break;
            default:
                System.out.println("No battery remains");
                break;
    }
}
    public static void chargingOutlet(){
        int chargeValue1;
        int chargeValue2;
        do {
            chargeValue1 = ThreadLocalRandom.current().nextInt(0, 1000);
            chargeValue2 = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println(chargeValue1+ " "+ chargeValue2);
            if (chargeValue1 > chargeValue2) {
                System.out.println("Charge is available");
            }
            else if(chargeValue1==chargeValue2){
                System.out.println("Try another outlet");
            }
            else System.out.println("No charge is available");
        }while (chargeValue1==chargeValue2);
    }
    public static void robotTalks(){
        int robotCount = 10;
        while(robotCount > 0){
            if(robotCount % 2 == 0){
                System.out.println("I am a Robottttt "+ robotCount);
            }
            robotCount--;
        }
    }
}