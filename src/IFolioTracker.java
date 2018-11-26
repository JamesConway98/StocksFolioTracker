public interface IFolioTracker {

    boolean createFolio(String name);

    Folio openFolio(String name);

    boolean saveFolio(String name);

    boolean deleteFolio(String name);

    Folio getFolio(String name);
}
