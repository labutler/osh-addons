/***************************** BEGIN LICENSE BLOCK ***************************

The contents of this file are subject to the Mozilla Public License, v. 2.0.
If a copy of the MPL was not distributed with this file, You can obtain one
at http://mozilla.org/MPL/2.0/.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the License.
 
Copyright (C) 2012-2016 Sensia Software LLC. All Rights Reserved.
 
******************************* END LICENSE BLOCK ***************************/

package org.sensorhub.impl.service.commrelay;

import org.sensorhub.api.comm.CommProviderConfig;
import org.sensorhub.api.config.DisplayInfo;
import org.sensorhub.api.service.ServiceConfig;


/**
 * <p>
 * Configuration class for the Comm Relay Service module
 * </p>
 *
 * @author Alexandre Robin <alex.robin@sensiasoftware.com>
 * @since Feb 16, 2016
 */
public class CommRelayConfig extends ServiceConfig
{
    @DisplayInfo(desc="Communication settings for the incoming stream")
    public CommProviderConfig<?> incomingCommSettings;
    
    @DisplayInfo(desc="Communication settings for the outgoing stream")
    public CommProviderConfig<?> outgoingCommSettings;
    
    public int bufferSize = 8092;
}