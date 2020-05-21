package com.spring.CRUD.Crud.model;

public class Hello {

	private String title;
    private String value;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
    
	public Hello(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public Hello() {
    }
    
}
