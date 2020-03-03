
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnitTest {

    @Test
    public void unitTestForDirectory(){
        verifyDirectoriesExist();
    }

    public void verifyDirectoriesExist() {
        String object1="C:/Users/sumey/GeorgeBluth1";
        String object2="C:/Users/sumey/JanetWeaver2";
        String object3="C:/Users/sumey/EmmaWong3";
        String object4="C:/Users/sumey/EveHolt4";
        String object5="C:/Users/sumey/CharlesMorris5";
        String object6="C:/Users/sumey/TraceyRamos6";
        List<String> listOfPath = new ArrayList<String>();
        listOfPath.add(object1);
        listOfPath.add(object2);
        listOfPath.add(object3);
        listOfPath.add(object4);
        listOfPath.add(object5);
        listOfPath.add(object6);

        for(int i =0;i<listOfPath.size();i++) {
            File directory = new File(""+listOfPath.get(i));
            boolean isExisting = directory.exists();
            if(isExisting){
                System.out.println("Directory "+listOfPath.get(i).substring(15)+" exists");
            }
            else
                System.out.println("Directory "+listOfPath.get(i).substring(15)+" does not exist");
        }
    }
}