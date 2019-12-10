package com.nts.gt.adm;

import java.util.HashMap;

import javax.swing.JOptionPane;

import com.android.ddmlib.IDevice;

public class testDelete {
	
	 IDevice mDevice;
	 static IDevice[] mDevices;
	 static ADB mADB;
	
	public static void main(String[] args) {
		mADB = new ADB();
    	if (!mADB.initialize(null)) {
			/*JOptionPane.showMessageDialog(this,
					"Could not find adb, please install Android SDK and set path to adb.",
					"Error", JOptionPane.ERROR_MESSAGE);*/
		}
		
		mDevices = mADB.getDevices();
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		if (mDevices!= null) {
			for (int i=0; i<mDevices.length; i++){
				System.out.println(i+": "+mDevices[i]);
				
				Cmd cmd = new Cmd();
				
				String command = "adb -s "+mDevices[i].toString()+" shell getprop ro.product.model";
				String result;
				
				result = cmd.execCommand(command);
				System.out.println("result : "+result);
				
				
				map.put(mDevices[i].toString(), result);			
			}
		}
		
		System.out.println(map.get(mDevices[1].toString()) );
		
		
		
	}
}
