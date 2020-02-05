package app;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;
import java.util.List;


public class View extends JFrame {
	
	private AddressBook openedBook;
	private JPanel topPanel = new JPanel();
	
    private JMenuItem newMenuItem = new JMenuItem("New");
    private JMenuItem openMenuItem = new JMenuItem("Open");
    private JMenuItem saveMenuItem = new JMenuItem("Save as...");
    private JMenuItem addBuddy = new JMenuItem("Add buddy");
    private JMenuItem removeBuddy = new JMenuItem("Remove buddy");
    private JMenuItem changeNameItem = new JMenuItem("Change Book Name");
    private JList BuddyList;
    private JLabel BookTitleLabel = new JLabel("Book Name: ");
	
	public View(AddressBook aBook)
	{
		setBook(aBook);
		initUI();
	}
	
	private void initUI() {		
		createMenuBar();
        setTitle("Address Book User Interface");
		BookTitleLabel.setAlignmentX(CENTER_ALIGNMENT);
		topPanel.add(BookTitleLabel);
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		topPanel.add(new JScrollPane(BuddyList));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(topPanel);
		setMinimumSize(new Dimension(500,500));
		updateUI();
		setVisible(true);
	}
	private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        //New
        newMenuItem.setToolTipText("Makes a new book");
        //Open
        openMenuItem.setToolTipText("Open a file");
        //New
        saveMenuItem.setToolTipText("Save the file");
        
    
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        
        
        JMenu buddiesMenu = new JMenu("Edit Book");
        buddiesMenu.add(addBuddy);
        buddiesMenu.add(removeBuddy);
        buddiesMenu.add(changeNameItem);

        menubar.add(fileMenu);
        menubar.add(buddiesMenu);
        setJMenuBar(menubar);
    }

	public void addNewMenuListener(ActionListener listener)
	{
		newMenuItem.addActionListener(listener);
	}
	public void addOpenMenuListener(ActionListener listener)
	{
		openMenuItem.addActionListener(listener);
	}
	public void addSaveMenuListener(ActionListener listener)
	{
		saveMenuItem.addActionListener(listener);
	}
	public void addAddBuddyMenuListener(ActionListener listener)
	{
		addBuddy.addActionListener(listener);
	}
	public void addRemoveBuddyMenuListener(ActionListener listener)
	{
		removeBuddy.addActionListener(listener);
	}
	public void addChangeNameMenuListener(ActionListener listener)
	{
		changeNameItem.addActionListener(listener);
	}
	public void setBook(AddressBook openedBook) {
		this.openedBook = openedBook;
	}

	public File getFile() {
		
		JFileChooser d1 = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml", "XML");
		d1.setFileFilter(filter);
		
		if (d1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			return d1.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	
	/*public void saveFile(String[] lines) throws IOException {
		JFileChooser d1 = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml", "XML");
		d1.setFileFilter(filter);
		
		if (d1.showSaveDialog(this)== JFileChooser.APPROVE_OPTION)
		{
			try(FileWriter fw = new FileWriter(d1.getSelectedFile()+".XML")) {
			    for (String line : lines)
			    {
			    	fw.write(line + "\n");
			    }
			    fw.close();
			}
		}
		
	}*/

	public BuddyInfo getBuddyInfo() {
		BuddyInfo temp = new BuddyInfo();
        String Name = JOptionPane.showInputDialog("Enter Name:");
        String Number = JOptionPane.showInputDialog("Enter Number:");
        String Email = JOptionPane.showInputDialog("Enter Email:");
		temp.setName(Name);
		//temp.setNumber(Number);
		//temp.setEmail(Email);
		return temp;
	}

	public int getIndexToRemove() {
		
		return BuddyList.getSelectedIndex();
	}
	public void updateUI()
	{
		BookTitleLabel.setText("Book Name: BOOK");
		List<BuddyInfo> tempBuddies = openedBook.getBuddyInfos();
		String[] temp = new String[tempBuddies.size()];
		for(int i = 0; i < tempBuddies.size();i++)
		{
			
			temp[i] = ("Name: " + tempBuddies.get(i).getName() + ", Number: " + tempBuddies.get(i).getPhoneNumber() + ", Email: ");
		}
		
		
		BuddyList = new JList(temp);
		
		topPanel.remove(1);
		topPanel.add(new JScrollPane(BuddyList));
		
		pack();
		
	}

	public String getNameInput() {
		
		String input = JOptionPane.showInputDialog("Enter New Name:");
		return input;
	}


}
