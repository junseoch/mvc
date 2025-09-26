package com.app;

// 어떤 페이지로 어떻게 이동할지에 대한 정보가 담겨있음
public class Result {
	//Result를 강제로 리턴하게 만들어야 함 	 	
//	어떻게
	private boolean isRedirect;
//	어디로
	private String path;
	
	public Result() {;}
	public Result(boolean isRedirect, String path) {
		this.isRedirect = isRedirect;
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "Result [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}

