
package fcw;

/**
 *
 * @author Naza Zuhair
 */
public class FCW {

    public static void main(String[] args) throws InterruptedException {
	//Starts the car and vehicle threads.
        System.out.println("Car is running on highway. ");
        Thread t1 = new Thread(new vehicles());
        t1.start();
        t1.join();
        System.out.println("Program has exited. ");
    }
}

class vehicles implements  Runnable{
    public volatile boolean exit= false;
    @Override
    public void run() {
        while(!exit) {
            int collision = (int) (Math.random() *100);
            int driverBraked = (int) (Math.random() *100);
            if (collision >90) {
                System.out.println("Obstacle detected");
                System.out.println("Driver is warned about vehicle");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (driverBraked > 30){
                    System.out.println("Driver has Appled brakes.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Obstacle evaded. ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Car has started running again. ");
                }
                else{
                    System.out.println("Driver failed to apply brakes in time. ");
                    System.out.println("Autonomous emergency Braking inititated. ");
                    System.out.println("Car has stopped.");
                    stop();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            else{
                System.out.println("Car is running. ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void stop(){
        exit = true;

    }
}
