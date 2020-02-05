package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller{
	AddressBook book;
	View view;


	public Controller(AddressBook aBook, View aView)
	{
		book = aBook;
		view = aView;
		view.addNewMenuListener(new NewListener());
		view.addOpenMenuListener(new OpenListener());
		view.addSaveMenuListener(new SaveListener());
		view.addAddBuddyMenuListener(new AddBuddyListener());
		view.addRemoveBuddyMenuListener(new RemoveBuddyListener());
		view.addChangeNameMenuListener(new ChangeNameListener());
	}

	class NewListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			book = new AddressBook();
			view.setBook(book);
			view.updateUI();
		}

	}
	class OpenListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			book = new AddressBook();
			//book.convertFromXML(view.getFile());
			view.setBook(book);
			view.updateUI();
		}


	}
	class SaveListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {

		}

		//@Override
		/*public void actionPerformed(ActionEvent e) {
			try {
				view.saveFile(book.convertToXML());
			} catch (IOException e1) {

				e1.printStackTrace();
			}


		}*/

	}
	class AddBuddyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			book.addBuddy(view.getBuddyInfo());
			view.updateUI();
		}

	}
	class RemoveBuddyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			book.removeBuddy(view.getIndexToRemove());
			view.updateUI();
		}

	}
	class ChangeNameListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//book.setName(view.getNameInput());
			view.updateUI();
		}

	}




}
