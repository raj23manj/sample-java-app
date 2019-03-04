package components;

public abstract class Corridor implements Operatable {
	protected Switchable light;
	protected Switchable ac;

	public Corridor(Switchable light, Switchable ac) {
		super();
		this.light = light;
		this.ac = ac;
	}

	public void deviceOn(String type) {
		switch (type) {
		case Constants.AC:
			ac.turnOn();
			break;
		case Constants.LIGHT:
			light.turnOn();
			break;
		}
	}

	public void deviceOff(String type) {
		switch (type) {
		case Constants.AC:
			ac.turnOff();
			break;
		case Constants.LIGHT:
			light.turnOff();
			break;
		}
	}

	public Boolean deviceState(String type) {
		Boolean state = null;
		
		switch (type) {
		case Constants.AC:
			state = ac.getState();
			break;
		case Constants.LIGHT:
			state = light.getState();
			break;
		}
		return state;
	}

}
