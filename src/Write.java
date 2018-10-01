import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Write
{


    private BufferedWriter outputFile;

    public Write()
    {
    }



    public Write(String filename)
    {

        openFile(filename, false);

    }


    public Write(String filename, boolean append)
    {

        openFile(filename, append);

    }


    public void openFile(String filename)
    {

        openFile(filename, false);

    }


    public void openFile(String filename, boolean append)
    {
        try
        {

            outputFile = new BufferedWriter(new FileWriter(filename, append));

        }
        catch (IOException e)
        {
            return;
        }
    }


    public void writeToTextFile(String content)
    {
        writeToTextFile(content, System.getProperty("line.separator"));
    }


    public void writeToTextFile(String content, String lineSeparator)
    {
        try
        {

            outputFile.write(content + lineSeparator);

        }
        catch (IOException e)
        {

            closeFile();
        }
    }


    public void closeFile()
    {
        try
        {

            if (outputFile != null)
            {
                outputFile.flush();
                outputFile.close();
            }

        }
        catch (IOException ioe)
        {
            return;
        }
    }
} 