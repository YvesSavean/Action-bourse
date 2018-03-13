package fr.nantes.savean.bourse.model;

public class Data {

	private String date;
	private Double Open;
	private Double High;
	private Double Low;
	private Double Last;
	private Double Volume;
	private Double Turnover;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getOpen() {
		return Open;
	}

	public void setOpen(Double open) {
		Open = open;
	}

	public Double getHigh() {
		return High;
	}

	public void setHigh(Double high) {
		High = high;
	}

	public Double getLow() {
		return Low;
	}

	public void setLow(Double low) {
		Low = low;
	}

	public Double getLast() {
		return Last;
	}

	public void setLast(Double last) {
		Last = last;
	}

	public Double getVolume() {
		return Volume;
	}

	public void setVolume(Double volume) {
		Volume = volume;
	}

	public Double getTurnover() {
		return Turnover;
	}

	public void setTurnover(Double turnover) {
		Turnover = turnover;
	}

}
