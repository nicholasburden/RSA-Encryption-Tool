import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;


public class Read
{

    //The global variable link to the open file
    private BufferedReader textFileReader;


    public Read()
    {
    } // end constructor AQAReadTextFile2014


    public Read(String filename)
    {
        openTextFile(filename);
    } // end constructor AQAReadTextFile2014


    public void openTextFile(String filename)
    {
        try
        {
            textFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
        }
        catch (IOException e)
        {
            return;
        }
    }


    public char readChar()
    {
        char c = '\u0000';
        try {

            c = (char) textFileReader.read();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            closeFile();
        }
        return c;
    }


    public String readLine()
    {
        String line = null;
        try
        {

            line = textFileReader.readLine();

        }
        catch (NullPointerException e)
        {

            return null;
        }
        catch(IOException e){
            return null;
        }
        return line;
    }


    public void closeFile()
    {
        try
        {

            textFileReader.close();

        }
        catch (IOException ioe)
        {
            return;
        }
        catch(NullPointerException e){
            return;
        }
    }

} 