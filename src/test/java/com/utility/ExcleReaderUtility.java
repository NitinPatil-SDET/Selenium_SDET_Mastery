package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcleReaderUtility {

    private static final String FILE_PATH =
            System.getProperty("user.dir") + "//testData//Logindataexcel.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    public static List<User> getUserDataFromExcel() {

        List<User> userList = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(new File(FILE_PATH))) {

            XSSFSheet sheet = workbook.getSheet(SHEET_NAME);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue;
                }

                Cell emailaddresscell = row.getCell(0);
                Cell passwordcell = row.getCell(1);

                if (emailaddresscell == null || passwordcell == null) {
                    continue;
                }

                User user = new User(
                        emailaddresscell.toString().trim(),
                        passwordcell.toString().trim()
                );

                userList.add(user);
            }

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException("Failed to read login data from Excel", e);
        }

        return userList;
    }
}
