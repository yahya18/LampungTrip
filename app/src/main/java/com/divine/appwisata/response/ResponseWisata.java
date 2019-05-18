package com.divine.appwisata.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseWisata {

	@SerializedName("wisata")
	private List<WisataItem> wisata;

	@SerializedName("status")
	private boolean status;

	public void setWisata(List<WisataItem> wisata){
		this.wisata = wisata;
	}

	public List<WisataItem> getWisata(){
		return wisata;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseWisata{" + 
			"wisata = '" + wisata + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}