// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ParserGUI.java

package es.fcs.plain2excel.gui;

import java.awt.Insets;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

import es.fcs.plain2excel.core.Driver;

// Referenced classes of package prueba.excel:
//            Driver, ExtensionFilter

public class ParserGUI extends JFrame
    implements Observer
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	class IvjEventHandler
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == getJButton2())
                connEtoC1();
            if(e.getSource() == getJButton1())
                connEtoC2();
            if(e.getSource() == getJButton11())
                connEtoC11();
            if(e.getSource() == getJButton21())
                connEtoC21();
            if(e.getSource() == getJButton31())
                connEtoC31();
            if(e.getSource() == getJButton3())
                connEtoC3();
            if(e.getSource() == getJButton41())
                connEtoC41();
            if(e.getSource() == getJButton4())
                connEtoC4();
        }

        IvjEventHandler()
        {
        }
    }


    public ParserGUI()
    {
        ivjEventHandler = new IvjEventHandler();
        ivjJButton1 = null;
        ivjJButton2 = null;
        ivjJButton3 = null;
        ivjJFrameContentPane = null;
        ivjJLabel1 = null;
        ivjJTextField1 = null;
        ivjJProgressBar1 = null;
        ivjJButton11 = null;
        ivjJButton21 = null;
        ivjJButton31 = null;
        ivjJButton41 = null;
        ivjJPanel1 = null;
        ivjJPanel2 = null;
        ivjJTextField11 = null;
        drv = null;
        ff = null;
        dir = null;
        ivjJLabel11 = null;
        ivjJButton4 = null;
        prop = null;
        file = null;
        fileName = null;
        initialize();
    }

    public ParserGUI(String title)
    {
        super(title);
        ivjEventHandler = new IvjEventHandler();
        ivjJButton1 = null;
        ivjJButton2 = null;
        ivjJButton3 = null;
        ivjJFrameContentPane = null;
        ivjJLabel1 = null;
        ivjJTextField1 = null;
        ivjJProgressBar1 = null;
        ivjJButton11 = null;
        ivjJButton21 = null;
        ivjJButton31 = null;
        ivjJButton41 = null;
        ivjJPanel1 = null;
        ivjJPanel2 = null;
        ivjJTextField11 = null;
        drv = null;
        ff = null;
        dir = null;
        ivjJLabel11 = null;
        ivjJButton4 = null;
        prop = null;
        file = null;
        fileName = null;
    }

    private void connEtoC1()
    {
        try
        {
            jButton2_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC11()
    {
        try
        {
            jButton11_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC2()
    {
        try
        {
            jButton1_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC21()
    {
        try
        {
            jButton21_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC3()
    {
        try
        {
            jButton3_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC31()
    {
        try
        {
            jButton31_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void connEtoC41()
    {
        try
        {
            jButton3_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private void fin()
    {
        int i = JOptionPane.showConfirmDialog(this, "\277Quiere parsear otro archivo?", "Otro", 0);
        if(i == 0)
        {
            getJFrameContentPane().removeAll();
            getJFrameContentPane().add(getJPanel2());
            getJProgressBar1().setVisible(false);
            getJTextField1().setText("");
            getJTextField11().setText("");
            getJProgressBar1().setValue(0);
            paint(getGraphics());
        } else
        {
            jButton3_ActionEvents();
        }
    }

    public String getDir()
    {
        return dir;
    }

    private JButton getJButton1()
    {
        if(ivjJButton1 == null)
            try
            {
                ivjJButton1 = new JButton();
                ivjJButton1.setName("JButton1");
                ivjJButton1.setText("Procesar");
                ivjJButton1.setBounds(100, 177, 107, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton1;
    }

    private JButton getJButton11()
    {
        if(ivjJButton11 == null)
            try
            {
                ivjJButton11 = new JButton();
                ivjJButton11.setName("JButton11");
                ivjJButton11.setText("Aceptar");
                ivjJButton11.setBounds(100, 127, 107, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton11;
    }

    private JButton getJButton2()
    {
        if(ivjJButton2 == null)
            try
            {
                ivjJButton2 = new JButton();
                ivjJButton2.setName("JButton2");
                ivjJButton2.setText("Buscar");
                ivjJButton2.setBounds(310, 60, 85, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton2;
    }

    private JButton getJButton21()
    {
        if(ivjJButton21 == null)
            try
            {
                ivjJButton21 = new JButton();
                ivjJButton21.setName("JButton21");
                ivjJButton21.setText("Buscar");
                ivjJButton21.setBounds(310, 60, 85, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton21;
    }

    private JButton getJButton3()
    {
        if(ivjJButton3 == null)
            try
            {
                ivjJButton3 = new JButton();
                ivjJButton3.setName("JButton3");
                ivjJButton3.setText("Cerrar");
                ivjJButton3.setBounds(220, 177, 107, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton3;
    }

    private JButton getJButton31()
    {
        if(ivjJButton31 == null)
            try
            {
                ivjJButton31 = new JButton();
                ivjJButton31.setName("JButton31");
                ivjJButton31.setText("Cancelar");
                ivjJButton31.setBounds(220, 127, 107, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton31;
    }

    private JButton getJButton41()
    {
        if(ivjJButton41 == null)
            try
            {
                ivjJButton41 = new JButton();
                ivjJButton41.setName("JButton41");
                ivjJButton41.setText("Cerrar");
                ivjJButton41.setBounds(164, 177, 107, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton41;
    }

    private JPanel getJFrameContentPane()
    {
        if(ivjJFrameContentPane == null)
            try
            {
                ivjJFrameContentPane = new JPanel();
                ivjJFrameContentPane.setName("JFrameContentPane");
                ivjJFrameContentPane.setLayout(null);
                getJFrameContentPane().add(getJPanel2(), getJPanel2().getName());
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJFrameContentPane;
    }

    private JLabel getJLabel1()
    {
        if(ivjJLabel1 == null)
            try
            {
                ivjJLabel1 = new JLabel();
                ivjJLabel1.setName("JLabel1");
                ivjJLabel1.setText("Elija el fichero origen");
                ivjJLabel1.setBounds(32, 36, 254, 14);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJLabel1;
    }

    private JLabel getJLabel11()
    {
        if(ivjJLabel11 == null)
            try
            {
                ivjJLabel11 = new JLabel();
                ivjJLabel11.setName("JLabel11");
                ivjJLabel11.setText("Guardar como...");
                ivjJLabel11.setBounds(32, 36, 254, 14);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJLabel11;
    }

    private JPanel getJPanel1()
    {
        if(ivjJPanel1 == null)
            try
            {
                ivjJPanel1 = new JPanel();
                ivjJPanel1.setName("JPanel1");
                ivjJPanel1.setLayout(null);
                ivjJPanel1.setBounds(0, 0, 426, 237);
                getJPanel1().add(getJButton11(), getJButton11().getName());
                getJPanel1().add(getJButton21(), getJButton21().getName());
                getJPanel1().add(getJButton31(), getJButton31().getName());
                getJPanel1().add(getJButton41(), getJButton41().getName());
                getJPanel1().add(getJTextField11(), getJTextField11().getName());
                getJPanel1().add(getJLabel11(), getJLabel11().getName());
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJPanel1;
    }

    private JPanel getJPanel2()
    {
        if(ivjJPanel2 == null)
            try
            {
                ivjJPanel2 = new JPanel();
                ivjJPanel2.setName("JFrameContentPane");
                ivjJPanel2.setLayout(null);
                ivjJPanel2.setBounds(0, 0, 426, 237);
                getJPanel2().add(getJLabel1(), getJLabel1().getName());
                getJPanel2().add(getJButton2(), getJButton2().getName());
                getJPanel2().add(getJTextField1(), getJTextField1().getName());
                getJPanel2().add(getJButton1(), getJButton1().getName());
                getJPanel2().add(getJButton3(), getJButton3().getName());
                getJPanel2().add(getJProgressBar1(), getJProgressBar1().getName());
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJPanel2;
    }

    private JProgressBar getJProgressBar1()
    {
        if(ivjJProgressBar1 == null)
            try
            {
                ivjJProgressBar1 = new JProgressBar();
                ivjJProgressBar1.setName("JProgressBar1");
                ivjJProgressBar1.setBounds(32, 127, 364, 18);
                ivjJProgressBar1.setVisible(false);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJProgressBar1;
    }

    private JTextField getJTextField1()
    {
        if(ivjJTextField1 == null)
            try
            {
                ivjJTextField1 = new JTextField();
                ivjJTextField1.setName("JTextField1");
                ivjJTextField1.setBounds(32, 60, 261, 18);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJTextField1;
    }

    private JTextField getJTextField11()
    {
        if(ivjJTextField11 == null)
            try
            {
                ivjJTextField11 = new JTextField();
                ivjJTextField11.setName("JTextField11");
                ivjJTextField11.setBounds(32, 60, 261, 18);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJTextField11;
    }

    private void handleException(Throwable throwable1)
    {
    }

    private void initConnections()
        throws Exception
    {
        getJButton2().addActionListener(ivjEventHandler);
        getJButton1().addActionListener(ivjEventHandler);
        getJButton11().addActionListener(ivjEventHandler);
        getJButton21().addActionListener(ivjEventHandler);
        getJButton31().addActionListener(ivjEventHandler);
        getJButton3().addActionListener(ivjEventHandler);
        getJButton41().addActionListener(ivjEventHandler);
    }

    private void initialize()
    {
        try
        {
            setTitle("Conversor a Excel");
            setLocation(100, 100);
            loadProperties();
            setName("ParserGUI");
            setDefaultCloseOperation(2);
            setSize(426, 240);
            setContentPane(getJFrameContentPane());
            initConnections();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    public void jButton1_ActionEvents()
    {
        String text = getJTextField1().getText();
        if(text == null || text.equals("")){
        	JOptionPane.showMessageDialog(this, "No ha elegido archivo", "Error", 0);
        } else
        fileName = text.charAt(text.length() - 4) != '.' ? text.substring(text.lastIndexOf("\\") + 1) + ".xls" : text.substring(text.lastIndexOf("\\") + 1, text.lastIndexOf(".")) + ".xls";
        file = prop.getProperty("outDir") + "/" + fileName;
        getJButton1().setEnabled(false);
        getJButton2().setEnabled(false);
        getJTextField1().setEnabled(false);
        try {
        	log.debug("Init..");
        	drv = new Driver();
        	drv.initialize();
        	getJProgressBar1().setVisible(true);
            drv.parseTextFile(text, this);
            drv.create();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(this, ioe.getMessage(), "Error", 0);
            getJButton1().setEnabled(true);
            getJButton2().setEnabled(true);
            getJTextField1().setEnabled(true);
            fin();
            return;
        }
        catch(Throwable e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "ha habido un error al parsear el archivo", "Error", 0);
            getJButton1().setEnabled(true);
            getJButton2().setEnabled(true);
            getJTextField1().setEnabled(true);
            fin();
            return;
        }
        JOptionPane.showMessageDialog(this, "El proceso ha terminado con exito", "Exito", 1);
        int i = JOptionPane.showConfirmDialog(this, "Desea guardarlo como:\n" + file);
        try
        {
            if(i == 1)
            {
                int j = 0;
                do
                {
                    jButton21_ActionEvents();
                    j = jButton11_ActionEvents();
                } while(j != 1);
            }
            if(i == 0 || i == 1)
                try
                {
                    drv.saveExcelFile(file);
                    log.debug("fin");
                }
                catch(Throwable e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "No se ha podido guardar el fichero", "Error", 0);
                }
        }
        finally
        {
            getJButton1().setEnabled(true);
            getJButton2().setEnabled(true);
            getJTextField1().setEnabled(true);
            fin();
        }
        
    }

    public void jButton2_ActionEvents()
    {
        JFileChooser fd = new JFileChooser(prop.getProperty("inDir"));
        fd.setDialogTitle("Fichero origen");
        fd.setMultiSelectionEnabled(false);
        fd.setFileSelectionMode(0);
        int returnVal = fd.showOpenDialog(this);
        if(returnVal == 0)
        {
            getJTextField1().setText(fd.getSelectedFile().getAbsolutePath());
            setDir(fd.getSelectedFile().getPath());
        }
    }

    public void jButton21_ActionEvents()
    {
        JFileChooser fd = new JFileChooser(prop.getProperty("outDir"));
        fd.setDialogTitle("Fichero destino");
        fd.setSelectedFile(new File(fileName));
        fd.setMultiSelectionEnabled(false);
        ff = new ExtensionFilter("Excel files", new String[] {
            ".xls"
        });
        fd.addChoosableFileFilter(ff);
        fd.setFileSelectionMode(0);
        int returnVal = fd.showSaveDialog(this);
        if(returnVal == 0)
            file = fd.getSelectedFile().getAbsolutePath();
        else
            throw new RuntimeException();
    }

    public void jButton3_ActionEvents()
    {
        dispose();
        invalidate();
        System.exit(0);
    }

    public void jButton31_ActionEvents()
    {
        fin();
    }

    public static void main(String args[])
    {
        try
        {
            ParserGUI aParserGUI = new ParserGUI();
            aParserGUI.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }

            });
            aParserGUI.show();
            Insets insets = aParserGUI.getInsets();
            aParserGUI.setSize(aParserGUI.getWidth() + insets.left + insets.right, aParserGUI.getHeight() + insets.top + insets.bottom);
            aParserGUI.setVisible(true);
        }
        catch(Throwable exception)
        {
            System.err.println("Exception occurred in main() of javax.swing.JFrame");
            exception.printStackTrace(System.out);
        }
    }

    public void setDir(String newDir)
    {
        dir = newDir;
    }

    public void update(Observable model, Object args)
    {
        int i = (Integer.parseInt((String)args) * 100) / 9;
        getJProgressBar1().setValue(i);
        paint(getGraphics());
    }

    private void connEtoC4()
    {
        try
        {
            jButton4_ActionEvents();
        }
        catch(Throwable ivjExc)
        {
            handleException(ivjExc);
        }
    }

    private JButton getJButton4()
    {
        if(ivjJButton4 == null)
            try
            {
                ivjJButton4 = new JButton();
                ivjJButton4.setName("JButton4");
                ivjJButton4.setText("Configurar");
                ivjJButton4.setBounds(300, 100, 100, 25);
            }
            catch(Throwable ivjExc)
            {
                handleException(ivjExc);
            }
        return ivjJButton4;
    }

    public void jButton4_ActionEvents()
    {
        System.out.println("mierda");
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
            ioe.printStackTrace();
        }
    }

    public int jButton11_ActionEvents()
    {
        String text = file;
        if(text != null && !text.equals(""))
        {
            if(!ff.accept(new File(text)))
            {
                JOptionPane.showMessageDialog(this, "La extension del archivo no es correcta (.xls)", "Error", 0);
                return 0;
            } else
            {
                return 1;
            }
        } else
        {
            JOptionPane.showMessageDialog(this, "No ha elegido archivo", "Error", 0);
            return 0;
        }
    }

    IvjEventHandler ivjEventHandler;
    private JButton ivjJButton1;
    private JButton ivjJButton2;
    private JButton ivjJButton3;
    private JPanel ivjJFrameContentPane;
    private JLabel ivjJLabel1;
    private JTextField ivjJTextField1;
    private JProgressBar ivjJProgressBar1;
    private JButton ivjJButton11;
    private JButton ivjJButton21;
    private JButton ivjJButton31;
    private JButton ivjJButton41;
    private JPanel ivjJPanel1;
    private JPanel ivjJPanel2;
    private JTextField ivjJTextField11;
    private Driver drv;
    private FileFilter ff;
    private String dir;
    private JLabel ivjJLabel11;
    private JButton ivjJButton4;
    private Properties prop;
    private String file;
    private String fileName;
    private Logger log = Logger.getRootLogger();
















}
