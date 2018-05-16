package tim014.pi.fakturisanje.dto;

import java.util.List;

import tim014.pi.fakturisanje.model.Roba;

public class RobaDTO {

	
	private long id;
	private String naziv;
	private long jedinicaMereID;
	private long grupaRobeID;
	public RobaDTO() {
		super();
	}
	public RobaDTO(long id, String naziv, long jedinicaMereID,
			long grupaRobeID) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.jedinicaMereID = jedinicaMereID;
		this.grupaRobeID = grupaRobeID;
	}
	
	public RobaDTO(Roba roba) {
		
		this.id= roba.getId();
		this.naziv=roba.getNaziv();
		this.jedinicaMereID=roba.getJedinicaMere().getId();
		this.grupaRobeID=roba.getGrupaRobe().getId();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public long getJedinicaMereID() {
		return jedinicaMereID;
	}
	public void setJedinicaMereID(long jedinicaMereID) {
		this.jedinicaMereID = jedinicaMereID;
	}
	public long getGrupaRobeID() {
		return grupaRobeID;
	}
	public void setGrupaRobeID(long grupaRobeID) {
		this.grupaRobeID = grupaRobeID;
	}
	
	
	
	
}
