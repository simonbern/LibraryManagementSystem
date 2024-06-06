package Interface;

import java.util.Scanner;

import Library.book;

public class Driver {
	public static void main(String[] args) {

		int choice;
		final int password = 249;
		int passwordinput = 0;
		boolean repeat = true;
		boolean accessGranted = false;
		int i;

		Library.items[] inventory = new Library.items[1];
		Clients.client[] clients = new Clients.client[1];
		Library.items[] books = new Library.book[1];

		System.out.println("do you wand to access the library system or run a demonstration?");
		System.out.println("    1. run a demonstration");
		System.out.println("    2. access the library system");
		Scanner s1 = new Scanner(System.in);
		i = s1.nextInt();
		if (i == 1) {
			Library.items[] inventory1 = new Library.items[9];
			Clients.client[] clients1 = new Clients.client[3];
			Library.items[] books1 = new Library.items[3];
			Library.items[] journals = new Library.items[3];
			Library.items[] media = new Library.items[3];

			inventory1[0] = books1[0] = new Library.book("The Alchemist", "Paulo Coelho", 1988, 163);
			inventory1[1] = books1[1] = new Library.book("The Da Vinci Code", "Dan Brown", 2003, 689);
			inventory1[2] = books1[2] = new Library.book("The Da Vinci Code", "Dan Brown", 2003, 689);
			inventory1[3] = journals[0] = new Library.journal("Nature", "Nature", 2021, 1);
			inventory1[4] = journals[1] = new Library.journal("Nature", "Nature", 2021, 1);
			inventory1[5] = journals[2] = new Library.journal("plos one", "plos", 2021, 1);
			inventory1[6] = media[0] = new Library.media("The Alchemist", "Paulo Coelho", 1988, "audio");
			inventory1[7] = media[1] = new Library.media("The Da Vinci Code", "Dan Brown", 2003, "video");
			inventory1[8] = media[2] = new Library.media("The Da Vinci Code", "Dan Brown", 2003, "video");
			clients1[0] = new Clients.client("Ahmed", 123456789, "ahm@gmail.com");
			clients1[1] = new Clients.client("Ali", 123456789, "ali@gmail.com");
			clients1[2] = new Clients.client("bruno", 123456789, "bruno@gmail.com");

			for (int j = 0; j < inventory1.length; j++) {
				if (inventory1[j] != null) {
					System.out.println(inventory1[j]);
				}
			}
			for (int j = 0; j < clients1.length; j++) {
				if (clients1[j] != null) {
					System.out.println(clients1[j]);
				}
			}
			System.out.println("is item 3 equal to item 9?");
			boolean b = inventory1[2].equals(inventory1[8]);
			System.out.println(b);

			System.out.println("is item 2 equal to item 3?");
			boolean b2 = inventory1[1].equals(inventory1[2]);
			System.out.println(b2);

			System.out.println("is item 1 equal to item 2?");
			boolean b3 = inventory1[0].equals(inventory1[1]);
			System.out.println(b3);

			System.out.println("what is the biggest book?");
			System.out.println(getBiggestBook(inventory1).toString());

			System.out.println("a copy of the list of media was created successfully");
			Library.items[] copyMedia = copyBooks(media);
		} else {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("welcome to the library system");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			Scanner s = new Scanner(System.in);

			System.out.print("Password: ");

			while (!accessGranted) {
				if (s.nextInt() != password) {
					System.out.println("wrong password, try again");
				} else {
					accessGranted = true;
				}
			}

			while (repeat) {

				System.out.println("What do you want to do?");
				System.out.println("    1. Add or delete an item");
				System.out.println("    2. Change item information");
				System.out.println("    3. list items");
				System.out.println("    4. add, delete or edit a client");
				System.out.println("    5. lease or return an item");
				System.out.println("    6. show leased items");
				System.out.println("    7. display the biggest book");
				System.out.println("    8. copy the list of books");
				System.out.println("    9. Quit  ");
				System.out.println("Please enter your choice >");

				choice = s.nextInt();

				switch (choice) {

					case 1:
						int choice1;
						System.out.println("Add or delete an item");
						System.out.println("    1. Add an item");
						System.out.println("    2. Delete an item");
						System.out.println("    3. back");
						System.out.println("Please enter your choice >");
						choice1 = s.nextInt();
						switch (choice1) {
							case 1:// add an item
								System.out.println("What type of item do you want to add?");
								System.out.println("    1. Book");
								System.out.println("    2. Journal");
								System.out.println("    3. Media");
								System.out.println("    4. back");
								int choice11 = s.nextInt();
								switch (choice11) {
									case 1: // add a book
										System.out.println("Enter the name, author, year and number of pages of the book >");

										String junk = s.nextLine();
										String name = s.nextLine();
										String author = s.nextLine();
										int year = s.nextInt();
										int pages = s.nextInt();
										if (books[0] == null && inventory[0] == null) {
											books[0] = inventory[0] = new Library.book(name, author, year, pages);// add the book to the inventory and the books list
										} else {
											Library.items[] newArray = new Library.items[inventory.length + 1];
											Library.items[] newBookArray = new Library.book[books.length + 1];

											for (int j = 0; j < inventory.length; j++) {
												newArray[j] = inventory[j];
											}
											for (int j = 0; j < books.length; j++) {
												newBookArray[j] = books[j];
											}
											inventory = newArray;
											books = newBookArray;
											inventory[inventory.length - 1] = books[books.length - 1] = new Library.book(name, author, year, pages);// add the book to the inventory and the books list

										}
										break;
									case 2:// add a journal
										System.out.println("Enter the name, author, year and volume number of the journal >");
										String junk2 = s.nextLine();
										String name2 = s.nextLine();
										String author2 = s.nextLine();
										int year2 = s.nextInt();
										int volumeNumber = s.nextInt();
										if (inventory[0] == null) {
											inventory[0] = new Library.journal(name2, author2, year2, volumeNumber);
										} else {
											Library.items[] newArray = new Library.items[inventory.length + 1];
											for (int j = 0; j < inventory.length; j++) {
												newArray[j] = inventory[j];
											}
											inventory = newArray;
											inventory[inventory.length - 1] = new Library.journal(name2, author2, year2, volumeNumber);
										}
										break;
									case 3:// add a media

										System.out.println("Enter the name, author, year and volume number of the media >");
										String junk3 = s.nextLine();
										String name3 = s.nextLine();
										String author3 = s.nextLine();
										int year3 = s.nextInt();
										String type = s.next();
										if (inventory[0] == null) {
											inventory[0] = new Library.media(name3, author3, year3, type);
										} else {
											Library.items[] newArray = new Library.items[inventory.length + 1];
											for (int j = 0; j < inventory.length; j++) {
												newArray[j] = inventory[j];
											}
											inventory = newArray;
											inventory[inventory.length - 1] = new Library.media(name3, author3, year3, type);
										}

										break;
									case 4:// back
										break;
									default:// invalid choice
										System.out.println("Invalid choice");
								}
								break;
							case 2:// delete an item

								System.out.println("Enter the ID of the item you want to delete >");
								String IDdelete = s.next();
								boolean Ifound = false;// item found
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] == null) {
										continue;
									} else if (inventory[j].getID().equals(IDdelete)) {
										Ifound = true;
										if (inventory.length == 1) {
											inventory[0] = null;
										} else {
											Library.items[] newArray = new Library.items[inventory.length - 1];
											for (int k = 0; k < inventory.length; k++) {
												if (inventory[k].getID().equals(IDdelete)) {
													continue;
												} else {
													newArray[k] = inventory[k];
												}
											}
											inventory = newArray;
										}
									}
								}
								if (Ifound && IDdelete.charAt(0) == 'B') {
									if (books.length == 1) {
										books[0] = null;
									} else {
										Library.book[] newBooksArray = new Library.book[books.length - 1];
										for (int k = 0; k < books.length; k++) {
											if (books[k].getID().equals(IDdelete)) {
												continue;
											} else {
												newBooksArray[k] = (Library.book) inventory[k];
											}
										}
										books = newBooksArray;
									}
								}
								if (!Ifound) {
									System.out.println("No item with that ID was found");
								}
								break;
							case 3:// back
								break;
							default:// invalid choice
								System.out.println("Invalid choice");
								break;
						}

						break;
					case 2:// change item information
						boolean found = false;
						System.out.println("Enter the ID of the item you want to edit >");
						String IDedit = s.next();
						for (int j = 0; j < inventory.length; j++) {
							if (inventory[j] == null) {
								continue;
							} else {
								if (inventory[j].getID().equals(IDedit)) {
									found = true;
									if (inventory[j] instanceof Library.book) {
										System.out.println("What do you want to edit?");
										System.out.println("    1. Name");
										System.out.println("    2. Author");
										System.out.println("    3. Year");
										System.out.println("    4. Number of pages");
										System.out.println("    5. back");
										int choice21 = s.nextInt();
										switch (choice21) {
											case 1:// edit name
												System.out.println("Enter the new name >");
												String newName = s.next();
												inventory[j].setName(newName);
												break;
											case 2:// edit author
												System.out.println("Enter the new author >");
												String newAuthor = s.next();
												inventory[j].setAuthor(newAuthor);
												break;
											case 3:// edit year
												System.out.println("Enter the new year >");
												int newYear = s.nextInt();
												inventory[j].setYear(newYear);
												break;
											case 4:// edit number of pages
												System.out.println("Enter the new number of pages >");
												int newPages = s.nextInt();
												((Library.book) inventory[j]).setNumberOfPages(newPages);
												break;
											case 5:// back
												break;
											default:// invalid choice
												System.out.println("Invalid choice");
										}
									} else if (inventory[j] instanceof Library.journal) {
										System.out.println("What do you want to edit?");
										System.out.println("    1. Name");
										System.out.println("    2. Author");
										System.out.println("    3. Year");
										System.out.println("    4. Volume number");
										System.out.println("    5. back");
										int choice21 = s.nextInt();
										switch (choice21) {
											case 1:// edit name
												System.out.println("Enter the new name >");
												String newName = s.next();
												inventory[j].setName(newName);
												break;
											case 2:// edit author
												System.out.println("Enter the new author >");
												String newAuthor = s.next();
												inventory[j].setAuthor(newAuthor);
												break;
											case 3:// edit year
												System.out.println("Enter the new year >");
												int newYear = s.nextInt();
												inventory[j].setYear(newYear);
												break;
											case 4:// edit volume number
												System.out.println("Enter the new volume number >");
												int newVolumeNumber = s.nextInt();
												((Library.journal) inventory[j]).setVolumeNumber(newVolumeNumber);
												break;
											case 5:// back
												break;
											default:// invalid choice
												System.out.println("Invalid choice");
										}
									} else if (inventory[j] instanceof Library.media) {
										System.out.println("What do you want to edit?");
										System.out.println("    1. Name");
										System.out.println("    2. Author");
										System.out.println("    3. Year");
										System.out.println("    4. Type");
										System.out.println("    5. back");
										int choice21 = s.nextInt();
										switch (choice21) {
											case 1:// edit name
												System.out.println("Enter the new name >");
												String newName = s.next();
												inventory[j].setName(newName);
												break;
											case 2:// edit author
												System.out.println("Enter the new author >");
												String newAuthor = s.next();
												inventory[j].setAuthor(newAuthor);
												break;
											case 3:// edit year
												System.out.println("Enter the new year >");
												int newYear = s.nextInt();
												inventory[j].setYear(newYear);
												break;
											case 4:// edit type
												System.out.println("Enter the new type >");
												String newType = s.next();
												((Library.media) inventory[j]).setType(newType);
												break;
											case 5:// back
												break;
											default:// invalid choice
												System.out.println("Invalid choice");
										}
									}

								}
							}
						}
						if (!found) {
							System.out.println("No item with that ID was found");
						}
						break;
					case 3:// list items
						System.out.println("what do you want to list?");
						System.out.println("    1. Books");
						System.out.println("    2. Journals");
						System.out.println("    3. Media");
						System.out.println("    4. All items");
						System.out.println("    5. back");
						int choice3 = s.nextInt();
						switch (choice3) {
							case 1:// list books
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] instanceof Library.book) {
										System.out.println(inventory[j].toString());
									}
								}
								break;
							case 2:// list journals
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] instanceof Library.journal) {
										System.out.println(inventory[j].toString());
									}
								}
								break;
							case 3:// list media
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] instanceof Library.media) {
										System.out.println(inventory[j].toString());
									}
								}
								break;
							case 4:// list all items
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] != null) {
										System.out.println(inventory[j].toString());
									}
								}
								break;
							case 5:// back
							default:// invalid choice
								System.out.println("Invalid choice");
						}

						break;
					case 4:// add, delete or edit a client
						System.out.println("What do you want to do?");
						System.out.println("    1. Add a client");
						System.out.println("    2. Delete a client");
						System.out.println("    3. Edit a client");
						System.out.println("    4. back");
						int choice4 = s.nextInt();
						switch (choice4) {
							case 1:// add a client
								System.out.println("Enter the name, phone number and email of the client >");
								String junk = s.nextLine();
								String name = s.nextLine();
								long phone = s.nextLong();
								String email = s.next();
								if (clients[0] == null) {
									clients[0] = new Clients.client(name, phone, email);
								} else {
									Clients.client[] newArray = new Clients.client[clients.length + 1];
									for (int j = 0; j < clients.length; j++) {
										newArray[j] = clients[j];
									}
									clients = newArray;
									clients[clients.length - 1] = new Clients.client(name, phone, email);
								}
								break;
							case 2:// delete a client
								System.out.println("Enter the ID of the client you want to delete >");
								boolean deleted = false;
								long IDdelete = s.nextLong();
								for (int j = 0; j < clients.length; j++) {
									if (clients[j] == null) {
										continue;
									} else if (clients[j].getClientID() == IDdelete) {
										if (clients.length == 1) {
											clients[0] = null;
										} else {
											Clients.client[] newArray = new Clients.client[clients.length - 1];
											for (int k = 0; k < clients.length; k++) {
												if (clients[k].getClientID() == IDdelete) {
													continue;
												} else {
													newArray[k] = clients[k];
												}
											}
											clients = newArray;
										}
										deleted = true;
									}
								}

								if (deleted)
									System.out.println("The client with id " + IDdelete + "was successfully deleted");
								else
									System.out.println("No client with that ID was found");
								break;
							case 3:// edit a client
								System.out.println("Enter the ID of the client you want to edit >");
								boolean edited = false;
								long CIDedit = s.nextLong();// Client ID edit
								for (int j = 0; j < clients.length; j++) {
									if (clients[j] == null) {
										continue;
									} else if (clients[j].getClientID() == CIDedit) {
										edited = true;
										System.out.println("What do you want to edit?");
										System.out.println("    1. Name");
										System.out.println("    2. Phone number");
										System.out.println("    3. Email");
										System.out.println("    4. back");

										int choice41 = s.nextInt();
										switch (choice41) {
											case 1:// edit name
												System.out.println("Enter the new name >");
												String newName = s.next();
												clients[j].setName(newName);
												System.out.println("The name was successfully changed to " + newName);
												break;
											case 2:// edit phone number
												System.out.println("Enter the new phone number >");
												long newPhone = s.nextLong();
												clients[j].setPhone(newPhone);
												System.out.println(
														"The phone number was successfully changed to " + newPhone);
												break;
											case 3:// edit email
												System.out.println("Enter the new email >");
												String newEmail = s.next();
												clients[j].setEmail(newEmail);
												System.out.println("The email was successfully changed to " + newEmail);
												break;
											case 4:// back
												break;
											default:// invalid choice
												System.out.println("Invalid choice");
										}
									}
								}
								if (!edited)
									System.out.println("No client with that ID was found");

								break;
							case 4:// back
								break;
							default:// invalid choice
								System.out.println("Invalid choice");
						}
						break;
					case 5:// lease or return an item
						System.out.println("What do you want to do?");
						System.out.println("    1. Lease an item");
						System.out.println("    2. Return an item");
						System.out.println("    3. back");
						int choice5 = s.nextInt();
						switch (choice5) {
							case 1:// lease an item
								System.out.println("Enter the ID of the item you want to lease >");
								String IDlease = s.next();
								boolean Cfound = false;// client found
								boolean Ifound = false;// item found
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] == null) {
										continue;
									} else if (inventory[j].getID().equals(IDlease)) {
										Ifound = true;
										System.out.println(
												"Enter the ID of the client who wants to lease the item >");
										long CIDlease = s.nextLong();// Client ID lease
										for (int k = 0; k < clients.length; k++) {
											if (clients[k] == null) {
												continue;
											} else if (clients[k].getClientID() == CIDlease) {
												Cfound = true;
												if (inventory[j].getAvailable()) {
													inventory[j].setAvailable(false);
													clients[k].leaseItem(inventory[j]);
													inventory[j].setCID(clients[k].getClientID());
													System.out.println("The item was successfully leased to "
															+ clients[k].getName());
												} else {
													System.out.println("The item is not available");
												}
											}
										}
									}
								}
								if (!Cfound) {
									System.out.println("No client with that ID was found");
								}
								if (!Ifound) {
									System.out.println("No item with that ID was found");
								}

								break;
							case 2:// return an item
								System.out.println("Enter the ID of the item you want to return >");
								String IDreturn = s.next();
								boolean Ifound2 = false;// item found
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] == null) {
										continue;
									} else if (inventory[j].getID().equals(IDreturn)) {
										Ifound2 = true;
										if (!inventory[j].getAvailable()) {
											inventory[j].setAvailable(true);
											for (int k = 0; k < clients.length; k++) {
												if (clients[k] == null) {
													continue;
												} else if (clients[k].getClientID() == inventory[j].getCID()) {
													clients[k].returnItem(inventory[j]);
													inventory[j].setCID(0);
													System.out.println("The item was successfully returned by " + clients[k].getName());
												}
											}

										} else {
											System.out.println("The item is already available");
										}
									}
								}
								if (!Ifound2) {
									System.out.println("No item with that ID was found");
								}

								break;
							case 3:// back
								break;
							default:// invalid choice
								System.out.println("Invalid choice");
						}
						break;
					case 6:// show leased items
						System.out.println("What do you want to do?");
						System.out.println("    1. Show leased items of a client");
						System.out.println("    2. Show all leased items");
						System.out.println("    3. back");
						int choice6 = s.nextInt();
						switch (choice6) {
							case 1:// show leased items of a client
								System.out.println("Enter the ID of the client whose leased items you want to show >");
								long CIDshow = s.nextLong();// Client ID show
								boolean Cfound = false;// client found
								for (int j = 0; j < clients.length; j++) {
									if (clients[j] == null) {
										continue;
									} else if (clients[j].getClientID() == CIDshow) {
										Cfound = true;
										if (clients[j].leasedItems[0] == null) {
											System.out.println("The client has no leased items");
										} else {
											for (int k = 0; k < clients[j].leasedItems.length; k++) {
												if (clients[j].leasedItems[k] != null) {
													System.out.println(clients[j].leasedItems[k].toString());
												}
											}
										}
									}
								}
								if (!Cfound) {
									System.out.println("No client with that ID was found");
								}
								break;
							case 2:// show all leased items
								boolean found2 = false; // if there are no leased items
								for (int j = 0; j < inventory.length; j++) {
									if (inventory[j] == null) {
										continue;
									} else if (!inventory[j].getAvailable()) {
										found2 = true;
										System.out.println(inventory[j].toString());
									}
								}
								if (!found2) {
									System.out.println("No items are leased");
								}
								break;
							case 3:// back
								break;
							default:// invalid choice
								System.out.println("Invalid choice");
						}
						break;
					case 7:// display the biggest book
						if (books[0] == null) {
							System.out.println("There are no books in the inventory");
						} else
							System.out.println(getBiggestBook(books).toString());
						break;
					case 8:// copy the list of books
						Library.items[] copyBooks = copyBooks(books);
						System.out.println("A deep copy of the list of books was successfully created");
						break;
					case 9:// Quit
						System.out.println("Program terminated, Bye bye");
						repeat = false;
						break;

				}

			}

		}
	}

	public static Library.book getBiggestBook(Library.items[] inventory) {
		boolean found3 = false;// if there are no books in the inventory
		int bcount = 0;// to keep track of how many books of the inventory have been checked
		Library.items biggest = null;
		for (int j = 1; j < inventory.length; j++) {
			if (inventory[j] instanceof Library.book) {
				found3 = true;
				bcount++;
				if (bcount == 1) {
					biggest = inventory[j];
				} else if (inventory[j].getNumberOfPages() > biggest.getNumberOfPages()) {
					biggest = inventory[j];
				}
			}
		}
		if (!found3) {
			Library.book nobooks = new book();
			return (nobooks);
		} else {
			return (Library.book) biggest;
		}
	}

	public static Library.items[] copyBooks(Library.items[] books) {
		Library.items[] copyBooks = new Library.items[books.length];
		for (int j = 0; j < books.length; j++) {
			copyBooks[j] = books[j];
		}
		return copyBooks;
	}
}