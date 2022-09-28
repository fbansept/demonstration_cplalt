package edu.fbansept.demonstration_cplalt;

import org.json.JSONException;
import org.json.JSONObject;

public class Product {

    protected int id;
    protected String title;
    protected String description;
    protected float price;

    public Product(int id, String title, String description, float price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Product(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.title = json.getString("title");
        this.description = json.getString("description");
        this.price = (float) json.getDouble("price");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
