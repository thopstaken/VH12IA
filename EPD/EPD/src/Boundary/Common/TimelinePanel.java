package Boundary.Common;

import Control.BloedDrukControl;

import Entity.BloedDruk;
import Entity.EnumCollection;
import Entity.TimeLineItem;

import com.sun.star.util.DateTime;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;

import java.awt.font.TextLayout;

import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class TimelinePanel extends JPanel implements MouseListener{
    
    private JLabel mType;
    private TimeLineItem mItem;
    private JLabel mDate;
    private JLabel mTitle;
    private JTextArea mDescription;
    private SimpleDateFormat sdf;
    
    public TimelinePanel(TimeLineItem it) {
        addMouseListener(this);
        setSize(750, 150);
        mItem = it;
        sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
        mDate = new JLabel(sdf.format(it.getDatum()));
        mTitle = new JLabel(it.getTitel());
        mDescription = new JTextArea(it.getOmschrijving());
        mDescription.setBackground(Color.LIGHT_GRAY);
        mDescription.setEditable(false);
        mDescription.setPreferredSize(new Dimension(750, 50));
        mDescription.setLineWrap(true);
        
        mType = new JLabel(it.getType().toString());
        init();
    }
    
    public void init() {
        this.setLayout(new ModifiedFlowLayout());
        this.setBorder(new LineBorder(Color.BLACK));
        this.add(mType);
        this.add(mDate);
        this.add(mTitle);
        this.add(mDescription);
            
        this.setBackground(Color.LIGHT_GRAY);
    }
    
    public void mouseClicked(MouseEvent e) {
        System.out.println("Loggin Click event");
        if(e.getClickCount() >= 2) {
            System.out.println("Loggin Click event 2");
           if(mItem.getType().equals(EnumCollection.timeLineType.bloedDrukMeting)) {
              BloedDruk b = (BloedDruk)  mItem.getActionFromTimeLineItem();
              BloedDrukControl bdc = BloedDrukControl.getInstance(); 
              bdc.openBloedDrukRaport(b);
           }   
            
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    
    
}
