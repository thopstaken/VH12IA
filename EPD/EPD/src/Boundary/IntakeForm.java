package Boundary;

import Boundary.Common.Filter;

import Boundary.Common.ModifiedFlowLayout;

import com.sun.org.apache.xalan.internal.xsltc.compiler.FlowList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IntakeForm extends JFrame{
    
    private JPanel mContentPanel, mSouthPanel;
    private JButton acceptButton, cancelButton;
    private Container cp;
    
    public IntakeForm() {
        super("Anamnese");
        init();
        
        addAllFormItems();        
        
        setVisible(true);
    }
    
    private void init(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(750,500);
        
        cp = this.getContentPane();
        
        //setup content
        mContentPanel = new JPanel();
        mContentPanel.setLayout(new ModifiedFlowLayout());
        JScrollPane scrollPane  = new JScrollPane(mContentPanel, 
                                                  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                                  JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        //setup southpark
        mSouthPanel = new JPanel();
        mSouthPanel.setLayout(new FlowLayout());
        
        acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        cancelButton = new JButton("Annuleer");
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        mSouthPanel.add(cancelButton);
        mSouthPanel.add(acceptButton);
        
        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(mSouthPanel, BorderLayout.SOUTH);
    }
    
    public void addAllFormItems(){
        addFormItem("Opname datum:", new JTextField(22));
        addFormItem("Afdeling:", new JTextField(22));
        addFormItem("Datum gesprek:", new JTextField(22));
        addFormItem("Gesprek gevoerd door/ met:", new JTextField(22));
        addFormItem("Verantwoordelijk verpleegkundige:", new JTextField(22)); // Aangepast worden naar werknemer object
        addFormItem("Behandelend specialist:", new JTextField(22)); // Zie hierboven
        addFormItem("Opname indicatie (Behandeling + Kamer + Datum + Arts):", new JTextField(22));
        addFormItem("1e Contactpersoon naam:", new JTextField(22));
        addFormItem("1e Contactpersoon relatie:", new JTextField(22));
        addFormItem("1e Contactpersoon adres:", new JTextField(22));
        addFormItem("1e Contactpersoon telefoon:", new JTextField(22));
        addFormItem("Wettelijke Vertegenwoordiger/ 2e Contactpersoon naam:", new JTextField(22));
        addFormItem("2e Contactpersoon relatie:", new JTextField(22));
        addFormItem("2e Contactpersoon adres:", new JTextField(22));
        addFormItem("2e Contactpersoon telefoon:", new JTextField(22));
        addFormItem("Mediche voorgeschiedenis:", new JTextField(22));
        addFormItem("Medicijn naam:", new JTextField(22)); // Aangepast worden naar Medicijn object
        addFormItem("Medicijn dosering:", new JTextField(22)); // navragen
        addFormItem("Medicijn begin- datum:", new JTextField(22));
        addFormItem("Medicijn eind- datum:", new JTextField(22));
        addFormItem("Overgevoelig voor:", new JTextField(22));
        addFormItem("Behandelend arts:", new JTextField(22));
        addFormItem("Vervolgafspraak:", new JTextField(22));
        addFormItem("Eerdere opname buitenland:", new JCheckBox("Ja"));
        addFormItem("MRSA drager:", new JCheckBox("Ja"));
        addFormItem("Spreektaal:", new JTextField(22));
        addFormItem("Gezondheidsbeleving:", new JTextField(22));
        addFormItem("Dieet:", new JTextField(22));
        addFormItem("Normaal Gewicht:", new JTextField(22));
        addFormItem("Gewichtsverloop:", new JTextField(22));
        addFormItem("Misselijkheid/ braken:", new JTextField(22));
        addFormItem("Slikproblemen:", new JTextField(22));
        addFormItem("Conditie huid:", new JTextField(22));
        addFormItem("Conditie haar:", new JTextField(22));
        addFormItem("Conditie nagels:", new JTextField(22));
        addFormItem("Conditie:", new JTextField(22));
        addFormItem("Lengte:", new JTextField(22));
        addFormItem("Onbedoeld gewichtsverlies > 6 kg/ 6 maanden:", new JCheckBox("Ja"));
        addFormItem("Onbedoeld gewichtsverlies > 3 kg/ maand:", new JCheckBox("Ja"));
        addFormItem("Niet of nauwelijks gegeten > 3 dagen en/ of minder gegeten > 1 week:", new JCheckBox("Ja"));
        addFormItem("Gebruik van drink of sondevoeding in de laatste maand:", new JCheckBox("Ja"));
        addFormItem("Bewering - Puntenaantal:", new JTextField(22));
        addFormItem("Decubitus aanwezig:", new JCheckBox("Ja"));
        addFormItem("Decubitus graad:", new JTextField(22));
        addFormItem("Uitscheidingspatroon:", new JTextField(22));
        addFormItem("Activiteitenpatroon wassen:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon aankleden:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon toilet:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon voeding:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon inname medicijnen:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon mobiliteit:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon valt regelmatig:", new JTextField(22));
        addFormItem("Slaap- en rustpatroon:", new JTextField(22));
        addFormItem("Denk- en waarnemingspatroon:", new JTextField(22));
        addFormItem("Noodzaak tot beschermende maatregelen:", new JCheckBox("Ja"));
        addFormItem("Noodzaak tot beschermende maatregelen reden:", new JTextField(22));
        addFormItem("Zelfbelevingspatroon:", new JTextField(22));
        addFormItem("Rol- en relatiepatroon:", new JTextField(22));
        addFormItem("Rol- en relatiepatroon bijzonderheden:", new JTextField(22));
        addFormItem("Seksualiteit- en voortplantingspatroon:", new JTextField(22));
        addFormItem("Patroon van probleemhantering:", new JTextField(22));
        addFormItem("Waarden- en levensovertuigingpatroon:", new JTextField(22));
        addFormItem("Persoonlijke bezittingen en patiënt bij opname:", new JTextField(22)); // Aangepast worden naar list
        addFormItem("Aanvullende informatie:", new JTextField(22));
    }

    /**
     * @param item 
     * Form item that has to be filled in.
     * @param c
     * Component for filling in the form item.
     */
    public void addFormItem(String item, Component c){
        mContentPanel.add(new FormItem(item, c));
    }
    
    class FormItem extends JPanel{
        
        private JLabel mItem;
        
        public FormItem(String item, Component c) {
            setPreferredSize(new Dimension(720, 25));
            setLayout(new GridLayout(1,2));          
            
            mItem = new JLabel(item);
            mItem.setToolTipText(mItem.getText());
            
            add(mItem);
            
            JPanel compPnl = new JPanel();
            compPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
            compPnl.add(c);
            add(compPnl);
            
           
        }
    }
}
