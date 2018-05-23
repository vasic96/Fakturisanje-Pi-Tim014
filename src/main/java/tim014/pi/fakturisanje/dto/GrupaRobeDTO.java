package tim014.pi.fakturisanje.dto;

import tim014.pi.fakturisanje.model.GrupaRobe;

public class GrupaRobeDTO {

	private long id;
	private String naziv;
	private long preduzeceId;
	private long pdvId;
	

	public GrupaRobeDTO() {
		
		
	}
	public GrupaRobeDTO(long id, String naziv, long preduzeceId, long pdvId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.preduzeceId = preduzeceId;
		this.pdvId = pdvId;
	}
	
	
	public GrupaRobeDTO(GrupaRobe grupaRobe) {
		
		this.id=grupaRobe.getId();
		this.naziv=grupaRobe.getNaziv();
		this.preduzeceId=grupaRobe.getPreduzece().getId();
		this.pdvId=grupaRobe.getPdv().getId();
		
		
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
	public long getPreduzeceId() {
		return preduzeceId;
	}
	public void setPreduzeceId(long preduzeceId) {
		this.preduzeceId = preduzeceId;
	}
	public long getPdvId() {
		return pdvId;
	}
	public void setPdvId(long pdvId) {
		this.pdvId = pdvId;
	}
	
	
	
	
	

}
