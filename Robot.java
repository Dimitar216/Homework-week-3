import java.util.Scanner;
public class Robot {
    public static void main(String[] args) {
        battleSys();
            int hitsDone = 0;
            do{
                if (hitsDone < 4){
                    System.out.println("Attack commencing!");
                    int hitChance = (int) Math.round(Math.random() * 10);
                    if (hitChance == 5) {
                        System.out.println("The strike will harm the furniture");
                        battleSys();
                    } else {
                        System.out.println("Target terminated");
                        robotTalks();
                        ++hitsDone;
                        batteryCheck(hitsDone);
                        System.out.println(hitsDone);
                        battleSys();
                    }
                } else if (hitsDone == 4){
                    System.out.println("No more battery remains please charge");
                    outlet();
                    hitsDone=hitsDone-4;
                }
            }while(hitsDone <=4);
        }

    public static void objectInput() {
        String object;
        Scanner objectConsole = new Scanner(System.in);
        System.out.println("What is in front of the robot?(Chair/Wall/Nothing)");
        object = objectConsole.nextLine();
        if (object.equals("Chair")) {
            System.out.println("Jump");
        } else if (object.equals("Wall")) {
            System.out.println("Go sideways");
        } else if (object.equals("Nothing")) {
            System.out.println("Continue");
        } else System.out.println("Invalid object");
    }

    public static void battleSys() {
        objectInput();
        Scanner pixelInput = new Scanner(System.in);
        System.out.println("Insert the number of pixels ");
        int pixel = pixelInput.nextInt();
        if (pixel % 2 == 0) {
            System.out.println("Mouse has been found");
        } else {
            System.out.println("No mouse found");
            battleSys();
        }
    }
    public static void outlet(){
        int chargeRoll1 = (int)Math.round(Math.random() * 1000);
        int chargeRoll2 = (int)Math.round(Math.random() * 1000);
        System.out.println(chargeRoll1);
        System.out.println(chargeRoll2);
        if(chargeRoll1>chargeRoll2){
            System.out.println("Charge is available");
            battleSys();
        } else if (chargeRoll1 == chargeRoll2){
            System.out.println("Repeat");
            outlet();
        } else {
            System.out.println("No charge available");
            System.out.println("Locating another outlet...");
            outlet();
        }
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
            case 4:
                System.out.println("No battery remains");
                break;
        }
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