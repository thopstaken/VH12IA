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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IntakeForm extends JFrame {

    private JPanel mContentPanel, mSouthPanel;
    private JButton acceptButton, cancelButton;
    private Container cp;

    //Start anamnese insert fields
    private JTextField      actPatrValtRegInd, afsprDt,
                                  allergieId, behandArts, behSpecId, beroep, beschrijvingZiektebeeld,
                                  bijzonderheden, conditie, condHaar, condHuid, condNagels,
                                  datumGesprekDt, decubitusGraad, denkWaarnPatr, dieet,
                                  eenConAdres, eenConNaam, eenConRelatie, eenConTel,  
                                  gespreksvoerderId, gewicht, gewichtsverloop, gezonheidsbeleving, lengte, 
                                  medEindDt, medGesch, medNaam, medStartDt, misselijkBraken,
                                  noodzBeschMaatrReden, opnameInd,  
                                   opnameDt, overGevoelVoor,
                                  patrProbleemhant, persBezittingen, puntenaant, rolRelatiePatroon, rolRelatiePatrBijz,
                                  seksualiteit, seksualiteitInd, slaapRustPatroon, slikproblemen, spreektaal,
                                  tweeConAdres, tweeConNaam, tweeConRelatie, tweeConTel, uitschPatroon, verantwVerplId,
                                  verslavingId, vervolgafspraak, waardenLevensovertuigPatr, zelfbelevingspatr,
                                  verslavingLijst, allergieLijst, afd, achterNaam, voorNaam, gebDt, geslacht, arts;
    
    private JCheckBox opnameBuitenlandInd,  mrsaDrager, onbGewVerlies6kgInd, onbGewVerlies3kgInd, gebrSondeInd, decubitusInd,
        actPatrWassenInd, actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd, actPatrVoedingInd,
        noodzBeschMaatrInd, nietOfnauwelijksgeg;

    //End anamnese insert fields


    public IntakeForm() {
        super("Anamnese");
        init();
        
        opnameDt = new JTextField(22);
        afd = new JTextField(22);
        afsprDt = new JTextField(22);
        gespreksvoerderId = new JTextField(22);
        verantwVerplId = new JTextField(22);
        behSpecId = new JTextField(22);
        opnameInd = new JTextField(22);
        eenConNaam = new JTextField(22);
        eenConAdres = new JTextField(22);
        eenConRelatie = new JTextField(22);
        eenConTel = new JTextField(22);
        tweeConNaam = new JTextField(22);
        tweeConRelatie = new JTextField(22);
        tweeConAdres = new JTextField(22);
        tweeConTel = new JTextField(22);
        medGesch = new JTextField(22);
        medNaam = new JTextField(22);
        medStartDt = new JTextField(22);
        medEindDt = new JTextField(22);
        overGevoelVoor = new JTextField(22);
        behandArts = new JTextField(22);
        vervolgafspraak = new JTextField(22);
        spreektaal = new JTextField(22);
        gezonheidsbeleving = new JTextField(22);
        dieet = new JTextField(22);
        gewicht = new JTextField(22);
        gewichtsverloop = new JTextField(22);
        misselijkBraken = new JTextField(22);
        slikproblemen = new JTextField(22);
        condHuid = new JTextField(22);
        condHaar = new JTextField(22);
        condNagels = new JTextField(22);
        conditie = new JTextField(22);
        lengte = new JTextField(22);
        puntenaant = new JTextField(22);
        uitschPatroon = new JTextField(22);
        decubitusGraad = new JTextField(22);
        
        opnameBuitenlandInd = new JCheckBox("Ja");
        mrsaDrager = new JCheckBox("Ja");
        onbGewVerlies6kgInd = new JCheckBox("Ja");
        onbGewVerlies3kgInd = new JCheckBox("Ja");
        gebrSondeInd = new JCheckBox("Ja");
        decubitusInd = new JCheckBox("Ja");
        
        
        addAllFormItems();

        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(750, 500);

        cp = this.getContentPane();

        //setup content
        mContentPanel = new JPanel();
        mContentPanel.setLayout(new ModifiedFlowLayout());
        JScrollPane scrollPane =
            new JScrollPane(mContentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //setup southpark
        mSouthPanel = new JPanel();
        mSouthPanel.setLayout(new FlowLayout());

        acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    dispose();
                }
            });
        cancelButton = new JButton("Annuleer");
        cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

        mSouthPanel.add(cancelButton);
        mSouthPanel.add(acceptButton);

        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(mSouthPanel, BorderLayout.SOUTH);
    }

    public void addAllFormItems() {
        addFormItem("Opname datum:", opnameDt);
        addFormItem("Afdeling:", afd);
        addFormItem("Datum gesprek:", afsprDt);
        addFormItem("Gesprek gevoerd door/ met:", gespreksvoerderId);
        addFormItem("Verantwoordelijk verpleegkundige:",
                    verantwVerplId); // Aangepast worden naar werknemer object
        addFormItem("Behandelend specialist:",
                    behSpecId); // Zie hierboven
        addFormItem("Opname indicatie (Behandeling + Kamer + Datum + Arts):",
                    opnameInd);
        addFormItem("1e Contactpersoon naam:", eenConNaam);
        addFormItem("1e Contactpersoon relatie:", eenConRelatie);
        addFormItem("1e Contactpersoon adres:", eenConAdres);
        addFormItem("1e Contactpersoon telefoon:", eenConTel);
        addFormItem("Wettelijke Vertegenwoordiger/ 2e Contactpersoon naam:",
                   tweeConNaam);
        addFormItem("2e Contactpersoon relatie:", tweeConRelatie);
        addFormItem("2e Contactpersoon adres:", tweeConAdres);
        addFormItem("2e Contactpersoon telefoon:", tweeConTel);
        addFormItem("Mediche voorgeschiedenis:", medGesch);
        addFormItem("Medicijn naam:", medNaam); // Aangepast worden naar Medicijn object
        addFormItem("Medicijn dosering:", new JTextField(22)); // navragen
        addFormItem("Medicijn begin- datum:", medStartDt);
        addFormItem("Medicijn eind- datum:", medEindDt);
        addFormItem("Overgevoelig voor:", overGevoelVoor);
        addFormItem("Behandelend arts:", behandArts);
        addFormItem("Vervolgafspraak:", vervolgafspraak);
        addFormItem("Eerdere opname buitenland:", opnameBuitenlandInd);
        addFormItem("MRSA drager:", mrsaDrager);
        addFormItem("Spreektaal:", spreektaal);
        addFormItem("Gezondheidsbeleving:", gezonheidsbeleving);
        addFormItem("Dieet:", dieet);
        addFormItem("Normaal Gewicht:", gewicht);
        addFormItem("Gewichtsverloop:", gewichtsverloop);
        addFormItem("Misselijkheid/ braken:", misselijkBraken);
        addFormItem("Slikproblemen:", slikproblemen);
        addFormItem("Conditie huid:", condHuid);
        addFormItem("Conditie haar:", condHaar);
        addFormItem("Conditie nagels:", condNagels);
        addFormItem("Conditie:", conditie);
        addFormItem("Lengte:", lengte);
        addFormItem("Onbedoeld gewichtsverlies > 6 kg/ 6 maanden:",
                    onbGewVerlies6kgInd);
        addFormItem("Onbedoeld gewichtsverlies > 3 kg/ maand:",
                    onbGewVerlies3kgInd);
        addFormItem("Niet of nauwelijks gegeten > 3 dagen en/ of minder gegeten > 1 week:",
                    new JCheckBox("Ja"));
        addFormItem("Gebruik van drink of sondevoeding in de laatste maand:",
                    gebrSondeInd);
        addFormItem("Bewering - Puntenaantal:", puntenaant);
        addFormItem("Decubitus aanwezig:", decubitusInd);
        addFormItem("Decubitus graad:", decubitusGraad);
        addFormItem("Uitscheidingspatroon:", uitschPatroon);
        addFormItem("Activiteitenpatroon wassen:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon aankleden:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon toilet:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon voeding:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon inname medicijnen:",
                    new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon mobiliteit:", new JCheckBox("Ja"));
        addFormItem("Activiteitenpatroon valt regelmatig:",
                    new JTextField(22));
        addFormItem("Slaap- en rustpatroon:", new JTextField(22));
        addFormItem("Denk- en waarnemingspatroon:", new JTextField(22));
        addFormItem("Noodzaak tot beschermende maatregelen:",
                    new JCheckBox("Ja"));
        addFormItem("Noodzaak tot beschermende maatregelen reden:",
                    new JTextField(22));
        addFormItem("Zelfbelevingspatroon:", new JTextField(22));
        addFormItem("Rol- en relatiepatroon:", new JTextField(22));
        addFormItem("Rol- en relatiepatroon bijzonderheden:",
                    new JTextField(22));
        addFormItem("Seksualiteit- en voortplantingspatroon:",
                    new JTextField(22));
        addFormItem("Patroon van probleemhantering:", new JTextField(22));
        addFormItem("Waarden- en levensovertuigingpatroon:",
                    new JTextField(22));
        addFormItem("Persoonlijke bezittingen en patiënt bij opname:",
                    new JTextField(22)); // Aangepast worden naar list
        addFormItem("Aanvullende informatie:", new JTextField(22));
    }

    /**
     * @param item
     * Form item that has to be filled in.
     * @param c
     * Component for filling in the form item.
     */
    public void addFormItem(String item, Component c) {
        mContentPanel.add(new FormItem(item, c));
    }

    class FormItem extends JPanel {

        private JLabel mItem;

        public FormItem(String item, Component c) {
            setPreferredSize(new Dimension(720, 25));
            setLayout(new GridLayout(1, 2));

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
