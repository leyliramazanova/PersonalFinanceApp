package com.example.whereismymoney;

import android.graphics.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatabaseTests {

    private static final String otherCategoryName = "Other";
    private static final String categoryName = "Test";
    private static final Color categoryColor = Color.valueOf(Color.GRAY);
    private static final Color otherCategoryColor = Color.valueOf(Color.RED);
    private static final float spendingAmount = 10f;
    private static final float newSpendingAmount = 20f;
    private static final float newSpendingsLimit = 50f;
    private static final Date spendingDate = Date.from(Instant.parse("2007-12-03T10:15:30.00Z"));
    private static final Category spendingCategory = new Category(categoryName, categoryColor);
    private static final Category otherCategory = new Category(otherCategoryName, categoryColor);
    private static final Spending firstSpending = new Spending(spendingAmount, spendingDate, spendingCategory);
    private static final Database ins = new Database();

    public DatabaseTests(){
    }


    @Test
    public void testUpdateSpendingCategory() {
        ins.UpdateSpendingCategory(firstSpending, otherCategory);
        Category res = firstSpending.category;
        assertEquals(res.name, otherCategoryName);
    }

    @Test
    public void testUpdateSpendingAmount() {
        ins.UpdateSpendingAmount(firstSpending, newSpendingAmount);
        float res = firstSpending.amount;
        assertEquals(res, newSpendingAmount);
    }

    @Test
    public void testMakeSpending() {
        ins.MakeSpending(spendingAmount, spendingDate, spendingCategory);
        assertEquals(ins.Spendings.size(), 1);
        assertEquals(ins.totalSpendings, ins.Spendings.get(0));
    }

    @Test
    public void testMakeCategory() {
        ins.MakeCategory(categoryName, categoryColor);
        assertEquals(ins.Categories.size(), 1);
        assertEquals(ins.categoryMap.get(categoryName), ins.Categories.get(0));
    }

    @Test
    public void testUpdateSpendingsLimit() {
        ins.UpdateSpendingsLimit(newSpendingsLimit);
        assertEquals(ins.spendingsLimit, newSpendingsLimit);
    }

    @Test
    public void testReturnSpendingsInCategory() {
        ins.MakeSpending(spendingAmount, spendingDate, spendingCategory);
        ins.MakeSpending(newSpendingAmount, spendingDate, spendingCategory);
        List<Spending> res = ins.ReturnSpendingsInCategory(spendingCategory);
        assertEquals(res.size(), 2);
        assertEquals(res.get(0).amount, spendingAmount);
        assertEquals(res.get(1).amount, newSpendingAmount);
    }

    @Test
    public void testSumOfSpendingsInCategory() {
        ins.MakeSpending(spendingAmount, spendingDate, spendingCategory);
        ins.MakeSpending(newSpendingAmount, spendingDate, spendingCategory);
        float res = ins.SumOfSpendingsInCategory(spendingCategory);
        assertEquals(res, spendingAmount+newSpendingAmount);
    }

    @Test
    public void testGetCategoryColors() {
        ins.MakeCategory(categoryName, categoryColor);
        ins.MakeCategory(otherCategoryName, otherCategoryColor);
        int[] res = ins.getCategoryColors();
        assertEquals(res.length, 2);
        assertEquals(res[0], categoryColor.toArgb());
        assertEquals(res[1], otherCategoryColor.toArgb());
    }
}