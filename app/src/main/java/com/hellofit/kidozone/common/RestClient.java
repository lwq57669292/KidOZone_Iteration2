package com.hellofit.kidozone.common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hellofit.kidozone.entity.*;

public class RestClient {

    private final static String BASE_URL = "http://3.105.242.54:8080/HellofitWebServer/webresources/";

    /**
     * To retrieve food data from the server
     * 3 food entities for each category (7 category in total)
     *
     * @return json string
     */
    public static String getRandomFood() {
        final String methodPath = "com.kidozone.entity.foodinfo/findFoodRandomly";
        URL url = null;
        HttpURLConnection connection = null;
        String jsonString = "";
        try {
            url = new URL(BASE_URL + methodPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                jsonString += scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return jsonString;
    }

    /**
     * To parse the json string of FoodInfo and return a list
     *
     * @param foodJson
     * @return list of foodInfo
     */
    public static ArrayList<FoodInfo> parseFoodJson (String foodJson) {
        ArrayList<FoodInfo> foodInfos = new ArrayList<FoodInfo>();
        try {
            JSONArray jsonArray = new JSONArray(foodJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                FoodInfo food = new FoodInfo();
                food.setId(String.valueOf(jsonObject.getInt("id")));
                food.setFoodName(jsonObject.getString("foodname"));
                food.setFoodImage(jsonObject.getString("foodimagepath"));
                JSONObject categoryObj = jsonObject.getJSONObject("foodcategory");
                food.setCategoryName(categoryObj.getString("foodcategoryname"));
                foodInfos.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodInfos;
    }

    /**
     * To retrieve waste data from the server
     * Pick 10 waste entities from the Database
     *
     * @return json string
     */
    public static String getRandomWaste() {
        final String methodPath = "com.kidozone.entity.wasteinfo/findWasteRandomly";
        URL url = null;
        HttpURLConnection connection = null;
        String jsonString = "";
        try {
            url = new URL(BASE_URL + methodPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                jsonString += scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return jsonString;
    }


    /**
     * To parse the json string of WasteInfo and return a list
     *
     * @param wasteJson
     * @return
     */
    public static ArrayList<WasteInfo> parseWasteJson(String wasteJson) {
        ArrayList<WasteInfo> wasteInfos = new ArrayList<WasteInfo>();
        try {
            JSONArray jsonArray = new JSONArray(wasteJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                WasteInfo waste = new WasteInfo();
                waste.setId(jsonObject.getString("id"));
                waste.setWasteName(jsonObject.getString("wastename"));
                waste.setWasteImage(jsonObject.getString("wasteimagepath"));
                JSONObject categoryObj = jsonObject.getJSONObject("wastecategory");
                waste.setCategoryName(categoryObj.getString("wastecategoryname"));
                wasteInfos.add(waste);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasteInfos;
    }

    /**
     * Using the suburb name to retrieve the school which locate in that suburb
     * @param suburbName
     * @return json string
     */
    public static String getSchoolInfo(String suburbName) {
        URL url = null;
        HttpURLConnection connection = null;
        String jsonString = "";
        suburbName = suburbName.toUpperCase();
        try{
            url = new URL(BASE_URL + "com.kidozone.entity.schoolinfo/findSchoolBySuburb/" + suburbName);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                jsonString += scanner.nextLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return jsonString;
    }

    /**
     * Using the json String to parse to the SchoolInfo class
     * @param schoolJson
     * @return The array list containing all school entities
     */
    public static List<SchoolInfo> parseSchoolJson(String schoolJson){
        List<SchoolInfo> schoolInfos = new ArrayList<SchoolInfo>();
        try{
            JSONArray jsonArray = new JSONArray(schoolJson);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                SchoolInfo info = new SchoolInfo();
                info.setSchoolName(obj.getString("school_name"));
                info.setSchoolAddress(obj.getString("address_line"));
                info.setSchoolPhone(obj.getString("full_phone_no"));
                info.setSchoolSuburb(obj.getString("suburb"));
                info.setSchoolPostcode(obj.getString("postal_postcode"));
                double lat = Double.parseDouble(obj.getString("latitude"));
                double lon = Double.parseDouble(obj.getString("longitude"));
                Coordinate coo = new Coordinate(lon, lat);
                info.setSchoolCoordinate(coo);
                schoolInfos.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schoolInfos;
    }

    /**
     * According to the food id, retrieve the picture from the database
     * @param foodId
     * @return
     */
    public static String findFoodPic(String foodId) {
        final String methodPath = "com.kidozone.entity.foodinfo/findFoodPic/" + foodId;
        URL url = null;
        HttpURLConnection connection = null;
        String textResult = "";
        try {
            url = new URL(BASE_URL + methodPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                textResult += scanner.nextLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return textResult;
    }

    /**
     * According to the waste id, retrieve the picture from the database
     * @param wasteId
     * @return
     */
    public static String findWastePic(String wasteId) {
        final String methodPath = "com.kidozone.entity.wasteinfo/findWastePic/" + wasteId;
        URL url = null;
        HttpURLConnection connection = null;
        String textResult = "";
        try {
            url = new URL(BASE_URL + methodPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                textResult += scanner.nextLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return textResult;
    }
}
