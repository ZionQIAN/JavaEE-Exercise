package fit5042.assignment.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "titleController")
@RequestScoped
public class TitleController {
	
	private String pageTitle;
	
	public TitleController() 
	{
		pageTitle = "Aus Printer Company";
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	
}
