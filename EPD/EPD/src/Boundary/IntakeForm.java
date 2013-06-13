package Boundary;

import Boundary.Common.Filter;

import Boundary.Common.ModifiedFlowLayout;

import Control.GUIController;

import Control.PatientController;

import Entity.Patient;

import com.sun.org.apache.xalan.internal.xsltc.compiler.FlowList;

import com.sun.star.util.DateTime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.util.Calendar;
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;

public class IntakeForm extends JFrame {

    private JPanel mContentPanel, mSouthPanel;
    private JButton acceptButton, cancelButton;
    private Container cp;
    
    private GUIController guiControl;

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
                                  verslavingLijst, allergieLijst, afd, achterNaam, voorNaam, tussenVoegsel, gebDt, geslacht, arts, 
                                 patientNr, afspraakId;
    
    private JCheckBox opnameBuitenlandInd,  mrsaDrager, onbGewVerlies6kgInd, onbGewVerlies3kgInd, gebrSondeInd, decubitusInd,
        actPatrWassenInd, actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd, actPatrVoedingInd,
        noodzBeschMaatrInd, nietOfnauwelijksgeg;

    //End anamnese insert fields


    public IntakeForm(GUIController guiControl) {
        super("Anamnese");
        this.guiControl = guiControl;
        init();
        
        opnameDt = new JTextField(22);
        seksualiteit = new JTextField(22);
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
        actPatrValtRegInd = new JTextField(22);
        slaapRustPatroon = new JTextField(22);
        denkWaarnPatr = new JTextField(22);
        noodzBeschMaatrReden = new JTextField(22);
        rolRelatiePatroon = new JTextField(22);
        rolRelatiePatrBijz = new JTextField(22);
        patrProbleemhant = new JTextField(22);
        waardenLevensovertuigPatr = new JTextField(22);
        persBezittingen = new JTextField(22);
        bijzonderheden = new JTextField(22);
        gebDt = new JTextField(22);
        patientNr = new JTextField(22);
        voorNaam = new JTextField(22);
        tussenVoegsel = new JTextField(22);
        achterNaam = new JTextField(22);
        opnameDt = new JTextField(22);
        afspraakId = new JTextField(22);
        
        opnameBuitenlandInd = new JCheckBox("Ja");
        mrsaDrager = new JCheckBox("Ja");
        onbGewVerlies6kgInd = new JCheckBox("Ja");
        onbGewVerlies3kgInd = new JCheckBox("Ja");
        gebrSondeInd = new JCheckBox("Ja");
        decubitusInd = new JCheckBox("Ja");
        actPatrWassenInd = new JCheckBox("Ja");
        actPatrAankledenInd = new JCheckBox("Ja");
        actPatrToiletInd = new JCheckBox("Ja");
        actPatrVoedingInd = new JCheckBox("Ja");
        actPatrInameMedInd = new JCheckBox("Ja");
        actPatrMobInd = new JCheckBox("Ja");
        noodzBeschMaatrInd = new JCheckBox("Ja");
        nietOfnauwelijksgeg = new JCheckBox("Ja");
        
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
                   /* boolean anamnese =
                        guiControl.createAnamnese(patientNr.getText(), achterNaam.getText(), voorNaam.getText(), 
                                                  afd.getText(), gebDt.getText(), 
                                                  geslacht.getText(), opnameDt.getText(), arts.getText(), 
                                                  actPatrAankledenInd.isSelected(), actPatrInameMedInd.isSelected(), 
                                                  actPatrMobInd.isSelected(), actPatrToiletInd.isSelected(), 
                                                  actPatrValtRegInd.getText(), actPatrVoedingInd.isSelected(), 
                                                  actPatrWassenInd.isSelected(), afspraakId.getText(), allergieId.getText(), behandArts.getText(), behSpecId.getText(), beroep.getText(), 
                                                  beschrijvingZiektebeeld.getText(), bijzonderheden.getText(), conditie.getText(), condHaar.getText(), condHuid.getText(), 
                                                  condNagels.getText(), datumGesprekDt.getText(), decubitusGraad.getText(), decubitusInd.isSelected(), denkWaarnPatr.getText(), 
                                                  dieet.getText(), eenConAdres.getText(), eenConNaam.getText(), eenConRelatie.getText(), eenConTel.getText(), gebrSondeInd.isSelected(), 
                                                  gespreksvoerderId.getText(), gewicht.getText(), gewichtsverloop.getText(), gezonheidsbeleving.getText(), lengte.getText(), 
                                                  medEindDt.getText(), medGesch.getText(), medNaam.getText(), medStartDt.getText(), misselijkBraken.getText(), mrsaDrager.getText(), 
                                                  noodzBeschMaatrInd.isSelected(), noodzBeschMaatrReden.getText(), onbGewVerlies3kgInd.isSelected(), 
                                                  onbGewVerlies6kgInd.isSelected(), opnameBuitenlandInd.isSelected(), opnameDt.getText(), overGevoelVoor.getText(), 
                                                  patrProbleemhant.getText(), persBezittingen.getText(), puntenaant.getText(), rolRelatiePatroon.getText(), 
                                                    rolRelatiePatrBijz.getText(), seksualiteit.getText(), seksualiteitInd.getText(), slaapRustPatroon.getText(), 
                                                  slikproblemen.getText(), spreektaal.getText(), tweeConAdres.getText(), tweeConNaam.getText(), tweeConRelatie.getText(), 
                                                  tweeConTel.getText(), uitschPatroon.getText(), verantwVerplId.getText(), verslavingId.getText(), vervolgafspraak.getText(), 
                                                  waardenLevensovertuigPatr.getText(), zelfbelevingspatr.getText(), verslavingLijst.getText(), allergieLijst.getText());
                    if(anamnese){
                        dispose();
                    }else{
                        
                    } */
                    Patient patient = new Patient();
                    patient.setFirstName(voorNaam.getText());
                    patient.setPatientNumber(patientNr.getText());
                    patient.setPrefix(tussenVoegsel.getText());
                    patient.setSurName(achterNaam.getText());
                    patient.setGender(seksualiteit.getText());
                    patient.setDateOfBirth(Calendar.getInstance());
                    patient.setDeceased(0);
                    patient.setActive(1);
                    patient.setUserId(0);
                    patient.setDepartmentId(Integer.parseInt(afd.getText()));
                    Patient addPatient =
                        guiControl.addPatient(patient);
                    
                    String[] headers = {"PatiŽntnummer", "Achternaam", "Voornaam", "Afdeling", "Geboortedatum", "Geslacht", "Opnamedatum", "Arts"};
                    DefaultTableModel mTableModel =
                        new DefaultTableModel(guiControl.getPatientList(), headers)
                        {
                            @Override
                                public boolean isCellEditable(int row, int column) {
                                   //all cells false
                                   return false;
                                }
                        };
                    guiControl.setUserTableModel(mTableModel);
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
        //addFormItem("Afspraak id:", afspraakId);
        addFormItem("Sofinummer:", patientNr);
        addFormItem("Voornaam:", voorNaam);
        addFormItem("Tussenvoegsel:", tussenVoegsel);
        addFormItem("Achternaam:", achterNaam);
        addFormItem("Opname datum:", opnameDt);
        addFormItem("Afdeling:", afd);
        addFormItem("Geboortedatum:", gebDt);
        addFormItem("Geslacht:", seksualiteit);
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
                    nietOfnauwelijksgeg);
        addFormItem("Gebruik van drink of sondevoeding in de laatste maand:",
                    gebrSondeInd);
        addFormItem("Bewering - Puntenaantal:", puntenaant);
        addFormItem("Decubitus aanwezig:", decubitusInd);
        addFormItem("Decubitus graad:", decubitusGraad);
        addFormItem("Uitscheidingspatroon:", uitschPatroon);
        addFormItem("Activiteitenpatroon wassen:", actPatrWassenInd);
        addFormItem("Activiteitenpatroon aankleden:", actPatrAankledenInd);
        addFormItem("Activiteitenpatroon toilet:", actPatrToiletInd);
        addFormItem("Activiteitenpatroon voeding:", actPatrVoedingInd);
        addFormItem("Activiteitenpatroon inname medicijnen:",
                    actPatrInameMedInd);
        addFormItem("Activiteitenpatroon mobiliteit:", actPatrMobInd);
        addFormItem("Activiteitenpatroon valt regelmatig:",
                    actPatrValtRegInd);
        addFormItem("Slaap- en rustpatroon:", slaapRustPatroon);
        addFormItem("Denk- en waarnemingspatroon:", denkWaarnPatr);
        addFormItem("Noodzaak tot beschermende maatregelen:",
                    noodzBeschMaatrInd);
        addFormItem("Noodzaak tot beschermende maatregelen reden:",
                    noodzBeschMaatrReden);
        //addFormItem("Zelfbelevingspatroon:", zelfbelevingspatr);
        addFormItem("Rol- en relatiepatroon:", rolRelatiePatroon);
        addFormItem("Rol- en relatiepatroon bijzonderheden:",
                    rolRelatiePatrBijz);
//        addFormItem("Seksualiteit- en voortplantingspatroon:",
//                    seksualiteit);
        addFormItem("Patroon van probleemhantering:", patrProbleemhant);
        addFormItem("Waarden- en levensovertuigingpatroon:",
                    waardenLevensovertuigPatr);
        addFormItem("Persoonlijke bezittingen en patiŽnt bij opname:",
                    persBezittingen); // Aangepast worden naar list
        addFormItem("Aanvullende informatie:", bijzonderheden);
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
