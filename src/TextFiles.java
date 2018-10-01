import java.io.File;
import java.util.ArrayList;



public class TextFiles{
    Read r = new Read();
    private File folder = new File(RSA.directory);
    private File[] listOfFiles = folder.listFiles();
    private ArrayList<String> fileNames = new ArrayList<String>();



    public TextFiles(){
        for(int i = 0; i < listOfFiles.length; i++){
            if(listOfFiles[i].isFile()){
                fileNames.add(listOfFiles[i].getName());

            }
        }
    }

    public void deleteFiles(){
        for(int i = 0; i < listOfFiles.length; i++){

            listOfFiles[i].delete();

        }
    }

    public ArrayList<String> getFiles(){
        ArrayList<String> names = new ArrayList<String>();
        for(int i = 0; i < fileNames.size(); i++){
            r.openTextFile(RSA.directory + fileNames.get(i));
            r.closeFile();
            names.add(fileNames.get(i));
        }
        return names;
    }

}
