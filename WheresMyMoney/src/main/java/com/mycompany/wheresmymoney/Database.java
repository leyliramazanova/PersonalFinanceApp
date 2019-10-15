/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wheresmymoney;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Date;


public class Database {
    private String defaultCategoryName = "uncategorized";
    float spendingsLimit;
    float totalSpendings;
    List<Spending> Spendings = new ArrayList<Spending>();
    List<Category> Categories = new ArrayList<Category>();
    
    public Database(){
        Category defaultCat = new Category(defaultCategoryName, Color.GRAY);
        Categories.add(defaultCat);
    }
    
    private void UpdateSpendingCategory(Spending spnd, Category cat){
        spnd.AssignCategory(cat);
        Spendings.add(spnd);
    }
    
    private void UpdateSpendingAmount(Spending spnd, float amt){
        spnd.amount = amt;
        totalSpendings += amt;
    }
    
    private void UpdateSpendingDescription(Spending spnd, String desc){
        spnd.description = desc;
    }
    
    private void MakeSpending(float amt, Date dt, Category cat){
        Spending newSpnd = new Spending(amt, dt, cat);
        Spendings.add(newSpnd);
        totalSpendings += amt;
    }
    
    private void MakeSpending(float amt, Date dt, Category cat, String desc){
        Spending newSpnd = new Spending(amt, dt, cat, desc);
        Spendings.add(newSpnd);
        totalSpendings += amt;
    }
    
    private void MakeCategory(String name, Color col){
        // If the category name is already in the Categories List, give an error
        Category category = new Category(name, col);
        Categories.add(category);
    }
    
    private void UpdateSpendingsLimit(float amt){
        spendingsLimit = amt;
    }
    
    private List<Spending> ReturnSpendingsInCategory(Category cat){
        List<Spending> returnList = new ArrayList<Spending>();
        for (Spending spd : Spendings){
            if (spd.compareTo(cat) == 0){
                returnList.add(spd);
            }
            System.out.println(spd);
        }
        return returnList;
    }
    
    void deleteSpending(Spending spnd){
        totalSpendings -= spnd.amount;
        Spendings.remove(spnd);
    }
    
    void deleteCategory(Category cat){
        if((cat.name.compareTo(defaultCategoryName)!=0)){
            for (Spending spnd : Spendings){
                if (spnd.compareTo(cat) == 0){
                    UpdateSpendingCategory(spnd, Categories.get(0));
                }
            }
            Categories.remove(cat);
        }
    }
}
