/***************************** BEGIN LICENSE BLOCK ***************************

The contents of this file are subject to the Mozilla Public License, v. 2.0.
If a copy of the MPL was not distributed with this file, You can obtain one
at http://mozilla.org/MPL/2.0/.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the License.
 
The Initial Developer is Sensia Software LLC. Portions created by the Initial
Developer are Copyright (C) 2014 the Initial Developer. All Rights Reserved.
 
******************************* END LICENSE BLOCK ***************************/

package org.sensorhub.test.impl.sensor.fakeweather;

import java.io.IOException;
import java.util.UUID;
import net.opengis.sensorml.v20.AbstractProcess;
import net.opengis.swe.v20.DataComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sensorhub.api.event.Event;
import org.sensorhub.api.event.IEventListener;
import org.sensorhub.api.common.SensorHubException;
import org.sensorhub.api.data.IStreamingDataInterface;
import org.sensorhub.api.data.DataEvent;
import org.sensorhub.impl.sensor.fakeweather.FakeWeatherConfig;
import org.sensorhub.impl.sensor.fakeweather.FakeWeatherSensor;
import org.vast.data.TextEncodingImpl;
import org.vast.sensorML.SMLUtils;
import org.vast.swe.AsciiDataWriter;
import org.vast.swe.SWEUtils;
import static org.junit.Assert.*;


public class TestFakeWeatherDriver implements IEventListener
{
    FakeWeatherSensor driver;
    FakeWeatherConfig config;
    AsciiDataWriter writer;
    int sampleCount = 0;

        
    @Before
    public void init() throws Exception
    {
        config = new FakeWeatherConfig();
        config.id = UUID.randomUUID().toString();
        
        driver = new FakeWeatherSensor();
        driver.init(config);
    }
    
    
    @Test
    public void testGetOutputDesc() throws Exception
    {
        for (IStreamingDataInterface di: driver.getObservationOutputs().values())
        {
            System.out.println();
            DataComponent dataMsg = di.getRecordDescription();
            new SWEUtils(SWEUtils.V2_0).writeComponent(System.out, dataMsg, false, true);
        }
    }
    
    
    @Test
    public void testGetSensorDesc() throws Exception
    {
        System.out.println();
        AbstractProcess smlDesc = driver.getCurrentDescription();
        new SMLUtils(SWEUtils.V2_0).writeProcess(System.out, smlDesc, true);
    }
    
    
    @Test
    public void testSendMeasurements() throws Exception
    {
        System.out.println();
        IStreamingDataInterface gpsOutput = driver.getObservationOutputs().get("weather");
        
        writer = new AsciiDataWriter();
        writer.setDataEncoding(new TextEncodingImpl(",", "\n"));
        writer.setDataComponents(gpsOutput.getRecordDescription());
        writer.setOutput(System.out);
        
        gpsOutput.registerListener(this);
        driver.start();
        
        synchronized (this) 
        {
            while (sampleCount < 2)
                wait();
        }
        
        System.out.println();
    }
    
    
    @Override
    public void handleEvent(Event e)
    {
        assertTrue(e instanceof DataEvent);
        DataEvent newDataEvent = (DataEvent)e;
        
        try
        {
            //System.out.print("\nNew data received from sensor " + newDataEvent.getSensorId());
            writer.write(newDataEvent.getRecords()[0]);
            writer.flush();
            
            sampleCount++;
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
                
        synchronized (this) { this.notify(); }
    }
    
    
    @After
    public void cleanup()
    {
        try
        {
            driver.stop();
        }
        catch (SensorHubException e)
        {
            e.printStackTrace();
        }
    }
}
