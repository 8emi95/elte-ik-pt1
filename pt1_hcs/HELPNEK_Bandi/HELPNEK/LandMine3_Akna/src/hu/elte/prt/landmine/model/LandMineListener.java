package hu.elte.prt.landmine.model;

public interface LandMineListener {

    void updateFields();

    void end(boolean outcome);

}
