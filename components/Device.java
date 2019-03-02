package components;

public abstract class Device implements Switchable {
	protected Boolean state;

	public Device() {
		super();
		this.state = false;
	}

	public Boolean getState() {
		return state;
	}

	@Override
	public void turnOn() {
		this.state = true;
	}

	@Override
	public void turnOff() {
		this.state = false;		
	}
	
}
