/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogue;

import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public class ItemGroup {
    private int copiesAvailabe;
    private ArrayList mingzi = new  ArrayList<CatalogueItem>();
    private String itemName;
    
    public ItemGroup(String name){
        itemName=name;
    }
}
