package exercise_2_3;

import com.codeborne.selenide.SelenideElement;
import exercise_2_1.MainPage;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Script extends MainPage {

    private SelenideElement otherTownButton = $(By.xpath("//a[@href='https://auto.drom.ru/cities/']"));
    private SelenideElement searchInput = $(By.xpath("//input[@placeholder='поиск города, региона']"));

    // метод получает на вход список веб-элементов (список марок машин из выпадающего списка)
    public void script(List<SelenideElement> elements) {

        // выбираем на странице Приморский край
        open(getBaseURL());
        searchInput.sendKeys("Приморский край");
        $(By.xpath("//span[.='морский край']")).click();


        // получаем из каждого веб-элемента коллекции текст и заполняем строковый массив
        // (добавляем проверку, что элемент кликабельный)
        // перед этим узнаем длину массива из кликабельных элементов
        int count = 0;

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isEnabled()) {
                count++;
            }
        }

        String[] arrayString = new String[count];

        for (int i = 0; i < arrayString.length; i++) {
            if (elements.get(i).isEnabled()) {
                arrayString[i] = elements.get(i).getText();
            }
        }

        // создаем массив, длина которого равна размеру списка кликабельных веб-элементов
        // у каждого элемента строкового массива вычленяем число (количество объявлений на сайте)
        // заполняем массив значениями
        Integer[] array = new Integer[count];

        for (int i = 0; i < array.length; i++) {
            String s = arrayString[i].replaceAll("[^0-9]", "");
            array[i] = Integer.parseInt(s);
        }

        // сортируем массив по убыванию и создаем новый строковый массив, состоящий из первых 20 значений
        Arrays.sort(array, Collections.reverseOrder());
        String[] arraySort = new String[20];

        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = array[i].toString();
        }

        //создаем массив, в котором содержатся 20 строковых отсортированных значений в формате "марка (кол-во объявлений)"
        String[] finalArray = new String[20];

        for (int i = 0; i < arraySort.length; i++) {
            for (int j = 0; j < arrayString.length; j++) {
                if (arrayString[j].contains(arraySort[i])) {
                    finalArray[i] = arrayString[j];
                }
            }
        }

        // выводим элементы массива на печать в нужном формате
        System.out.println("|\tФирма\t\t\t|\tКоличество объявлений |");

        for (int i = 0; i < finalArray.length; i++) {
            int index = finalArray[i].indexOf('(');
            System.out.println("|\t" + finalArray[i].substring(0, index) + "\t\t\t|\t"
                    + finalArray[i].replaceAll("[^0-9]", "") + "\t|");
        }

    }

}
