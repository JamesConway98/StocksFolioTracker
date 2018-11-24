import javafx.scene.input.MouseEvent;

public interface IController {

    void buttonBuyStockClick(MouseEvent e);

    void buttonSellStockClick(MouseEvent e);

    void buttonCreateFolioClick(MouseEvent e);

    void buttonEditFolioClick(MouseEvent e);

    void buttonDeleteFolioClick(MouseEvent e);

    void buttonOpenFolioClick(MouseEvent e);

    void buttonSaveFolioClick(MouseEvent e);

    void buttonSellNowClick(MouseEvent e);

    void buttonBuyNowClick(MouseEvent e);

}
