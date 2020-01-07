package org.sensorhub.impl.sensor.flood;

import org.sensorhub.api.config.DisplayInfo;
import org.sensorhub.api.sensor.SensorConfig;
import org.sensorhub.api.config.DisplayInfo;
import org.sensorhub.api.config.DisplayInfo.FieldType;
import org.sensorhub.api.config.DisplayInfo.FieldType.Type;
import org.sensorhub.api.config.DisplayInfo.ModuleType;
import org.sensorhub.api.config.DisplayInfo.Required;
import org.sensorhub.api.sensor.ISensorModule;
import org.sensorhub.impl.comm.HTTPConfig;

public class ISenseFloodConfig extends SensorConfig{
	//@DisplayInfo(label="")
	
	public class ISenseFloodOptionsConfig{
		@DisplayInfo(label="URL", desc="URL of the Flood Sensor Server")
		public HTTPConfig iSenseFloodURL = new HTTPConfig();
		
		@DisplayInfo(label="Username")
		public String username;
		
		
	}
}
