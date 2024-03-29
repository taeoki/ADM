/*
 * Copyright (C) 2009-2013 adakoda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nts.gt.adm;

import java.io.File;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

public class ADB {
	private AndroidDebugBridge mAndroidDebugBridge;

	public boolean initialize(String[] args) {
		boolean success = true;

		String adbLocation = System
				.getProperty("com.android.screenshot.bindir");

		// You can specify android sdk directory using first argument
		// A) If you lunch jar from eclipse, set arguments in Run/Debug configurations to android sdk directory .
		//    /Applications/adt-bundle-mac-x86_64/sdk
		// A) If you lunch jar from terminal, set arguments to android sdk directory or $ANDROID_HOME environment variable.
		//    java -jar ./jar/asm.jar $ANDROID_HOME
		if (adbLocation == null) {
			if ((args != null) && (args.length > 0)) {
				adbLocation = args[0];
			} else {
				adbLocation = System.getenv("ANDROID_HOME");
			}
			// Here, adbLocation may be android sdk directory
			if (adbLocation != null) {
				adbLocation += File.separator + "platform-tools";
			}
		}

		// for debugging (follwing line is a example)
//		adbLocation = "C:\\ ... \\android-sdk-windows\\platform-tools"; // Windows
//		adbLocation = "/ ... /adt-bundle-mac-x86_64/sdk/platform-tools"; // MacOS X
		
		if (success) {
			if ((adbLocation != null) && (adbLocation.length() != 0)) {
				adbLocation += File.separator + "adb";
			} else {
				adbLocation = "adb";
			}
			System.out.println("adb path is " + adbLocation);
			AndroidDebugBridge.init(false);
			mAndroidDebugBridge = AndroidDebugBridge.createBridge(adbLocation,
					true);
			if (mAndroidDebugBridge == null) {
				success = false;
			}
		}

		if (success) {
			int count = 0;
			while (mAndroidDebugBridge.hasInitialDeviceList() == false) {
				try {
					Thread.sleep(100);
					count++;
				} catch (InterruptedException e) {
				}
				if (count > 100) {
					success = false;
					break;
				}
			}
		}

		if (!success) {
			terminate();
		}

		return success;
	}

	public void terminate() {
		AndroidDebugBridge.terminate();
	}

	public IDevice[] getDevices() {
		IDevice[] devices = null;
		if (mAndroidDebugBridge != null) {
			devices = mAndroidDebugBridge.getDevices();
			System.out.println("devices : "+devices.length);
		}
		return devices;
	}
}
