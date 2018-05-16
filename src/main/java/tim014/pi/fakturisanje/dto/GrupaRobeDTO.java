package tim014.pi.fakturisanje.dto;

import java.util.List;

import tim014.pi.fakturisanje.model.GrupaRobe;

public class GrupaRobeDTO {

	private long id;
	private String naziv;
	private List<RobaDTO> robaDTO;
	private long preduzeceID;
	private long pdvID;
	

	public GrupaRobeDTO() {
		
		
	}
	public GrupaRobeDTO(long id, String naziv, List<RobaDTO> robaDTO, long preduzeceID, long pdvID) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.robaDTO = robaDTO;
		this.preduzeceID = preduzeceID;
		this.pdvID = pdvID;
	}
	
	
	public GrupaRobeDTO(GrupaRobe gr) {
		
		this.id=gr.getId();
		this.naziv=gr.getNaziv();
		this.preduzeceID=gr.getPreduzece().getId();
		this.pdvID=gr.getPdv().getId();
		
		
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
	public List<RobaDTO> getRobaDTO() {
		return robaDTO;
	}
	public void setRobaDTO(List<RobaDTO> robaDTO) {
		this.robaDTO = robaDTO;
	}
	public long getPreduzeceID() {
		return preduzeceID;
	}
	public void setPreduzeceID(long preduzeceID) {
		this.preduzeceID = preduzeceID;
	}
	public long getPdvID() {
		return pdvID;
	}
	public void setPdvID(long pdvID) {
		this.pdvID = pdvID;
	}
	
	
	
	
	

}
