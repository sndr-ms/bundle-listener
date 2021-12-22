/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.saneforce.bundle.listener;

import org.osgi.framework.BundleActivator;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

public class Activator implements BundleActivator,BundleListener {

	private Logger log= Logger.getLogger("bundle-logger");
	
    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
        context.addBundleListener(this);
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
        context.removeBundleListener(this);
    }
    private static String getEventType(BundleEvent event) {
		if (event == null) {
			return "null";
		}
		int type = event.getType();
		switch (type) {
		case BundleEvent.INSTALLED:
			return "INSTALLED";
		case BundleEvent.LAZY_ACTIVATION:
			return "LAZY_ACTIVATION";
		case BundleEvent.RESOLVED:
			return "RESOLVED";
		case BundleEvent.STARTED:
			return "STARTED";
		case BundleEvent.STARTING:
			return "Starting";
		case BundleEvent.STOPPED:
			return "STOPPED";
		case BundleEvent.UNINSTALLED:
			return "UNINSTALLED";
		case BundleEvent.UNRESOLVED:
			return "UNRESOLVED";
		case BundleEvent.UPDATED:
			return "UPDATED";
		default:
			return "unknown event type: " + type;
		}
	}
    
	@Override
	public void bundleChanged(BundleEvent event) {
		
		log.info("Bundle "+event.getBundle().getSymbolicName()+" - "+event.getBundle().getVersion()+" "+getEventType(event));
			
	}

}