import java.util.*;
public class Pit {
  private ArrayList<Bead> beads; //the collection of beads that is in the pit
  
  public Pit (int count, boolean isSpecial) {//initializing the Pit to whatever position pitNum shows
    beads = new ArrayList<>();
    for (int i = 0; i < count; i++) {
       beads.add(new Bead(isSpecial && i == 0));
   } 
  }  

  public int count(){
    return beads.size();
  }

  public ArrayList<Bead> removeAllBeads() { //removing beads in a pit and returning them
    ArrayList<Bead> removed = new ArrayList<>(beads);
    beads.clear();
    return removed;
  }

  public void addBead(Bead bead) { //adding bead to pit
   beads.add(bead);
  }

  public boolean hasSpecialBead() { //seeing if a special bead is present
    for (Bead bead : beads) {
      if (bead.isSpecial())
        return true;
    }
      return false;
  }

  public void clear() {
    beads.clear();
  }

  public void addBeads(int count) { //adding beads to pit
    for (int i = 0; i < count; i++) {
      beads.add(new Bead(false));
    }
  }

  public Pit copy() {
    Pit newPit = new Pit(0, false); //making a new pit with no special beads
    for (Bead bead : beads) { 
      newPit.addBead(new Bead(bead.isSpecial())); //add beads to copy
    }
    return newPit;
  }
}
