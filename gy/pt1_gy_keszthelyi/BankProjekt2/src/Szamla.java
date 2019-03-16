

/**
 * @author 8emi95
 * @version 1.0
 * @created 17-okt.-2017 11:13:15
 */
public class Szamla {

	protected int egyenleg;
	protected int szamlaSzam;

	public Szamla(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param szamlaSzam
	 * @param egyenleg
	 */
	public Szamla(int szamlaSzam, int egyenleg){

	}

	/**
	 * 
	 * @param szamlaSzam
	 */
	public Szamla(int szamlaSzam){

	}
        /**
	 * 
	 * @param szamlaSzam
	 */
	public int getSzamlaSzam(){
            return szamlaSzam;
	}

	public int getEgyenleg(){
		return 0;
	}

	public int betesz(){
		return 0;
	}

	public boolean kivesz(){
		return false;
	}

	public String toString(){
		return "";
	}

	public int van(){
		return 0;
	}
}//end Szamla