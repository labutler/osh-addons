package org.sensorhub.impl.sensor.flood;

import org.sensorhub.api.module.IModule;
import org.sensorhub.api.module.IModuleProvider;
import org.sensorhub.api.module.ModuleConfig;
//import org.sensorhub.impl.sensor.flood.ISenseFloodDriver;
//import org.sensorhub.impl.sensor.flood.ISenseFloodConfig;
import org.sensorhub.impl.module.JarModuleProvider;

public class ISenseFloodDescriptor extends JarModuleProvider implements IModuleProvider{
	
	@Override
	public Class<? extends IModule<?>> getModuleClass()
	{
		return ISenseFloodDriver.class;	
	}

	
	@Override
	public Class<? extends ModuleConfig> getModuleConfigClass()
	{
	       return ISenseFloodConfig.class;
	}

}
