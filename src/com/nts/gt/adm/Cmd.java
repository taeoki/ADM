package com.nts.gt.adm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cmd {
	
	//MASK:- Variable
	private StringBuffer buffer;
	private Process process;
	private BufferedReader bufferedReader;
	private StringBuffer readBuffer;
	
	//MASK:- 
	public String inputCommand(String cmd) {
		buffer = new StringBuffer();
		
		buffer.append("cmd.exe ");
		buffer.append("/c ");
		buffer.append(cmd);
		
		return buffer.toString();
	}
	
	public String execCommand(String cmd) {
		try{
			process = Runtime.getRuntime().exec(cmd);
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line = null;
			readBuffer = new StringBuffer();
			
			while( (line = bufferedReader.readLine()) != null ) {
				if(!line.contains("%"))
				{
					readBuffer.append(line);
					readBuffer.append("\n");
				}
				
			}
			
			return readBuffer.toString();
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			
		}
		
		return null;
	}
	
	public String execCommandwn(String cmd) {
		try{
			process = Runtime.getRuntime().exec(cmd);
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line = null;
			readBuffer = new StringBuffer();
			
			while( (line = bufferedReader.readLine()) != null ) {
				if(!line.contains("%"))
				{
					readBuffer.append(line);
				}
				
			}
			
			return readBuffer.toString();
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			
		}
		
		return null;
	}
	
	
}
