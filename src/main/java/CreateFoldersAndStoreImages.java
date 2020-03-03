import org.json.simple.JSONObject;

import java.io.*;
import java.net.URL;

public class CreateFoldersAndStoreImages {
    //the path for folders
    static String path="C:/Users/sumey/";
    static JSONObject jsonObject1 = new JSONObject();
    static JSONObject jsonObject2 = new JSONObject();
    static JSONObject jsonObject3 = new JSONObject();
    static JSONObject jsonObject4 = new JSONObject();
    static JSONObject jsonObject5 = new JSONObject();
    static JSONObject jsonObject6 = new JSONObject();
    public static void main(String[] args) throws Exception{

        jsonObject1.put("id", "1");
        jsonObject1.put("first_name", "George");
        jsonObject1.put("last_name", "Bluth");
        jsonObject1.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");

        jsonObject2.put("id", "2");
        jsonObject2.put("first_name", "Janet");
        jsonObject2.put("last_name", "Weaver");
        jsonObject2.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

        jsonObject3.put("id", "3");
        jsonObject3.put("first_name", "Emma");
        jsonObject3.put("last_name", "Wong");
        jsonObject3.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");

        jsonObject4.put("id", "4");
        jsonObject4.put("first_name", "Eve");
        jsonObject4.put("last_name", "Holt");
        jsonObject4.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");

        jsonObject5.put("id", "5");
        jsonObject5.put("first_name", "Charles");
        jsonObject5.put("last_name", "Morris");
        jsonObject5.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");

        jsonObject6.put("id", "6");
        jsonObject6.put("first_name", "Tracey");
        jsonObject6.put("last_name", "Ramos");
        jsonObject6.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");

        createDirectoryForEachObject(jsonObject1);
        createDirectoryForEachObject(jsonObject2);
        createDirectoryForEachObject(jsonObject3);
        createDirectoryForEachObject(jsonObject4);
        createDirectoryForEachObject(jsonObject5);
        createDirectoryForEachObject(jsonObject6);
        saveImage(jsonObject1, jsonObject1.get("avatar").toString());
        saveImage(jsonObject2, jsonObject2.get("avatar").toString());
        saveImage(jsonObject3, jsonObject3.get("avatar").toString());
        saveImage(jsonObject4, jsonObject4.get("avatar").toString());
        saveImage(jsonObject5, jsonObject5.get("avatar").toString());
        saveImage(jsonObject6, jsonObject6.get("avatar").toString());
    }

        public static void createDirectoryForEachObject(JSONObject object)throws Exception{
            File file = new File(""+path+object.get("first_name")+object.get("last_name")+object.get("id"));
            //Creating the directory
            boolean bool = file.mkdirs();
            if(bool){
                System.out.println("JSON Object Directory created successfully with the name of "+object.get("first_name"));
            }else{
                System.out.println("Sorry, couldn't create specified directory");
            }
        }

    public static void saveImage(JSONObject object, String imageUrl) throws Exception
    {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new BufferedOutputStream(new FileOutputStream(""+path+object.get("first_name")+object.get("last_name")+object.get("id")+"/photo.jpg"));
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1)
        { os.write(b, 0, length); }
        is.close();
        os.close();
    }
}


