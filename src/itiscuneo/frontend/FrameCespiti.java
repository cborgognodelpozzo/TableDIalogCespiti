package itiscuneo.frontend;

import itiscuneo.backend.ElencoCespiti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCespiti extends JFrame implements ActionListener {
    private final ElencoCespiti elencoCespiti;
    private JButton btnNuovo;
    private DefaultTableModel dtmCespiti;
    private JTable tableCespiti;

    public FrameCespiti() throws HeadlessException {
        super("Gestione cespiti");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Breakpoint: step into and step over
        //tracing(line to line) and watches (visualizzare stato oggetto)
        elencoCespiti = new ElencoCespiti();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        JPanel panelTable = new JPanel();

        String[] aHeaderTableCespiti = {"codice", "quantita", "data acquisto"};
        dtmCespiti = new DefaultTableModel(aHeaderTableCespiti, 0); //in memoria video
        tableCespiti= new JTable( dtmCespiti );
        panelTable.add(new JScrollPane( tableCespiti));


        JPanel panelCmd = new JPanel();
        //panelCmd.setLayout(new BorderLayout(4, 1));
        btnNuovo = new JButton("Nuovo");
        panelCmd.add(btnNuovo);
        btnNuovo.addActionListener(this);

        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelCmd, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNuovo){
            new DialogCespiti(this).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FrameCespiti().setVisible(true);
    }
}
