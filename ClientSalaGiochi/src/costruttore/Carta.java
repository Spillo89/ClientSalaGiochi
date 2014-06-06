package costruttore;

public class Carta {

	Integer Val=null;
	String Seme=null;

	public Carta (Integer val, String seme){
		this.Val = val;
		this.Seme = seme;
	}

	public Integer getVal() {
		return Val;
	}

	public void setVal(Integer val) {
		Val = val;
	}

	public String getSeme() {
		return Seme;
	}

	public void setSeme(String seme) {
		Seme = seme;
	}
	
	
	
}
