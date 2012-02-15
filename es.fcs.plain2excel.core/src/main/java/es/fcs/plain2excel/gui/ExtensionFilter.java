// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExtensionFilter.java

package es.fcs.plain2excel.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtensionFilter extends FileFilter
{

    public ExtensionFilter(String desc, String extensions[])
    {
        this.desc = desc;
        this.extensions = (String[])extensions.clone();
    }

    public boolean accept(File f)
    {
        if(f.isDirectory())
            return true;
        String name = f.getName().toLowerCase().trim();
        int length = name.length();
        for(int i = 0; i < extensions.length; i++)
        {
            String ext = extensions[i].toLowerCase().trim();
            if(name.endsWith(ext) && name.charAt(length - ext.length()) == '.')
                return true;
        }

        return false;
    }

    public String getDescription()
    {
        return desc;
    }

    protected String desc;
    protected String extensions[];
}
