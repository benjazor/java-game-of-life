public class AliveCell implements Cell {

    private boolean isNewBorn = true;

    //  Return the next generation cell depending on the number of neighbours
    public Cell newGeneration(int nbNeighbours) {
        if (nbNeighbours == 2 || nbNeighbours == 3){
            this.isNewBorn = false;
            return this;
        } else {
            return new DeadCell();
        }
    }

    //  Return a String representation of the cell state
    public String getAsString(){
        return (this.isNewBorn) ? "0" : "+";
    }

    //  Return if the cell is alive or not
    public boolean isAlive(){
        return true;
    }
}
