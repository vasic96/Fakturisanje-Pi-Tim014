package tim014.pi.fakturisanje.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import tim014.pi.fakturisanje.model.StopaPDV;

public class StopaPdvDTO {
	
	private long id;
	private double procenat; 
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date datumVazenja;
	private long pdvID;
	
	
	public StopaPdvDTO() {
		super();
	}


	public StopaPdvDTO(long id, double procenat, Date datumVazenja, long pdvID) {
		super();
		this.id = id;
		this.procenat = procenat;
		this.datumVazenja = datumVazenja;
		this.pdvID = pdvID;
	}
	
	
	public StopaPdvDTO(StopaPDV stopaPDV) {
		this(stopaPDV.getId(),
				stopaPDV.getProcenat(),
				stopaPDV.getDatumVazenja(),
				stopaPDV.getPdv().getId());
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getProcenat() {
		return procenat;
	}


	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}


	public Date getDatumVazenja() {
		return datumVazenja;
	}


	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}


	public long getPdvID() {
		return pdvID;
	}


	public void setPdvID(long pdvID) {
		this.pdvID = pdvID;
	}
	
	
}
