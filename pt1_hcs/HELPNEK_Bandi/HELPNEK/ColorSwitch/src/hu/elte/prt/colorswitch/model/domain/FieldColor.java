package hu.elte.prt.colorswitch.model.domain;

public enum FieldColor {
    RED, YELLOW, BLUE;

    public FieldColor succ() {
	switch (this) {
	case RED:
	    return YELLOW;
	case YELLOW:
	    return BLUE;
	case BLUE:
	    return RED;
	default:
	    return null;
	}
    }
}