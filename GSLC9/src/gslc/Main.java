package gslc;

/*
 Nama: Lovina Anabelle Citra
 NIM: 2540121322
 
 Program ini merupakan program untuk memasukkan dan menghapus menu di suatu beverage store
 Program ini juga dapat digunakan untuk menghitung total harga pembelian customer dan menghitung kembalian.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	ArrayList<Drinks> dt = new ArrayList<>();

//	Menampilkan menu pilihan tindakan 
	public Main() {
		int choose;
		do {
			System.out.println("Drinks Palace");
			System.out.println("1. Add Menu");
			System.out.println("2. View Menu");
			System.out.println("3. Buy Menu");
			System.out.println("4. Delete Menu");
			System.out.println("5. Exit");
			System.out.print(">> ");
			choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				Add();
				break;
			case 2:
				View();
				break;
			case 3:
				Buy();
				break;
			case 4:
				Delete();
				break;
			}
		} while (choose != 5);
		System.out.println("Thank you for using this app!!");
	}

	public static void main(String[] args) {
		new Main();
	}

//	Menambahkan menu-menu yang akan ditambahkan
	public void Add() {
		int num = 0;
		String name;
		String type;
		int shots;
		String milk;
		String sugar;
		String topping;
		//menerima input user dan validasi input user
		do {
			System.out.print("Input name: ");
			name = sc.nextLine();
		} while (name.length() < 5 || name.length() > 15);

		do {
			System.out.print("Input beverage type [Espresso|Latte|Sweet Tea|Milk Tea]: ");
			type = sc.nextLine();
		} while (!(type.equals("Espresso") || type.equals("Latte") || type.equals("Sweet Tea")
				|| type.equals("Milk Tea")));
			
//		menerima&validasi input tambahan dan memsukkan menu baru kedalam daftar menu dt(arraylist) yang ada
		if (type.equals("Espresso")) {
			do {
				System.out.print("Input amount of coffee shots: ");
				shots = sc.nextInt();
				sc.nextLine();
			} while (shots < 1 || shots > 5);
			dt.add(new Espresso(num, name, type, shots));
		} else if (type.equals("Latte")) {
			do {
				System.out.print("Input milk type [Normal|Almond|Oats]: ");
				milk = sc.nextLine();
			} while (!(milk.equals("Normal") || milk.equals("Almond") || milk.equals("Oats")));
			dt.add(new Latte(num, name, type, milk));
		} else if (type.equals("Sweet Tea")) {
			do {
				System.out.print("Input amount of sugar [Normal|Less|Half]: ");
				sugar = sc.nextLine();
			} while (!(sugar.equals("Normal") || sugar.equals("Less") || sugar.equals("Half")));
			dt.add(new SweetTea(num, name, type, sugar));
		} else if (type.equals("Milk Tea")) {
			do {
				System.out.print("Input milk tea topping [Bubble|Pudding]:");
				topping = sc.nextLine();
			} while (!(topping.equals("Bubble") || topping.equals("Pudding")));
			dt.add(new MilkTea(num, name, type, topping));
		}

		System.out.println("!!New Beverage Added!!");
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}

//	Menampilkan seluruh data dalam arraylist
	public void View() {
		//cek data ada atau tidak
		if (dt.isEmpty()) {
			System.out.println("There is no beverage");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		} else {
			int test = 1;
			System.out.println("============================================");
			System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", "No.", "Name", "Type", "Price");
			for (Drinks d : dt) {
				d.setNum(test);
				test++;
				System.out.println("--------------------------------------------");
				System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", d.getNum(), d.getName(), d.getType(), d.genPrice());
			}
			System.out.println("============================================");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		}
	}

//	Menu membeli beverage 
	public void Buy() {
		//menampilkan pilihan menu yang ada
		if (dt.isEmpty()) {
			System.out.println("There is no beverage");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		} else {
			int test = 1;
			System.out.println("============================================");
			System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", "No.", "Name", "Type", "Price");
			for (Drinks d : dt) {
				d.setNum(test);
				test++;
				System.out.println("--------------------------------------------");
				System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", d.getNum(), d.getName(), d.getType(), d.genPrice());
			}
			System.out.println("============================================");
			int buy;
			int num;
			int total = 0;
			int paid;
			//meminta memasukkan jumlah beverage yang ingin dibeli
			System.out.print("Bevarage quantity: ");
			buy = sc.nextInt();
			sc.nextLine();
			//melakukan input menu yang ingin dibeli serta melakukan validasi menu yang ingin dibeli satu persatu
			boolean milktea=false;
			for (int i = 0; i < buy; i++) {
				boolean check = false;
				milktea=false;
				do {
					System.out.print("Enter " + (i + 1) + " beverage number to buy: ");
					num = sc.nextInt();
					for (int j = 0; j < dt.size(); j++) {
						if (num == dt.get(j).getNum()) {
							check = true;
							total += dt.get(j).genPrice();//menjumlahkan total harga
							if(dt.get(j).getType().equals("Milk Tea")) {
								milktea=true;
							}
						}
					}
					if (check == false)
						System.out.println("Menu not found");
				} while (check == false);
			}
			//menampilkan total harga akhir
			System.out.println("The total price is " + total);
			if(milktea==true) {
				Special disc=new MilkTea(0, "-", "-","-");
				disc.announce();
				 total=(int)(total-(total*disc.disc()));
				System.out.println("Your final price is "+total);
			}
			System.out.print("Amount paid: ");//menampilkan jumlah yang dibayarkan
			paid = sc.nextInt();
			sc.nextLine();
			System.out.println("Change: " + (paid - total) + "\n");//menampilkan jumlah kembalian

			System.out.println("Thank you for purchasing our beverage");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		}
	}

//Menghapus menu
	public void Delete() {
		if (dt.isEmpty()) {
			System.out.println("There is no beverage");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		} else {
			int test = 1;
			System.out.println("============================================");
			System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", "No.", "Name", "Type", "Price");
			for (Drinks d : dt) {
				d.setNum(test);
				test++;
				System.out.println("--------------------------------------------");
				System.out.printf("|%-4s|%-17s|%-10s|%-8s|\n", d.getNum(), d.getName(), d.getType(), d.genPrice());
			}
			System.out.println("============================================");
			
			int del;
			boolean flag = false;
			//menerima input dari user dan  melakukan validasi input kemudian menghapus menu pilihan dari daftar menu
			do {
				System.out.print("Enter menu number to delete: ");
				del = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < dt.size(); i++) {
					if (del == dt.get(i).getNum()) {
						flag = true;
						System.out.println("Menu " + dt.get(i).getName() + " has been removed from the menu.");
						dt.remove(i);
					}
				}
			} while (flag == false);
			
			System.out.println("Press enter to continue...");
			sc.nextLine();
		}
	}
}
