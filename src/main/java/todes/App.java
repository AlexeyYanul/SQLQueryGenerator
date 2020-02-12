package todes;

import todes.dao.ExecuteQuery;
import todes.model.enums.Gender;
import todes.query.builder.impl.SQLParam;

import java.util.List;

public class App {

    public static void main(String[] args) {
        SQLParam name = new SQLParam();
        name.setKey("name");
        name.setValue("Мария");

        SQLParam surname = new SQLParam();
        surname.setKey("surname");
        surname.setValue("Морская");

        SQLParam patronomic = new SQLParam();
        patronomic.setKey("patronomic");
        patronomic.setValue("Васильевна");

        SQLParam surnameLike = new SQLParam();
        surnameLike.setKey("surname");
        surnameLike.setValue("%ов");

        SQLParam gender = new SQLParam();
        gender.setKey("gender");
        gender.setValue(Gender.женщина.toString());

        ExecuteQuery executeQuery = new ExecuteQuery();
        List firstTestResult = executeQuery.firstTest(name, surname, patronomic);
        firstTestResult.forEach(System.out::println);

        List secondTestResult = executeQuery.secondTest(surnameLike, gender);
        secondTestResult.forEach(System.out::println);


    }

}
