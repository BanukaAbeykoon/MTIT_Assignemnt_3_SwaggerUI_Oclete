package BartenderImplService;

import java.util.List;

import Bartender.model.Bartender;
import BartenderService.BartenderService;
import BartenderStore.BartenderStore;

public class BartenderImplService implements BartenderService{

	public int RegisterBartender(String barname, String barId, int noOfliqours, int Capacity) {
		Bartender newBartender = new Bartender(barname,barId,noOfliqours,Capacity);
		BartenderStore.bartenderList.add(newBartender);
		return 1;
	}
	
	@Override
	public List<Bartender> listBartenders(){
		return BartenderStore.bartenderList;
	}
	
	@Override
	public int updateBartender(String barname,String barId, int noofliquors, int Capacity) {
		Bartender bartenderToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Bartender tempBartender : BartenderStore.bartenderList) {
			count ++;
			if(tempBartender.getBarname().equalsIgnoreCase(barname)) {
				bartenderToBeUpdated = tempBartender;
				invalid = false;
				break;
			}
				
		}if(!invalid) {
			bartenderToBeUpdated.setBarname(barname);
			bartenderToBeUpdated.setBarId(barId);
			bartenderToBeUpdated.setNoOfliqours(noofliquors);
			bartenderToBeUpdated.setCapacity(Capacity);
			
			BartenderStore.bartenderList.set(count, bartenderToBeUpdated);
			return 1;
		}else
		{
			return -1;
		}
	}@Override
    public synchronized int removeBartender(String barname) 
    {
    	boolean invalid = true;
    	int count = -1;
    	for (Bartender tempItem :BartenderStore.bartenderList) 
    	{
    		count++;
    	if (tempItem.getBarname().equalsIgnoreCase(barname)) 
    	{
    		invalid = false;
    	    break;
    	 }
    	}
    	if (!invalid)
    	{
    		BartenderStore.bartenderList.remove(count);
    	     return 1;
    	} else 
    	{
    		
    		return -1;
    		}
    	
}
    @Override
    public int searchBartender(String barname) 
    	{
    		boolean valid = false;
    		for (Bartender tempItem : BartenderStore.bartenderList) 
    		{
    			if (tempItem.getBarname().equalsIgnoreCase(barname)) 
    			{
    				valid = true;
    			break;
    			
    			}
    			}
    		if(valid) 
    		{
    			return 1;
    			
    		}
    		else 
    		{
    			return -1;
    		}}
    
}

