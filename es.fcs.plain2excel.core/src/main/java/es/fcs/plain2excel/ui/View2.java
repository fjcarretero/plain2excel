package es.fcs.plain2excel.ui;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

import es.fcs.plain2excel.core.Driver;
import es.fcs.plain2excel.gui.ParserGUI;

public class View2 extends ViewPart implements IPrefersPerspective {
	public static final String ID = "es.fcs.plain2excel.ui.view";

	public void createPartControl(final Composite parent) {
		loadProperties();
		GridLayout layout = new GridLayout(4, true);
		layout.marginWidth = 10;
		parent.setLayout(layout);
		
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment= GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalSpan = 4;
		gridData1.verticalAlignment = GridData.END;
		Label label = new Label(parent, SWT.NONE);
		label.setText("Elija el fichero origen:   ");
		label.setLayoutData(gridData1);
		
		final Text text = new Text(parent, SWT.BORDER);
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment= GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalSpan = 3;
		text.setLayoutData(gridData2);
		
		final Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Buscar");
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment= GridData.FILL;
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalSpan = 1;
		gridData3.heightHint = 25;
		gridData3.widthHint = 85;
		button1.setLayoutData(gridData3);
		
		button2 = new Button(parent, SWT.PUSH);
		button2.setText("Procesar");
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment= GridData.END;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.horizontalSpan = 2;
		gridData4.verticalAlignment = GridData.END;
		gridData4.heightHint = 25;
		gridData4.widthHint = 107;
		button2.setLayoutData(gridData4);
		
		Button button3 = new Button(parent, SWT.PUSH);
		button3.setText("Cerrar");
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment= GridData.BEGINNING;
		gridData5.grabExcessHorizontalSpace = true;
		gridData5.horizontalSpan = 2;
		gridData5.verticalAlignment = GridData.END;
		gridData5.heightHint = 25;
		gridData5.widthHint = 107;
		button3.setLayoutData(gridData5);
		
		button3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println(event.toString());
				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
				try {
					handlerService.executeCommand("org.eclipse.ui.file.exit", null);
				} catch (Exception ex) {
					throw new RuntimeException("org.eclipse.ui.file.exit not found");
				}
			}
		});
		
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println(event.toString());
				FileDialog dlg = new FileDialog(button1.getShell(),  SWT.OPEN  );
				dlg.setFilterPath(prop.getProperty("inDir"));
				dlg.setText("Open");
				String path = dlg.open();
				if (path == null) return;
				text.setText(path);
			}
		});
		
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				process(text);
			}
		});
	}
    
    public void setDir(String newDir)
    {
        dir = newDir;
    }
    
	public void setFocus() {
	}
	
	private void process(Text text) {
		final String texto = text.getText();
	    if(texto == null || texto.equals("")){
			MessageBox dialog2 = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
	        dialog2.setText("Error");
	        dialog2.setMessage("No ha elegido archivo");
	        dialog2.open();
	    } else {
	        ProgressMonitorDialog dialog = new ProgressMonitorDialog(button2.getShell()); 
			try {

				dialog.run(true, true, new IRunnableWithProgress() {
					
					@Override
					public void run(IProgressMonitor monitor) throws InvocationTargetException,
							InterruptedException{
				        Monitor mon = new Monitor(monitor);
						monitor.beginTask("Procesando el archivo ...", 100); 
				        fileName = texto.charAt(texto.length() - 4) != '.' ? texto.substring(texto.lastIndexOf("\\") + 1) + ".xls" : texto.substring(texto.lastIndexOf("\\") + 1, texto.lastIndexOf(".")) + ".xls";
				        file = fileName;
				        file = prop.getProperty("outDir") + "/" + fileName;
			        	try {
							log.debug("Init..");
							drv = new Driver();
							drv.initialize();
							drv.parseTextFile(texto, mon);
							drv.createEclipse();
						} catch (Throwable e) {
							log.error("Throwable", e);
							throw new InterruptedException(e.getMessage());
						}
				        monitor.done();
				    }


				});
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				log.error("InvocationTargetException", e);
				MessageBox dialog3 = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
		        dialog3.setText("Error");
		        dialog3.setMessage("Ha habido un error al parsear el archivo");
		        dialog3.open();
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.error("InterruptedException", e);
				MessageBox dialog3 = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
		        dialog3.setText("Error");
		        dialog3.setMessage("Ha habido un error al parsear el archivo");
		        dialog3.open();
				return;
			}
			MessageBox dialog3 = new MessageBox(getShell(), SWT.ICON_INFORMATION | SWT.OK);
	        dialog3.setText("Exito");
	        dialog3.setMessage("El proceso ha terminado con exito");
	        dialog3.open();
	        
			MessageBox dialog4 = new MessageBox(getShell(), SWT.ICON_INFORMATION | SWT.OK | SWT.CANCEL);
	        dialog4.setText("Exito");
	        dialog4.setMessage("Desea guardarlo como:\n" + file);
	        int i = dialog4.open();
	        int res = 0;
	        if (i==SWT.OK){
	        	res = save(file + ".xls", text);
	        } 
	        
	        if (res!=0 || i==SWT.CANCEL){
	        	int j = 0;
             	do
                {           
                	if (elegir()){
                		j = 1;
                	} else {
                		j = guardar();
                	}
                } while(j != 1);
             	save(file + ".xls", text);
	        }
	    }
	}	
	
    private int save(String file2, Text text) {
		try {
			if (file!=null){
				drv.saveExcelFile(file);
				MessageBox dialog5 = new MessageBox(getShell(), SWT.ICON_INFORMATION | SWT.OK);
		        dialog5.setText("Exito");
		        dialog5.setMessage("El archivo se ha guardado");
		        dialog5.open();
			}
	        text.setText("");
			return 0;
		} catch (Throwable e) {
			log.error("Throwable", e);
			MessageBox dialog5 = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
	        dialog5.setText("Error");
	        dialog5.setMessage("No se ha podido guardar el fichero");
	        dialog5.open();
	        return 1;
		}
	}

	private void loadProperties()
	{
	    prop = new Properties();
	    try
	    {
	        prop.load(ParserGUI.class.getResourceAsStream("/dirConfig.properties"));
	    }
	    catch(IOException ioe)
	    {
	    	log.error("Throwable", ioe);
//	    	ioe.printStackTrace();
	    }
	}
    
	private Shell getShell() {
		// TODO Auto-generated method stub
		return button2.getShell();
	}
	
    public int guardar()
    {
        String text = file;
        if(text != null && !text.equals("")){
                 return 1;
        } else {
			MessageBox dialog6 = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
		    dialog6.setText("Error");
		    dialog6.setMessage("No ha elegido archivo");
		    dialog6.open();
           return 0;
        }
    }
    
    public boolean elegir()
    {
    	FileDialog dlg = new FileDialog(getShell(),  SWT.SAVE  );
		dlg.setText("Save");
		dlg.setFileName(fileName);
		dlg.setOverwrite(true);
		dlg.setFilterPath(prop.getProperty("outDir"));
		dlg.setFilterExtensions(new String[]{".xls"});
		String path = dlg.open();
		file = path;
		if (path != null) {
			return false;
		} else {
        	return true;
		}
    }
    
	private Driver drv;
//    private FileFilter ff;
    private String dir;
    private Properties prop;
    private String file;
    private String fileName;
    private Logger log = Logger.getLogger(View2.class);
    private Button button2 = null;

	@Override
	public String getPreferredPerspectiveId() {
		return "es.fcs.plain2excel.ui.perspective";
	}

}
