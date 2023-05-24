package receptionModel;

public class Reception {
    public String roomName;
    public int ageGroup;
    public int roomId;
    public int roomCapacity;
    
    public Reception(String roomName, int ageGroup, int roomId, int roomCapacity) {
    	this.roomName = roomName;
    	this.ageGroup = ageGroup;
    	this.roomId = roomId;
    	this.roomCapacity = roomCapacity;
    }
    
    
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
}
