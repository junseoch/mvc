package com.app;

public class Result {

//	어떻게
	private boolean isRedirect;
//	어디로
	private String path;
	
	public Result() {;}

	public Result(boolean isRedirect, String path) {
		this.isRedirect = isRedirect;
		this.path = path;
	}
	

	boolean isRedirect() {
		return isRedirect;
	}

	void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	String getPath() {
		return path;
	}

	void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Result [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
	
	
	
	
}
