package com.MovieCatalog.entities;

public class CatalogOverview {
	
	public CatalogOverview() {
		super();
	}
	public CatalogOverview(String mName, String mDesc, int mRating) {
		super();
		this.mName = mName;
		this.mDesc = mDesc;
		this.mRating = mRating;
	}
	
	
	
	
	String mName;
	String mDesc;
	int mRating;
	
	
	
	
	
	public String getcName() {
		return mName;
	}
	public void setcName(String mName) {
		this.mName = mName;
	}
	public String getcDesc() {
		return mDesc;
	}
	public void setcDesc(String mDesc) {
		this.mDesc = mDesc;
	}
	public int getcRating() {
		return mRating;
	}
	public void setcRating(int mRating) {
		this.mRating = mRating;
	}

}
