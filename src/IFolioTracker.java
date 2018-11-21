public interface IFolioTracker {

	public boolean createFolio(String name);
	
	public Folio openFolio(String name);
	
	public boolean saveFolio(String name);
	
	public boolean deleteFolio(String name);
}
