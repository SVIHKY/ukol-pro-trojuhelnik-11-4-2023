import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TriangleApp extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton Button1;
    private JButton Button2;

    private JMenuBar menuBar;


    private JMenu menuFile;
    private JMenu menuFile2;

    private JMenuItem mnuSave;

    private JMenuItem mnuLoad;

    private JMenuItem mnuCopy;

    private JMenuItem mnuBuild;


    public TriangleApp() {

        //menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("Soubor");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);
        mnuSave = new JMenuItem("Uložit");
        menuFile.add(mnuSave);
        mnuLoad = new JMenuItem("Načíst");
        menuFile.add(mnuLoad);
        // dodelat menu Soubor


        menuFile2 = new JMenu("Akce");
        menuFile2.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile2);
        mnuCopy = new JMenuItem("Kopíruj A do B i C");
        menuFile2.add(mnuCopy);
        mnuBuild = new JMenuItem("Lze sestrojit trojúhelník?");
        menuFile2.add(mnuBuild);
        //menu konec



        Button1.addActionListener(this);
        Button2.addActionListener(this);
        mnuSave.addActionListener(this);
        mnuLoad.addActionListener(this);
        mnuCopy.addActionListener(this);
        mnuBuild.addActionListener(this);
        // pokud je tlacitko stisknuto tak generuje akci ktera je v actionPerformed


        }

        //vytvoreni okna

    public static void main(String[] args) {
        TriangleApp t = new TriangleApp();
        t.setContentPane(t.mainPanel);
        t.setVisible(true);
        t.pack();
        t.setTitle("Ukol programko");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }
// metoda actionPerformed() urcuje co maji udelat tlacitka kdyz nane klikneme
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button1 || e.getSource() == mnuCopy) {
            // if funguje pro buuton1 i mnuCopy
            //pri kliknuti na tlacitko kopirovat zkopiruje hodnotu z textField3 do 2 a 1

            textField2.setText(textField3.getText());
            textField1.setText(textField3.getText());
        } else if (e.getSource() == Button2 || e.getSource() == mnuBuild) {
            // if funguje pro buuton2 i mnuBuild
            // pri kliknuti na tlacitko lze sestrojit... zkontoluje zda lze trojuhelnik sestroji
            // dodělat

            try {
                double sideA = Double.parseDouble(textField3.getText());
                double sideB = Double.parseDouble(textField2.getText());
                double sideC = Double.parseDouble(textField1.getText());
                if (sideA + sideB > sideC && sideB + sideC > sideA && sideC + sideA > sideB) {
                    JOptionPane.showMessageDialog(this, "Trojúhelník lze sestrojit.");
                } else {
                    JOptionPane.showMessageDialog(this, "Trojúhelník nelze sestrojit.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Zadejte platné číselné hodnoty.", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}