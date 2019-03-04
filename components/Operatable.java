package components;

public interface Operatable {
	public void deviceOn(String type);
	public void deviceOff(String type);
	public Boolean deviceState(String type);
}
