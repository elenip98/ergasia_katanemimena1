package gr.hua.katanemimena.dao;

import java.util.List;

import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.forms.StathmoiForm;

public interface StathmoiDAO {

	public List<Stathmoi> getStathmoi();
	
	public Stathmoi getStathmoByID(int id);
	
	public Stathmoi createStathmo(StathmoiForm stathmosForm);
	
	public Stathmoi changeEnabled(int id, Boolean temp);
	
	public List<Stathmoi> getEnabledStathmoi(Boolean enabled);
	
	public List<Stathmoi> findStathmo(String name);
	
	public Stathmoi getStathmoByDiaxID(int id);
	
	public Stathmoi updateStathmo(Stathmoi stathmos);
	
	public List<Stathmoi> getStathmoiByName(String name);
}
