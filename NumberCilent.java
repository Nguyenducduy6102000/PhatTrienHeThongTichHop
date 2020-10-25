package Number;
import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

import java.util.Scanner;
public class NumberCilent {
	public static void main(String[] args) throws IOException

    {

    // TODO code application logic here

   

        Socket mySocket = null;

        DataOutputStream dos = null;

        DataInputStream dis=null;

       

        try {

            mySocket = new Socket("localhost", 8000);

            dos = new DataOutputStream(mySocket.getOutputStream());

            dis = new DataInputStream(mySocket.getInputStream());

            Scanner input = new Scanner(System.in);

            String s = null;

            while(true)

            {

                System.out.print("\nNhap du lieu: ");

                s =input.nextLine();

                dos.writeUTF(s);

               

                String str=dis.readUTF();

                System.out.print("Kết quả từ Server : "+str);

            }

        }

        catch(Exception e) {

            System.out.print("Ngat ket noi");

            dis.close();

            dos.close();

            mySocket.close();

            e.printStackTrace();

        }

    }
}
