package es.fcs.plain2excel.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

/**
 * PreferredPerspectivePartListener is to be registered using the extension
 * point "org.eclipse.ui.startup". It will register itself as listener for the
 * activation of parts. When a part which implements IPrefersPerspective is
 * activated it will activate the preferred perspective of this part.
 */
public class PreferredPerspectivePartListener implements IPartListener, IStartup {

//	private static final Logger log = Logger.getLogger(PreferredPerspectivePartListener.class);

    public void partActivated(IWorkbenchPart part) {
        refresh(part);
    }

    public static void refresh(final IWorkbenchPart part) {
        if (!(part instanceof IPrefersPerspective)) {
            return;
        }

        final IWorkbenchWindow workbenchWindow = part.getSite().getPage().getWorkbenchWindow();

        IPerspectiveDescriptor activePerspective = workbenchWindow.getActivePage().getPerspective();
        final String preferredPerspectiveId = ((IPrefersPerspective) part)
                .getPreferredPerspectiveId();

        if (preferredPerspectiveId == null) {
            return;
        }

        if (activePerspective == null || !activePerspective.getId().equals(preferredPerspectiveId)) {
            // Switching of the perspective is delayed using Display.asyncExec
            // because switching the perspective while the workbench is
            // activating parts might cause conflicts.
            Display.getCurrent().asyncExec(new Runnable() {

                public void run() {
//                    log.debug("Switching to preferred perspective " + preferredPerspectiveId
//                            + " for " + part.getClass());
                    try {
                        workbenchWindow.getWorkbench().showPerspective(preferredPerspectiveId,
                                workbenchWindow);
                    } catch (WorkbenchException e) {
//                        log.warn("Could not switch to preferred perspective "
//                                + preferredPerspectiveId + " for " + part.getClass(), e);
                    	e.printStackTrace();
                    }
                }

            });
        }

    }

    public void earlyStartup() {
        Display.getDefault().asyncExec(new Runnable() {

            public void run() {
                try {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                            .addPartListener(new PreferredPerspectivePartListener());
                } catch (Exception e) {
//                    log.error(e.getMessage(), e);
                	e.printStackTrace();
                }
            }

        });
    }

    public void partBroughtToTop(IWorkbenchPart part) {
        // nothing to do
    }

    public void partClosed(IWorkbenchPart part) {
        // nothing to do
    }

    public void partDeactivated(IWorkbenchPart part) {
        // nothing to do
    }

    public void partOpened(IWorkbenchPart part) {
        // nothing to do
    }

}
