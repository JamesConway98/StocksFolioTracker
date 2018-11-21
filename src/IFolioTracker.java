
public interface IFolioTracker {

	public Boolean createFolio(String name);
	
	public Folio openFolio(String name);
	
	public Boolean saveFolio(String name);
	
	public Boolean deleteFolio(String name);
}
