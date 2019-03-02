package components;

public abstract class Corridor implements Operations {
	protected Switchable light;
	protected Switchable ac;

	public Corridor(Switchable light, Switchable ac) {
		super();
		this.light = light;
		this.ac = ac;
	}

	public void lightOn() {
		light.turnOn();
	}

	public void lightOff() {
		light.turnOff();
	}

	public Boolean lightState() {
		return light.getState();
	}

	public void acOn() {
		ac.turnOn();
	}

	public void acOff() {
		ac.turnOff();
	}

	public Boolean acState() {
		return ac.getState();
	}

}
