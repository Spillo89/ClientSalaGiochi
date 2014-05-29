package costruttore;

public class VincitaTombola {

	private static Integer Vincita=null;
	private static String TipodiVincita=null;
	private static Integer SchedadaBloccare=null;
	private static Integer LineadaBloccare=null;
	
	public void risultatoslot(Integer vincita,String tipodivincita, Integer schedadabloccare, Integer lineadabloccare) {
		this.Vincita=vincita;
		this.TipodiVincita=tipodivincita;
		this.SchedadaBloccare=schedadabloccare;
		this.LineadaBloccare=lineadabloccare;
	}

	public static Integer getVincita() {
		return Vincita;
	}

	public static void setVincita(Integer vincita) {
		Vincita = vincita;
	}

	public static String getTipodiVincita() {
		return TipodiVincita;
	}

	public static void setTipodiVincita(String tipodiVincita) {
		TipodiVincita = tipodiVincita;
	}

	public static Integer getSchedadaBloccare() {
		return SchedadaBloccare;
	}

	public static void setSchedadaBloccare(Integer schedadaBloccare) {
		SchedadaBloccare = schedadaBloccare;
	}

	public static Integer getLineadaBloccare() {
		return LineadaBloccare;
	}

	public static void setLineadaBloccare(Integer lineadaBloccare) {
		LineadaBloccare = lineadaBloccare;
	}
	
	
}
