package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


class Telephone extends Electronics implements ICrudAction {  //1 type
    enum PhoneCase {classical, clamshell};
    PhoneCase typePhoneCase;
    public String mDevice;

    public Telephone(UUID ID) {
        super(ID);
    }

    @Override
    public void create() {
        Random random = new Random();
        typePhoneCase = PhoneCase.values()[random.nextInt(PhoneCase.values().length)];

        String[] nameArr = {"Apple", "Samsung", "Nokia", "ASUS"};
        int index_Name = random.nextInt(nameArr.length);
        Name = nameArr[index_Name];

        int[] priceArr = {400, 450, 500, 700};
        int index_Price = random.nextInt(priceArr.length);
        Price = priceArr[index_Price];

        String[] nameCoArr = {"Apple Co.", "Samsung C.", "Nokia C.", "ASUS C."};
        int index_NameCo = random.nextInt(nameCoArr.length);
        NameCompany = nameCoArr[index_NameCo];

        String[] modelArr = {"x1", "x2", "x3", "x5"};
        int index_model = random.nextInt(modelArr.length);
        Model = modelArr[index_model];

        String[] NameOperSystemArr = {"7.2", "8.5", "9.8", "9.1"};
        int index_NameOperSystem = random.nextInt(NameOperSystemArr.length);
        NameOperSystem = NameOperSystemArr[index_NameOperSystem];

        CountElectronics++;
    }

    @Override
    public void read() {

        mDevice = IDelectronics + ", " + typePhoneCase.toString() + ", " + Name + ", " + Price + "$, " + NameCompany + ", " + Model + ", " + NameOperSystem;
        System.out.println(mDevice);
    }

    @Override
    public void update() {
        System.out.println("Добавим объект:");
        Scanner n = new Scanner(System.in);
        System.out.println("Введите имя: ");
        Name = n.next();
        System.out.println("Введите цену: ");
        Price = n.nextInt();
        System.out.println("Введите название компании: ");
        NameCompany = n.next();
        System.out.println("Введите модель: ");
        Model = n.next();
        System.out.println("Введите название ОС: ");
        NameOperSystem = n.next();

        CountElectronics++;

        System.out.println("Объект добавлен!");
    }

    @Override
    public void delete() {
        Name = null;
        Price = 0;
        NameCompany = null;
        Model = null;
        NameOperSystem = null;
        CountElectronics--;
    }

    @Override
    public String toString() {
        return "Telephone: " + IDelectronics + ", " + typePhoneCase.toString() + ", "
                + Name + ", " + Price + "$, " + NameCompany
                + ", " + Model + ", " + NameOperSystem + "\n";
    }
}
