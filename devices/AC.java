package devices;

import utils.Constants;

public class AC extends Device {
	@Override
	public Integer powerConsumption() {
		return this.state ? Constants.AC_CONSUMES : Constants.DEFAULT_CONSUMPTION ;
	}
}
