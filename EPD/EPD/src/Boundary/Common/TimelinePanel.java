package Boundary.Common;

import Entity.BloedDruk;
import Entity.EnumCollection;
import Entity.TimeLineItem;

import com.sun.star.util.DateTime;

import java.awt.BorderLayout;

import java.awt.Color;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TimelinePanel extends JPanel {
    
    private JLabel mType;
    private JLabel mDate;
    private JLabel mTitle;
    private JLabel mDescription;
    private SimpleDateFormat sdf;
    
    public TimelinePanel(TimeLineItem it) {
        setSize(750, 150);
        sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
        mDate = new JLabel(sdf.format(it.getDatum()));
        mTitle = new JLabel(it.getTitel());
        mDescription = new JLabel(it.getOmschrijving());
        mType = new JLabel(it.getType().toString());
        init();
    }
    
    public void init() {
        this.setLayout(new ModifiedFlowLayout());
        this.setBorder(new LineBorder(Color.BLACK));
        this.add(mType, FlowLayout.RIGHT);
        this.add(mDate);
        this.add(mTitle);
        this.add(mDescription);
        
    }
}
