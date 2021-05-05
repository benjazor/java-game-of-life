import java.util.Scanner;

public class Launcher {
    private World world;
    private int generation = 0;

    Launcher(){
        this.generateWorld();
    }

    public void generateWorld(){
        Scanner scan = new Scanner(System.in);

        //  Ask the user for the world size
        System.out.println("Welcome to the game of life!");
        System.out.print("Enter world size: ");
        String worldSize = scan.nextLine();

        try {
            Integer.parseInt(worldSize);
        } catch (NumberFormatException e) {
            System.out.print(e.getStackTrace() + "\n");
            generateWorld();
            return;
        }

        this.world = new World(Math.abs(Integer.parseInt(worldSize)), Math.abs(Integer.parseInt(worldSize)));

        //  Start the game
        this.life2();
    }

    public void nextGeneration(){
        this.world.newGeneration();
        this.generation++;
    }

    public void life(){
        Scanner scan = new Scanner(System.in);
        this.nextGeneration();

        System.out.print("Genration " + this.generation + ":\n" + this.world.toString() + "\nPress x to end or anything else to go to next generation...");
        String tmp = scan.nextLine();

        //  End the game
        if (tmp.equals("x") || tmp.equals("X")){
            System.out.print("Game of life ended at generation " + generation);
        }
        //  Continue the game
        else {
            System.out.print("\n");
            this.life();
        }
    }

    public void life2(){
        Scanner scan = new Scanner(System.in);
        this.nextGeneration();

        if (this.generation < 1000) {

            System.out.print("Genration " + this.generation + ":\n" + this.world.toString());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            life2();
            return;

        } else {
            System.out.print("\nGame of life ended!");
            return;
        }
    }

}
