package controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import database.AuthorTableGateway;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Author;

public class AuthorListController implements Initializable, MyController {

	private static Logger logger = LogManager.getLogger();
	@FXML private ListView<Author> authorList;
	private ObservableList<Author> authors;
	private AuthorTableGateway gateway;

	public AuthorListController(AuthorTableGateway gateway) {
    	this.gateway = gateway;
    	authors = this.gateway.getAuthors();
    }
	
	public AuthorListController(ObservableList<Author> authors) {
    	this.authors = authors;
    }
	
    @FXML
    void authorListClicked(MouseEvent event) {
    	if(event.getClickCount() > 1) {
    		Author author = authorList.getSelectionModel().getSelectedItem();
   			if(author != null) {
    			AppController.getInstance().changeView(AppController.AUTHOR_DETAIL, author);
        		logger.info(author.getFirstName() + " clicked");
    		}
    	}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.authorList.setItems(authors);
	}

}