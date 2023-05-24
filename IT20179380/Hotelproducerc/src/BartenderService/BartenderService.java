package BartenderService;

import java.util.List;


import Bartender.model.Bartender;

public interface BartenderService {
	public int RegisterBartender(String barname, String barId, int noOfliqours, int Capacity);
	public List<Bartender> listBartenders();
	public int updateBartender(String barname, String barId, int noOfliquors, int Capacity);
	public int removeBartender(String barname);
	public int searchBartender(String barname);
}
