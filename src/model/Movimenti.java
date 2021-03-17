package model;
import java.util.Date;

public class Movimenti {
	private int idMovimenti, codCausale, codAzienda;
	private Date data;
	private String descrizione;
	private double importo;
	
	public Movimenti(int idMovimenti, Date data, String descrizione, double importo,int codCausale, int codAzienda) {
		this.idMovimenti = idMovimenti;
		this.codCausale = codCausale;
		this.codAzienda = codAzienda;
		this.data = data;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public int getIdMovimenti() {
		return idMovimenti;
	}

	public int getCodCausale() {
		return codCausale;
	}

	public int getCodAzienda() {
		return codAzienda;
	}

	public Date getData() {
		return data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getImporto() {
		return importo;
	}

	public void setIdMovimenti(int idMovimenti) {
		this.idMovimenti = idMovimenti;
	}

	public void setCodCausale(int codCausale) {
		this.codCausale = codCausale;
	}

	public void setCodAzienda(int codAzienda) {
		this.codAzienda = codAzienda;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	

}
