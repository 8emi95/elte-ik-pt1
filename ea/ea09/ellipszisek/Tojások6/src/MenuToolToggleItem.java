import javax.swing.*;
import java.awt.event.*;

public class MenuToolToggleItem implements ActionListener
{
    private JMenuItem       menu;
    private JToggleButton   tool;
    private Action          action;

    public MenuToolToggleItem(Action action)
    {
        this.action = action;
        menu = null;    tool = null;
    }

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == menu && tool != null )
            tool.setSelected(menu.isSelected());
        if ( e.getSource() == tool && menu != null )
            menu.setSelected(tool.isSelected());
        action.actionPerformed(e);
    }

    public void setMenuItem(JMenuItem menu)
    {
        this.menu = menu;
        this.menu.addActionListener(this);
    }

    public void setToolItem(JToggleButton tool)
    {
        this.tool = tool;
        this.tool.addActionListener(this);
    }

    public void setSelected(boolean b)
    {
        if ( menu != null ) menu.setSelected(b);
        if ( tool != null ) tool.setSelected(b);
    }

    public boolean isSelected()
    {
        if ( menu != null ) return menu.isSelected();
        if ( tool != null ) return tool.isSelected();
        return false;
    }

    public boolean isSource(ActionEvent e)
    {
        Object  src = e.getSource();
        return src == menu || src == tool;
    }
}
