package com.nts.gt.adm;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import com.android.chimpchat.adb.AdbChimpDevice;
import com.android.ddmlib.IDevice;



/**
 *
 * @author USER
 */
public class MainFrame2 extends javax.swing.JFrame {

	
	// MASK - 변수 생성 
	
	private IDevice[] mDevices;
	private IDevice mDevice;
	private Preferences mPrefs;
	private ADB mADB;
	
	ArrayList<String> listApk = new ArrayList<String>();
	ArrayList<String> listPackage = new ArrayList<String>();
	
	HashMap<String,String> map;
	
	
	public void getDevice() 
    {
    	map = new HashMap<String,String>();
		
		
    	mDevices = mADB.getDevices();
    	System.out.println("Flag-mDevices : "+mDevices);
    	if (mDevices != null) {
    		ArrayList<String> listDeviceSerial = new ArrayList<String>();
    		ArrayList<String> listDeviceName = new ArrayList<String>();
    		
    		for( int i=0; i < mDevices.length; i++ ) {
    			listDeviceSerial.add(mDevices[i].toString());
    			Cmd cmd = new Cmd();
    			
    			String command = "adb -s "+mDevices[i].toString()+" shell getprop ro.product.model";
    			String command2 = "adb -s "+mDevices[i].toString()+" shell getprop ro.build.version.release";
    			String result;
    			
    			result = cmd.execCommandwn(command);
    			
    			System.out.println("flag-deviceinfo : "+result+"("+mDevices[i].toString()+")");
    			
    			listDeviceName.add(result);
    			
    			map.put( result, mDevices[i].toString() );	// key: DeviceName , value: SerialNumber 
    			
    			 
    		}    		
    		dataToJlist(jListDevice, listDeviceName);    		
    	}    	
    }
	public void dataToJlist (javax.swing.JList<String> jlist ,
    		ArrayList<String> list )
    {
    	
    	String[] data = list.toArray(new String[list.size()]);
    	jlist.setModel(new javax.swing.AbstractListModel<String>() {
    		public int getSize () {return data.length;}
    		public String getElementAt(int i) {return data[i]; }
    	});
    	
    	
    }
	
	
	
    /**
     * Creates new form MainFrame2
     */
    public MainFrame2() {
    	
    	initComponents();
    	getDevice();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">      
    public void getADB() {
    	
    	mADB = new ADB();
    	if (!mADB.initialize(null)) {
			JOptionPane.showMessageDialog(this,
					"Could not find adb, please install Android SDK and set path to adb.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    
    private void initComponents() {
    	
    	
    	getADB();

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        LabelDevice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDevice = new javax.swing.JList<>();
        BtnRefresh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        LabelApkList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListApkList = new javax.swing.JList<>();
        BtnApkListDel = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        LabelPackageName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListPackageName = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        BtnPackageListAdd = new javax.swing.JButton();
        BtnPackageDel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnInstall = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnDataClear = new javax.swing.JButton();
        BtnScreenMonitor = new javax.swing.JButton();
        BtnDeviceLog = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelDevice.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        LabelDevice.setText("Device");

        jListDevice.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jListDevice);

        BtnRefresh.setFont(new java.awt.Font("굴림", 1, 10)); // NOI18N
        BtnRefresh.setText("√");
        BtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(LabelDevice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRefresh)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDevice)
                    .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelApkList.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        LabelApkList.setText("Apk List");

        jScrollPane2.setViewportView(jListApkList);

        BtnApkListDel.setText("Del");
        BtnApkListDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApkListDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LabelApkList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnApkListDel))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelApkList)
                    .addComponent(BtnApkListDel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelPackageName.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        LabelPackageName.setText("Package Name");

        jScrollPane3.setViewportView(jListPackageName);

        BtnPackageListAdd.setText("Add");
        BtnPackageListAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPackageListAddActionPerformed(evt);
            }
        });

        BtnPackageDel.setText("Del");
        BtnPackageDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPackageDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(LabelPackageName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPackageListAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPackageDel)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelPackageName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPackageListAdd)
                    .addComponent(BtnPackageDel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnInstall.setText("Install");
        BtnInstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInstallActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnDataClear.setText("Data Clear");
        BtnDataClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDataClearActionPerformed(evt);
            }
        });

        BtnScreenMonitor.setText("Screen Monitor");
        BtnScreenMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScreenMonitorActionPerformed(evt);
            }
        });

        BtnDeviceLog.setText("Crash Log");
        BtnDeviceLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeviceLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnDeviceLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnScreenMonitor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(BtnDataClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnInstall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnInstall, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDataClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnScreenMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDeviceLog, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
//MASK:- DnD Drag n Drop         
        jListApkList.setDropTarget(new DropTarget() {
        	public synchronized void drop(DropTargetDropEvent evt) {
        		        		        		
        		try{
        			
        			evt.acceptDrop(DnDConstants.ACTION_COPY);
        			List<File> droppedFiles = (List<File>)
        	                evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
        	            for (File file : droppedFiles) {
        	                // process files
        	            	Cmd cmd = new Cmd();
        	            	CmdApkAnalyzer apk = new CmdApkAnalyzer();
        	            	
        	            	System.out.println("파일경로 "+file.getAbsolutePath());        	            	
        	            	String command = "aapt dump badging "+file.getAbsolutePath();
        	            	
        	            	cmd.inputCommand(command);        	            	
        	            	apk.inputString(cmd.execCommand(command));
        	            	        	            	  	            	        	            	
        	            	listApk.add(file.getAbsolutePath());
        	            	listPackage.add(apk.getPackageName());
        	            	     
        	            	jTextArea1.append("\nApk Path : "+file.getAbsolutePath()+"\n");
        	            	jTextArea1.append(  "Package : "+apk.getPackageName()+"\n");
        	            	jTextArea1.append(  "Apk Ver. : "+apk.getVersion()+"\n");
        	            	jTextArea1.append("\n");
        	            	
        	            	jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        	            }
        			
        		}catch (Exception ex) {
        			ex.printStackTrace();
        		}
        		
        		dataToJlist(jListApkList, listApk);
        		dataToJlist(jListPackageName, listPackage);        		
        	}
        });

        setResizable(false);
        pack();
    }// </editor-fold>                        

    private void BtnScreenMonitorActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	    	
    	ArrayList<String> list = new ArrayList<String>();
        
    	int selectIndex = jListDevice.getSelectedIndex();
    	System.out.println("selectIndex:"+jListDevice.getSelectedIndex());
             	
    	if(selectIndex >= 0) {
			
    		
			ScreenFrame mScreen = new ScreenFrame(mADB,selectIndex);
			
			mScreen.setLocationRelativeTo(null);
			mScreen.setVisible(true);
			mScreen.setFocusable(true);				
		}			
    }                                                

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	getDevice();
    }                                          

    private void BtnDeviceLogActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	int selectIndex = jListDevice.getSelectedIndex();
    	if(selectIndex >= 0){
    		LogFrame logScreen = new LogFrame(mADB,mDevices,selectIndex);
    		logScreen.setLocationRelativeTo(null);
    		logScreen.setVisible(true);
    		logScreen.setFocusable(true);
    	}    	
    }                                            

    private void BtnInstallActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    	Object selectedDeviceValue [] = jListDevice.getSelectedValues();
    	Object selectedAPKValue [] = jListApkList.getSelectedValues();
    	
    	for (int i=0; i<selectedDeviceValue.length; i++) 
    	{
    		if( map.containsKey( (String)selectedDeviceValue[i] ) )
    		{
    			String deviceSerial = map.get( (String)selectedDeviceValue[i] );
    			
    			for (int j=0; j<selectedAPKValue.length; j++)
    			{
    				Cmd cmd = new Cmd();
    				String command = cmd.inputCommand("adb -s "+deviceSerial+" install "+(String)selectedAPKValue[j] );
    				String result = cmd.execCommand(command);
    				jTextArea1.append(result);
        			jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    			}
    		}
    		else
    		{
    			System.out.println("DeviceNumber : "+(String)selectedDeviceValue[i]+ " install fail" );
    		}
    	}
    	
    	
    }                                          

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	
    	Object selectedDevice [] = jListDevice.getSelectedValues();
    	
    	Object selectedPackage [] = jListPackageName.getSelectedValues();
    	
    	for ( int i = 0; i<selectedDevice.length; i++ )
    	{
    		if ( map.containsKey( (String)selectedDevice[i] ))
    		{
    			String deviceSerial = map.get( (String)selectedDevice[i] );
    			
    			for (int j=0; j<selectedPackage.length; j++) 
    			{
    				String packageName = (String)selectedPackage[j];
    				
    				Cmd cmd = new Cmd();
    				String command = cmd.inputCommand("adb -s "+deviceSerial+" uninstall "+packageName);
    				String result = cmd.execCommand(command);
    				jTextArea1.append(result);
        			jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    			}
    		}
    		else 
    		{
    			System.out.println("DeviceNumber: "+(String)selectedDevice[i]+" Delete fail");
    		}
    	}
    	
    	
    	
    	/*
    	int DeviceCount[] = jListDevice.getSelectedIndices();
    	Object DeviceSerial[] = jListDevice.getSelectedValues();
    	
    	
    	int PackageCount[] = jListPackageName.getSelectedIndices();
    	Object PackageName[] = jListPackageName.getSelectedValues();
    	
    	for(int i=0; i<DeviceCount.length; i++)
    	{
    		for (int j =0; j<PackageCount.length; j++)
    		{
    			Cmd cmd = new Cmd();
    			System.out.println();
    			String command = cmd.inputCommand("adb -s "+DeviceSerial[i]+" uninstall "+PackageName[j]);
    			
    			
    			cmd.inputCommand(command);
    			String result = cmd.execCommand(command);
    			jTextArea1.append(result);
    			jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    		}
    	}
    	*/
    }                                         

    private void BtnDataClearActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	int SelectIndex = jListDevice.getSelectedIndex();
        int SelectIndex2 = jListPackageName.getSelectedIndex();
        
        if(SelectIndex != -1 && SelectIndex2 != -1)
        {
        	int DeviceCount[] = jListDevice.getSelectedIndices();
        	Object DeviceSerial[] = jListDevice.getSelectedValues();
        	
        	String packageName = jListPackageName.getSelectedValue();
        	
        	for(int i=0; i<DeviceCount.length; i++)
        	{
        		Cmd cmd = new Cmd();
        		String command = cmd.inputCommand("adb -s "+mDevices[i].toString()+" shell pm clear "+packageName);
        		
        		cmd.inputCommand(command);
        		String result = cmd.execCommand(command);
        		jTextArea1.append(result);
    			jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        	}
        	
        }
        jTextArea1.append("\n");
		jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }                                            

    private void BtnApkListDelActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // apk list delete
    	System.out.println("Flag-ApkDell");
    	int index = jListApkList.getSelectedIndex();
    	System.out.println("Flage-index:"+index);
    	
    	if (index != -1) 
    	{
    		
    	}
    	
    	
    }                                        

    private void BtnPackageListAddActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Package Name Add
    	System.out.println("Flag-PacakgeNameAdd");
    }                                        

    private void BtnPackageDelActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Package Name Del
    	System.out.println("Flage-PackageNameDel");
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BtnDataClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnDeviceLog;
    private javax.swing.JButton BtnInstall;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JButton BtnScreenMonitor;
    private javax.swing.JLabel LabelApkList;
    private javax.swing.JLabel LabelDevice;
    private javax.swing.JLabel LabelPackageName;
    private javax.swing.JButton BtnPackageListAdd;
    private javax.swing.JButton BtnPackageDel;
    private javax.swing.JButton BtnApkListDel;
    private javax.swing.JList<String> jListApkList;
    private javax.swing.JList<String> jListDevice;
    private javax.swing.JList<String> jListPackageName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}