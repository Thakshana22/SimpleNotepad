import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad extends JPanel { // Changed from Component to JPanel

    JTextArea textArea;
    JFileChooser fileChooser;
    JFrame frame; // Added frame reference

    public NotePad(){
        //Set up the main window
        frame = new JFrame("Notepad"); // Added frame reference
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Create components
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        fileChooser = new JFileChooser();

        //Create File menu
        JMenuBar menuBar = new JMenuBar();

        //Create File menu
        JMenu fileMenu = new JMenu("Open"); // Added proper File menu


        //Create File menu items
        JMenuItem openItem = new JMenuItem("Open"); // Changed from JMenu to JMenuItem
        JMenuItem saveItem = new JMenuItem("Save"); // Changed from JMenu to JMenuItem
        JMenuItem exitItem = new JMenuItem("Exit"); // Changed from JMenu to JMenuItem

        //Add action Listeners
        openItem.addActionListener(new OpenAction());
       saveItem.addActionListener(new SaveAction());
        exitItem.addActionListener(e -> System.exit(0));


        //fileMenu1.addActionListener(new OpenAction());
        //fileMenu2.addActionListener(new SaveAction());
        //fileMenu3.addActionListener(e -> System.exit(0));


        /*&Create File menu
        JMenu fileMenu1 = new JMenu("Open"); // Added proper File menu
        JMenu fileMenu2 = new JMenu("Save"); // Added proper File menu
        JMenu fileMenu3 = new JMenu("Exit"); // Added proper File menu

         */

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        //Add file menu to menubar
        menuBar.add(fileMenu);



        //Set menu bar
        frame.setJMenuBar(menuBar); // Changed from setJMenuBar to frame.setJMenuBar

        // Add text area to content
        frame.add(scrollPane, BorderLayout.CENTER); // Added frame.add

        //Make the window visible
        frame.setVisible(true);
    }

    //Action for opening a file
    private class OpenAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int returnVal = fileChooser.showOpenDialog(NotePad.this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader,null);
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(NotePad.this,
                            "Error opening file "+ex.getMessage(),
                            "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Action for saving a file
    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int returnVal = fileChooser.showSaveDialog(NotePad.this); // Added file chooser dialog
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(writer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(NotePad.this,
                            "Error saving file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Use the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and show the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new NotePad());
    }
}