package editor1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditorGui extends JFrame {

	private JPanel contentPane;
	private MultipleChoicePaneAdv multiChoice;
	private TrueFalsePane trueFalse;
	public GiftFormatter EditorFormatter;
	ExitAction exitAction;

	/**
	 * Create the frame.
	 */
	public EditorGui() {
		super("Moodle Editor");
		
		// create new formatter
		EditorFormatter = new GiftFormatter();
		
		// find installed look & feels set to 'Nimbus' if available.
		String select = "Nimbus";
		try {
			
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				System.out.println("INSTALLED THEME'S: " + info.getName());
				if (select.equals(info.getName())) {
//					System.out.println("'" + select + "' FOUND & SET");
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (Exception e1) {
			// If Nimbus is not available, fall back to cross-platform
			System.out.println(select + " LOOK & FEEL NOT FOUND, SETTING TO DEFAULT");
			try{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				System.out.println("LOOK & FEEL SET TO DEFAULT");
			}catch (Exception e2) {
				// TODO: handle exception
				System.out.println("ERROR ROLLING BACK LOOK & FEEL");
			}
			
		}
		
		// get screen dimensions & center window on screen
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setBounds(12, 12, dimension.width - 25, dimension.height - 60);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JToolBar navToolBar = new JToolBar();
		navToolBar.setOrientation(0);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		// create actions
		exitAction = new ExitAction();
		
		// add actions to navbar & filemenu
		navToolBar.add(exitAction);
		fileMenu.add(exitAction);
		
		// set up menu bar, add filemenu
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		// get the content pane and set up GUI
		Container c = getContentPane();
		c.add(navToolBar, BorderLayout.NORTH);
		c.add(contentPane, BorderLayout.CENTER);
		
		// create tabbed pane & add tabs
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("True/False", createTrueFalseQ()); // create & add true/false frame
		tabbedPane.add("Multiple Choice", createMultiChoiceQ()); // create & add true/false frame
		
		c.add(tabbedPane); // add tab to super in this case a JFrame
		
		// ## add some test tabs
//		testTabs(tabbedPane);

		// register for windowClosing event in case user
		// does not select Exit from File menu to terminate
		// application
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				shutDown();
			}
		});
		
	}

	private JPanel createMultiChoiceQ() {
		multiChoice = new MultipleChoicePaneAdv(EditorFormatter);
		return multiChoice;
		// TODO Auto-generated method stub
	}

	private JPanel createTrueFalseQ() {
		trueFalse = new TrueFalsePane(EditorFormatter);
		return trueFalse;
		// TODO Auto-generated method stub
	}

//	private void testTabs(JTabbedPane tabbedPane) {
//		ArrayList<JComponent> tabs = new ArrayList<JComponent>();
//		tabs.add(makeTextPanel("TEST PANEL #1"));
//		tabs.add(makeTextPanel("TEST PANEL #2"));
//		tabs.add(makeTextPanel("TEST PANEL #3"));
//		tabs.add(makeTextPanel("TEST PANEL #4"));
//		
//		for (int ii = 0; ii < 4; ii++) {
//			tabbedPane.addTab("Tab " + (ii + 1), null, tabs.get(ii), "Test Tab " + ii);
//		}
//        
//	}
	
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = EditorGui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	private void shutDown() {
		System.out.println("Program Shutdown");
		System.exit(0); // terminate program
	}
	
	// user defined actions
	private class ExitAction extends AbstractAction {

		// set up action's name, descriptions and mnemonic
		public ExitAction() {
			putValue(NAME, "Exit");
			putValue(SMALL_ICON, new ImageIcon(getClass().getResource("images/Exit.png")));
			putValue(SHORT_DESCRIPTION, "Exit");
			putValue(LONG_DESCRIPTION, "Terminate the program");
			putValue(MNEMONIC_KEY, new Integer('e'));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Program Shutting Down...");
			shutDown();
			
		}
	} // end inner class ExitAction

}

/************************************************************************
 * Copyright (2012 - 2013) Derek O'Connor.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************/