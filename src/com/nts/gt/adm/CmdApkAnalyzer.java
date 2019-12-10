package com.nts.gt.adm;

public class CmdApkAnalyzer {
	
	/*
	 * 인덱스별 내용.
	 * 1 - packagename
	 * 3 - apk version code
	 * 5 - apk version name
	 */
	
	public String[] string;
		
	public void inputString (String data)
	{
		string = data.split("'");
		
	}
	
	public String getPackageName () 
	{
		return string[1];
	}
	
	public String getVersion ()
	{
		return string[5];
	}
}
