/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.DecisionTree;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Acer
 */
public class ConsoleJtextArea extends OutputStream {

    private JTextArea textControl;
    
    /**
     * Creates a new instance of TextAreaOutputStream which writes
     * to the specified instance of javax.swing.JTextArea control.
     *
     * @param control   A reference to the javax.swing.JTextArea
     *                  control to which the output must be redirected
     *                  to.
     */
    public ConsoleJtextArea( JTextArea control ) {
        textControl = control;
    }
    
    /**
     * Writes the specified byte as a character to the 
     * javax.swing.JTextArea.
     *
     * @param   b   The byte to be written as character to the 
     *              JTextArea.
     */
    public void write( int b ) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append( String.valueOf( ( char )b ) );
    }   
    public static void main(String[] args) {
        
        try {
            // Create an instance of javax.swing.JTextArea control
    JTextArea txtConsole = new JTextArea();

     AffichageDecisionTree p=new AffichageDecisionTree(new F2(new princ(),false,"","","",""), true,new DecisionTree());
    PrintStream out;
            out = new PrintStream( new ConsoleJtextArea( p.ProfilDecTree) );
    p.setVisible(true);
    // redirect standard output stream to the TextAreaOutputStream
    System.setOut( out );

    // redirect standard error stream to the TextAreaOutputStream
    System.setErr( out );

    // now test the mechanism
    System.out.println( "Hello World" );
        } catch (IOException ex) {
            Logger.getLogger(ConsoleJtextArea.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
