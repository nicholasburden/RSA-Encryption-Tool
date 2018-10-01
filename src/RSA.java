

import java.io.File;
import java.math.BigInteger;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class RSA {
    public static String directory = System.getProperty("user.dir") + "/Files/";
    Write writeFile = new Write();
    Read read = new Read();
    public RSA(){

    }
    public RSA(int bitLength){
        new File(directory).mkdir();
        Keys keys = new Keys(bitLength);
        keys.saveKeys();
    }
    public synchronized void encrypt(String message, String fileName) {

        read.openTextFile(fileName);
        String keys = read.readLine();
        read.closeFile();
        try{
            StringTokenizer stok = new StringTokenizer(keys, ",");
            BigInteger n = new BigInteger(stok.nextToken());
            BigInteger e = new BigInteger(stok.nextToken());
            String x = (new BigInteger(message.getBytes())).modPow(e, n).toString();
            writeFile.openFile(directory + "Encrypted Message.txt");
            writeFile.writeToTextFile(x);
            writeFile.closeFile();
            EncryptBox.fileInvalid = false;
        }
        catch(NullPointerException x){
            EncryptBox.fileInvalid = true;
            x.printStackTrace();
        }
        catch(NumberFormatException x){
            EncryptBox.fileInvalid = true;
            x.printStackTrace();
        }
    }
    public synchronized void decrypt(String messageFileName, String keysFileName) {
        String message;
        String keys;

        read.openTextFile(messageFileName);
        message = read.readLine();
        read.closeFile();

        read.openTextFile(keysFileName);
        keys = read.readLine();

        read.closeFile();
        try{
            StringTokenizer stok = new StringTokenizer(keys, ",");
            BigInteger n = new BigInteger(stok.nextToken());

            BigInteger d = new BigInteger(stok.nextToken());



            String x = new String((new BigInteger(message)).modPow(d, n).toByteArray());
            writeFile.openFile(directory + "Decrypted Message.txt");
            writeFile.writeToTextFile(x);
            writeFile.closeFile();
            DecryptBox.filesInvalid = false;
        }
        catch(NullPointerException x){
            DecryptBox.filesInvalid = true;
            return;
        }
        catch(NumberFormatException x){

            DecryptBox.filesInvalid = true;
            return;
        }
        catch(NoSuchElementException x){

            DecryptBox.filesInvalid = true;
            return;
        }
    }
    public static void main(String args[]){
        new MainFrame();






    }


}


