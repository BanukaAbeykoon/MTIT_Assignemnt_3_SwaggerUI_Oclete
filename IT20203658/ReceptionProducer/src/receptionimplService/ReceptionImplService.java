package receptionimplService;

import java.util.List;



import receptionModel.Reception;
import receptionService.ReceptionService;
import receptionStore.ReceptionStore;

public class ReceptionImplService implements ReceptionService{
	
	@Override
	public int RegisterReception (String roomName, int ageGroup,int roomId, int roomCapacity) {
     Reception newReception = new Reception(roomName , ageGroup , roomId , roomCapacity);
     ReceptionStore.receptionList.add(newReception);
		return 1;
	}
	
	@Override
	public List<Reception> listReception(){
		return ReceptionStore.receptionList;
	}

	@Override
    public int updateReception(String roomName, int ageGroup, int roomId, int roomCapacity) {
		Reception receptionToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Reception tempReception : ReceptionStore.receptionList) {
			count++;
			if (tempReception.getRoomName().equalsIgnoreCase(roomName)) {
				
				receptionToBeUpdated = tempReception;
			       invalid = false;
				   break;
				}
			
			}
		    if (!invalid) {
				
			receptionToBeUpdated.setRoomName(roomName);
			receptionToBeUpdated.setAgeGroup(ageGroup);
			receptionToBeUpdated.setRoomId(roomId);
			receptionToBeUpdated.setRoomCapacity(roomCapacity);
			
			ReceptionStore.receptionList.set(count, receptionToBeUpdated);
			return 1;
			
			} 
			else 
			{
				return -1;
				
			}
	}
		    @Override
		    public synchronized int removeReception(String roomName) 
		    {
		    	boolean invalid = true;
		    	int count = -1;
		    	for (Reception tempItem :ReceptionStore.receptionList) 
		    	{
		    		count++;
		    	if (tempItem.getRoomName().equalsIgnoreCase(roomName)) 
		    	{
		    		invalid = false;
		    	    break;
		    	 }
		    	}
		    	if (!invalid)
		    	{
		    		ReceptionStore.receptionList.remove(count);
		    	     return 1;
		    	} else 
		    	{
		    		
		    		return -1;
		    		}
		    	
}
		    @Override
		    public int searchReception(String RoomName) 
		    	{
		    		boolean valid = false;
		    		for (Reception tempItem : ReceptionStore.receptionList) 
		    		{
		    			if (tempItem.getRoomName().equalsIgnoreCase(RoomName)) 
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


