package com.gries.jchefapp;
import Controllers.FrontEnd;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.InputStream;
public class MyApplication extends Application {
    FrontEnd frontend;
    public MyApplication() {
    }

    public void Load(Context context) {
    try {
        AssetManager manager = context.getAssets();
        InputStream ingredientStream = manager.open("Ingredients.json");
        InputStream tagStream = manager.open("tags.json");
        InputStream recipeStream = manager.open("recipes.json");
        InputStream recipeItemStream = manager.open("recipeItems.json");
        this.frontend = new FrontEnd(ingredientStream, tagStream, recipeItemStream, recipeStream);

    } catch (Exception e) {
        e.printStackTrace();
     }
    }
}

