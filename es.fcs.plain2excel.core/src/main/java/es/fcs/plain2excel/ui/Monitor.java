package es.fcs.plain2excel.ui;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

public class Monitor implements Observer {
	private Logger log = Logger.getLogger(Monitor.class);
	
	public Monitor(IProgressMonitor monitor) {
		super();
		this.monitor = monitor;
	}

	@Override
	public void update(Observable o, Object i) {
		if (monitor != null) {
			log.debug("i=" + i);
			monitor.worked(Integer.parseInt((String) i));
		}
	}

	private IProgressMonitor monitor = null;

}
