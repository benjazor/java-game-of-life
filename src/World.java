import java.util.Random;

public class World {
    private Cell[][] data;

    World(int nbColumns, int nbRows){
        Random rand = new Random();

        this.data = new Cell[nbColumns][nbRows];
        for (int i=0; i < nbColumns; i++){
            for (int j=0; j < nbRows; j++){
                data[i][j] = (rand.nextInt(2) == 0) ? new AliveCell() : new DeadCell();
            }
        }
    }

    World(Cell[][] world){
        this.data = world;
    }

    public void newGeneration(){
        Cell[][] nextGen = new Cell[this.data.length][this.data[0].length];
        //  Iterate through the data
        for (int i=0; i < this.data.length; i++){
            for (int j=0; j < this.data[0].length; j++){

                //  Count the number of neighbour
                int nbNeighbours = 0;
                for (int k=0; k < 3; k++){
                    for (int l=0; l < 3; l++){
                        if (i-1+k > 0 && i-1+k < this.data.length && j-1+l > 0 && j-1+l < this.data[0].length && k!=l){
                            nbNeighbours += (this.data[i-1+k][j-1+l].isAlive()) ? 1 : 0;
                        }
                    }
                }
                //  Initialize the next generation data
                nextGen[i][j] = this.data[i][j].newGeneration(nbNeighbours);
            }
        }
        this.data = nextGen;
    }

    public String toString(){
        String result = "";
        for (int i=0; i < this.data.length; i++){
            for (int j=0; j < this.data[0].length; j++){
                result += this.data[i][j].getAsString() + ((j < this.data[0].length - 1) ? " " : "");
            }
            result += "\n";
        }
        return result;
    }
}
