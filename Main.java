package ru.geekbrains;

public class Main {

    public static void main(String[] args) {

	    Plate plateForAll = new Plate(55);
	    catsArray();
	    feedCats(catsArray(), plateForAll);

	    plateForAll.addFood(40);
    }

    public static Cat[] catsArray() {
		Cat[] cats = new Cat[5];
		cats[0] = new Cat("Kitty", 15);
		cats[1] = new Cat("Lilly", 22);
		cats[2] = new Cat("Bella", 13);
		cats[3] = new Cat("Leo", 18);
		cats[4] = new Cat("Lucy", 27);
		return cats;
	}

	public static void feedCats(Cat[] cats, Plate plate) {
		for (int i = 0; i < cats.length; i++) {
			cats[i].eat(plate);
			System.out.println("Cat is full: " + cats[i].isFullness());
			plate.info();
			System.out.println();
		}
	}
}
