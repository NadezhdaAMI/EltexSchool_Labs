package com.company;
//Вариант 2
//        Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.
//        Поля базового класса:
//        ID товара
//        Название
//        Цена
//        Счётчик товаров
//        Фирма
//        Модель
//        ОС
//        ///Поля для телефонов:
//        Тип корпуса (классический, раскладушка)
//       //// Поля для сматфонов:
//        Тип SIM-карты (micro-SIM, обычная)
//        Количество SIM-карт
//       //// Поля для планшетов:
//        Видеопроцессор
//        Разрешение экрана

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner n = new Scanner(System.in);

        System.out.println("Vvedite vid predstavleniya: ");
        int type = n.nextInt();
        System.out.println("Vvedite kol-vo objectov: ");
        int N = n.nextInt();
        if (type == 1){
            while (N != 0)
            {
                Telephone tel = new Telephone();
                tel.create();
                tel.read();
                N--;
//                tel.update();
//                tel.read();
//                N--;
//                tel.delete();
//                tel.read();
                //tel.getCountElectronics();
            }


        } else
        if (type == 2) {
            Smartphone smart = new Smartphone();
        } else
        if (type == 3) {
            Tablet tablet = new Tablet();
        } else
            System.out.println("Not exist!");

        System.out.println("Count = " + Electronics.getCountElectronics());
    }
}

interface ICrudAction {
    void create();
    void read();
    void update();
    void delete();
}

abstract class Electronics {
    UUID IDelectronics;
    String Name;
    int Price;
    String NameCompany;
    String Model;
    String NameOperSystem;
    static int CountElectronics;

    public static final int getCountElectronics(){
        return CountElectronics;
    }

}

class Telephone extends Electronics implements ICrudAction{  //1 type
    enum PhoneCase {classical, clamshell};
    PhoneCase typePhoneCase;
    public String mDevice;



    @Override
    public void create() {
        Random random = new Random();

        IDelectronics = UUID.randomUUID();

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
        mDevice = IDelectronics + ", " + typePhoneCase.toString() + ", "+ Name + ", " + Price + "$, " + NameCompany + ", " + Model + ", " + NameOperSystem;
        System.out.println(mDevice);
    }

    @Override
    public void update() {
        System.out.println("Dobavim object:");
        Scanner n = new Scanner(System.in);
        Name = n.next();
        Price = n.nextInt();
        NameCompany = n.next();
        Model = n.next();
        NameOperSystem = n.next();
        CountElectronics++;
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

}

class Smartphone extends Electronics implements ICrudAction {   //2 type
    enum SimcardCase {usual, micro_Sim};
    SimcardCase TypeofSimcard;
    int countSimcard;
    public String mDevice;

    @Override
    public void create() {
        Random random = new Random();

        IDelectronics = UUID.randomUUID();

        TypeofSimcard = SimcardCase.values()[random.nextInt(SimcardCase.values().length)];

        String[] nameArr = {"Apple", "Samsung", "Nokia", "ASUS"};
        int index_Name = random.nextInt(nameArr.length);
        Name = nameArr[index_Name];

        int[] priceArr = {1400, 1450, 1500, 1700};
        int index_Price = random.nextInt(priceArr.length);
        Price = priceArr[index_Price];

        String[] nameCoArr = {"Apple Co.", "Samsung Co.", "Nokia Co.", "ASUS Co."};
        int index_NameCo = random.nextInt(nameCoArr.length);
        NameCompany = nameCoArr[index_NameCo];

        String[] modelArr = {"sm1", "sm2", "sm3", "sm5"};
        int index_model = random.nextInt(modelArr.length);
        Model = modelArr[index_model];

        String[] NameOperSystemArr = {"5.2", "3.5", "97.8", "3.1"};
        int index_NameOperSystem = random.nextInt(NameOperSystemArr.length);
        NameOperSystem = NameOperSystemArr[index_NameOperSystem];

        CountElectronics++;
    }

    @Override
    public void read() {
        mDevice = IDelectronics + ", " + TypeofSimcard.toString() + ", "+ Name + ", " + Price + "$, " + NameCompany + ", " + Model + ", " + NameOperSystem;
        System.out.println(mDevice);

    }

    @Override
    public void update() {
        System.out.println("Dobavim object:");
        Scanner n = new Scanner(System.in);
        Name = n.next();
        Price = n.nextInt();
        NameCompany = n.next();
        Model = n.next();
        NameOperSystem = n.next();
        CountElectronics++;

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
}

class Tablet extends Electronics implements ICrudAction{ //3 type
    String videoproc;
    int Screenresol;

    @Override
    public void create() {
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

class GenerateID {
    UUID id1 = UUID.randomUUID();
}