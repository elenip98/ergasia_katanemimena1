package gr.hua.katanemimena.forms;

import javax.persistence.Column;
import javax.validation.Valid;

import gr.hua.katanemimena.entity.Stathmoi;


public class StathmoiForm {

	@Valid
	private Stathmoi stathmos;
	
	@Column
	private int diefthidisID;

	public StathmoiForm() {}
	
	public StathmoiForm(Stathmoi stathmos, int diefthidisID) {
		super();
		this.stathmos = stathmos;
		this.diefthidisID = diefthidisID;
	}

	public Stathmoi getStathmos() {
		return stathmos;
	}

	public void setStathmos(Stathmoi stathmos) {
		this.stathmos = stathmos;
	}

	public int getDiefthidisID() {
		return diefthidisID;
	}

	public void setDiefthidisID(int diefthidisID) {
		this.diefthidisID = diefthidisID;
	}
	
	
	
	
}
