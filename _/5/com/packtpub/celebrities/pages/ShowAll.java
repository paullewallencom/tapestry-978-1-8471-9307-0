package com.packtpub.celebrities.pages;

import java.text.Format;
import java.util.List;

import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.grid.GridDataSource;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.CelebritySource;
import com.packtpub.celebrities.util.Formats;

public class ShowAll {
	@ApplicationState
    private User user;
    private boolean userExists;
    
    @ApplicationState
    private IDataSource dataSource;
    
    @InjectPage
    private Details detailsPage; 
    
    private Celebrity celebrity; 
   
    String onActivate() {
        if (!userExists) return "Start";
        return null;
    }
    
    /*@OnEvent(component="detailsLink")
    Object onShowDetails(long id) {
        Celebrity celebrity = 
				dataSource.getCelebrityById(id);
        detailsPage.setCelebrity(celebrity);
        return detailsPage;
    }*/
    
    public GridDataSource getCelebritySource() {
    	return new CelebritySource(dataSource);
    }
    
    public List<Celebrity> getAllCelebrities() {
    	System.out.println("Getting all celebrities...");
        return dataSource.getAllCelebrities();
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }
    public Format getDateFormat() {
        return Formats.getDateFormat();
    }
}
