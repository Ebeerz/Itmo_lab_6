import manager.CommandAndArg;
import manager.Serializator;
import manager.Worker;
import manager.MessageToSer;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args){
        try(
                Socket socket = new Socket("127.0.0.1", 8765);
                OutputStream out = socket.getOutputStream();
                DataOutputStream writer = new DataOutputStream(out);

                //BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                InputStream in = socket.getInputStream();
                DataInputStream reader = new DataInputStream(in);
        ){
            System.out.println("Подключились к серверу");
            Scanner sc = new Scanner(System.in);
            Worker worker = new Worker();


            while (true){
                CommandAndArg.setCommand("");
                CommandAndArg.setArg(null);

                String command = sc.nextLine();
                byte[] request = worker.work(command);
                if (request != null) {
                    writer.writeInt(request.length);
                    writer.write(request);
                    writer.flush();

                    if (command.split(" ")[0].equals("exit")) {
                        writer.close();
                        reader.close();
                        System.exit(0);
                    }

                    int len = reader.readInt();
                    byte[] data = new byte[len];
                    if (len > 0) {
                        reader.readFully(data);
                    }

                    MessageToSer messageToSer = (MessageToSer) Serializator.deserialization(data);
                    System.out.println(messageToSer.toString());
                }else {
                    System.out.println("Ошибка");
                }
            }



        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
