public class DeadCell implements Cell {

    //  Return the next generation cell depending on the number of neighbours
    public Cell newGeneration(int nbNeighbours) {
        return (nbNeighbours == 3) ? new AliveCell() : this;
    }

    //  Return a String representation of the cell state
    public String getAsString(){
        return "-";
    }

    //  Return if the cell is alive or not
    public boolean isAlive(){
        return false;
    }
}
