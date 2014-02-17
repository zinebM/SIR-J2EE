
public class donnees {

	
	private static int compteurSession=0;
	private static int nbrequette=0;
	private static int id;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		donnees.id = id;
	}
	public static int getCompteurSession() {
		return compteurSession;
	}
	public static void setCompteurSession(int compteurSession) {
		donnees.compteurSession = compteurSession;
	}
	public static int getNbrequette() {
		return nbrequette;
	}
	public static void setNbrequette(int nbrequette) {
		donnees.nbrequette = nbrequette;
	}
}
