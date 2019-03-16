package hu.elte.prt.landmine.model.domain;

public class Field {

    private boolean playerHere;
    private boolean visited;
    private boolean landMine;

    public Field(boolean playerHere, boolean landMine) {
	this.playerHere = playerHere;
	this.visited = playerHere;
	this.landMine = landMine;
    }

    public boolean isPlayerHere() {
	return playerHere;
    }

    public boolean isVisited() {
	return visited;
    }

    public void visit() {
	playerHere = true;
	visited = true;
    }

    public void leave() {
	playerHere = false;
    }

    public boolean hasMine() {
	return landMine;
    }

    public void forgetIsVisited() {
	visited = false;
    }

}
