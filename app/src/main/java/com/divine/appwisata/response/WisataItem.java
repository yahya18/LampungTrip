package com.divine.appwisata.response;


import com.google.gson.annotations.SerializedName;


public class WisataItem {

	@SerializedName("isi_keterangan")
	private String isiKeterangan;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_tempat")
	private String namaTempat;

	@SerializedName("sub_nama")
	private String subNama;

	public void setIsiKeterangan(String isiKeterangan){
		this.isiKeterangan = isiKeterangan;
	}

	public String getIsiKeterangan(){
		return isiKeterangan;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNamaTempat(String namaTempat){
		this.namaTempat = namaTempat;
	}

	public String getNamaTempat(){
		return namaTempat;
	}

	public void setSubNama(String subNama){
		this.subNama = subNama;
	}

	public String getSubNama(){
		return subNama;
	}

	@Override
 	public String toString(){
		return 
			"WisataItem{" + 
			"isi_keterangan = '" + isiKeterangan + '\'' + 
			",foto = '" + foto + '\'' + 
			",id = '" + id + '\'' + 
			",nama_tempat = '" + namaTempat + '\'' + 
			",sub_nama = '" + subNama + '\'' + 
			"}";
		}
}