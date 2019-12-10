package com.nts.gt.adm;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.android.ddmlib.IDevice;

public class LogFrame extends javax.swing.JFrame {

	//private String sDevice;
	private int mPriority;
	/*
	 * 0 = null
	 * 1 = Verbose
	 * 2 = Debug
	 * 3 = Info
	 * 4 = Warn
	 * 5 = Error
	 * 6 = Assert
	 */
	private ADB mADB;
	private IDevice[] mDevices;
	private IDevice mDevice;
	private String sDevice[];
	private int selectIndex;
	
	private JPopupMenu mPopupMenu;	
	
    /**
     * Creates new form LogFrame
     */
	public LogFrame(ADB adb ,IDevice[] device, int index) {
		selectIndex = index;
		mADB = adb;
		mDevices = device;
		mDevice = mDevices[index];
		System.out.println("Flag-LogFrame");
		initComponents();
		initializeMenu();
		setDeivce();
		getCrashLog();
		pack();
	}
	
	
    public LogFrame() {
        initComponents();
    }
    
    public void getCrashLog() {
    	
    	String device = mDevice.toString();
    	System.out.println("Flag-LogFrame-mDevice:"+device);
    	String command = "adb -s "+device+" shell dumpsys dropbox data_app_crash --print";
    	String result = null;
    	Cmd cmd = new Cmd();
    	
    	String command2 = cmd.inputCommand("adb -s "+device+" shell dumpsys dropbox data_app_crash --print");
    	String result2 = cmd.execCommand(command2);
    	System.out.println("Flag-logResult:"+result2);
    	jTextArea1.append(result2);
    	jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());   	
    	
    }
    
    
    public void setDeivce() {
    	mDevices = mADB.getDevices();
    	if (mDevices != null) {
    		sDevice = new String[mDevices.length];
    		for(int i=0; i<mDevices.length; i++) {
    			sDevice[i] = mDevices[i].toString();
    		}
    	}
    	ComboBoxDevice.setModel(new javax.swing.DefaultComboBoxModel<>(sDevice));
    	//ComboBoxDevice.setSelectedIndex(selectIndex);
    	

    }
    
    public void getDeivce() {
    	
    }
    
    public void selectDeviceComboBox() {
    	int index = ComboBoxDevice.getSelectedIndex();
    	mDevice = mDevices[index];
    	selectIndex = index;
    	
    	setDeivce();
    	getCrashLog();
    	pack();
    	
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        jTextFieldSerach = new javax.swing.JTextField();
        ComboBoxDevice = new javax.swing.JComboBox<>();
        ComboBoxPriority = new javax.swing.JComboBox<>();
        jBtnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

        ComboBoxPriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Verbose", "Debug", "Info", "Warn", "Error", "Assert" }));

        jBtnSearch.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSerach, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jBtnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSerach)
                    .addComponent(ComboBoxDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSearch))
                .addContainerGap())
        );
        
        

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		jTextArea1MouseClicked(evt);
        	}
        });
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        /*
        ComboBoxDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxDeviceMouseClicked(evt);
            }
        });
        */
        ComboBoxDevice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				selectDeviceComboBox();
				
			}
		});
        
        
        
        

        pack();
    }// </editor-fold>   
    
    private void ComboBoxDeviceMouseClicked(java.awt.event.MouseEvent evt) {                                            
        selectDeviceComboBox();
    }
    
    
    private void initializeMenu() {
    	mPopupMenu = new JPopupMenu();
    	
    	initializeSelectAllMenu();
    	mPopupMenu.addSeparator();
    	initializeCopyMenu();
    	mPopupMenu.addSeparator();
    	initializeSaveMenu();
    	
    	
    }
    
    private void initializeSelectAllMenu() {
    	JMenuItem menuItemSelectAll = new JMenuItem("Select All");
    	menuItemSelectAll.setMnemonic(KeyEvent.VK_A);
    	mPopupMenu.add(menuItemSelectAll);
    	menuItemSelectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea1.selectAll();
			}
		});
    }
    
    private void initializeCopyMenu() {
    	JMenuItem menuItemCopy = new JMenuItem("Copy");
    	menuItemCopy.setMnemonic(KeyEvent.VK_C);
    	mPopupMenu.add(menuItemCopy);
    	menuItemCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea1.copy();
				String s = jTextArea1.getSelectedText();
				System.out.println(s);
				
				System.out.println("Flag-txtSelectIndexst:"+jTextArea1.getSelectionStart() );
				System.out.println("Flag-txtSelectIndexed:"+jTextArea1.getSelectionEnd() );
			}
		});
    }
    
    private void initializeSaveMenu() {
    	JMenuItem menuItemSave = new JMenuItem("Save As");
    	menuItemSave.setMnemonic(KeyEvent.VK_S);
    	mPopupMenu.add(menuItemSave);
    	menuItemSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveDialog();
			}
		});
    }
    
    private void saveDialog() {
    	FileDialog save = new FileDialog(this,"Save As...",FileDialog.SAVE);
    	save.setVisible(true);
    	//save.setFile("*.txt");
    	
    	String filePath = save.getDirectory(); // 저장할 파일경로
    	String fileName = save.getFile();
    	
    	System.out.println("Flag-SaveFile:"+filePath+"/"+fileName);
    	
    	try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(save.getDirectory()+save.getFile()));
			
			if(jTextArea1.getSelectionStart() == jTextArea1.getSelectionEnd()) 
			{
				// jTextArea의 문자들이 선택되지 않은 상태
				fileWriter.write(jTextArea1.getText());
				fileWriter.close();
				
			}else
			{
				// jTextArea에 선택된 영역이 있을 때,
				fileWriter.write(jTextArea1.getSelectedText());
				fileWriter.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {
    	if (SwingUtilities.isRightMouseButton(evt)) {
    		System.out.println("Flag-MouseRightBtn");
    		mPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    	}
    }
    
    
    
    public class MonitorThread extends Thread {
    	
    	@Override
    	public void run() {
    		Thread thread = Thread.currentThread();
    	}
    }
    
    
    

 // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> ComboBoxDevice;
    private javax.swing.JComboBox<String> ComboBoxPriority;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldSerach;
    // End of variables declaration              
}
