package org.sensorhub.impl.sensor.flood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import net.opengis.sensorml.v20.IdentifierList;
import net.opengis.sensorml.v20.Term;
import org.sensorhub.api.sensor.SensorException;
import org.sensorhub.impl.comm.RobustHTTPConnection;
import org.sensorhub.impl.module.RobustConnection;
import org.sensorhub.impl.security.ClientAuth;
import org.sensorhub.impl.sensor.AbstractSensorModule;
import org.sensorhub.api.common.SensorHubException;
import org.vast.sensorML.SMLFactory;
import org.vast.swe.SWEHelper;
import org.sensorhub.impl.sensor.flood.ISenseFloodConfig;
import org.sensorhub.impl.sensor.flood.ISenseFloodOutput;

public class ISenseFloodDriver extends AbstractSensorModule<ISenseFloodConfig>{
	
	String hostUrl;
	String username;
	String secret;
	String token;
	
	public ISenseFloodDriver() {}
	
	@Override
	public void init() throws SensorHubException {
		super.init();
		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() throws SensorHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws SensorHubException {
		// TODO Auto-generated method stub
		
	}
	
}
