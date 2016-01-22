package com.jrecipe.model.domain;

import java.io.Serializable;
import java.util.List;
import com.jrecipe.model.domain.Recipe;

public class RecipeGroup implements Serializable {
    
    private Integer uid;
    
    private String name;
    
    private List<Recipe> recipes;
    
    public RecipeGroup() { }
    
    public RecipeGroup(Integer uid, String name, List<Recipe> recipes) {
        this.uid = uid;
        this.name = name;
        this.recipes = recipes;
    }
    
    public Integer getUid() { return this.uid; }
    
    public void setUid(Integer uid ) { this.uid = uid; }
    
    public String getName() { return this.name; }
    
    public void setName(String name) {this.name = name;}
    
    public List getRecipes() { return this.recipes; }
    
    public void setRecipes(List<Recipe> recipes)  { this.recipes = recipes; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecipeGroup {\n");
            builder.append("\t uid " + this.uid + "\n");
            builder.append("\t name " + this.name + "\n");
            for(Recipe recipe : this.getRecipes()) {
                builder.append("\t" + this.recipe.toString() + "\n");
            }
        builder.append("}\n");
        return builder.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(obj == this) {
            return true;
        }
        
        if( ! (obj instanceof RecipeGroup)) {
            return false;
        }
        
        RecipeGroup o = (RecipeGroup) obj;
        
        return ((this.getUid().equals(o.getUid())) &&
                (this.getName().equals(o.getName())) &&
                (this.getRecipes().equals(o.getRecipes())));
                
    }
}