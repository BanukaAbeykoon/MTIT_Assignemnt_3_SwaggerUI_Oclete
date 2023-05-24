package receptionService;

import java.util.List;

import receptionModel.Reception;

public interface ReceptionService {
	public int RegisterReception(String roomName, int ageGroup,int roomId, int roomCapacity);
    public List<Reception> listReception();
    public int updateReception(String roomName, int ageGroup, int roomId, int roomCapacity);
    public int removeReception(String roomName);
    public int searchReception(String roomName);
   
}
