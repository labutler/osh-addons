/***************************** BEGIN LICENSE BLOCK ***************************

The contents of this file are subject to the Mozilla Public License, v. 2.0.
If a copy of the MPL was not distributed with this file, You can obtain one
at http://mozilla.org/MPL/2.0/.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the License.

Copyright (C) 2018 Delta Air Lines, Inc. All Rights Reserved.

******************************* END LICENSE BLOCK ***************************/

package org.sensorhub.impl.sensor.navDb;

import org.sensorhub.api.config.DisplayInfo;
import org.sensorhub.api.config.DisplayInfo.FieldType;
import org.sensorhub.api.config.DisplayInfo.ModuleType;
import org.sensorhub.api.config.DisplayInfo.FieldType.Type;
import org.sensorhub.api.sensor.SensorConfig;
import org.sensorhub.utils.aero.INavDatabase;


public class NavConfig extends SensorConfig
{
    
    @DisplayInfo(label="NavDB Module ID", desc="ID of navigation database module")
    @FieldType(Type.MODULE_ID)
    @ModuleType(INavDatabase.class)
    public String navDbModuleId;
    
    
    @DisplayInfo(desc="Path of CSV file containing a subset of airports to expose data for")
    public String airportFilterPath;
    
    
}
