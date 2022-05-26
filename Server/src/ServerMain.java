import Commands.*;
import Org.ProductCollection;
import manager.CommandToSer;
import manager.Serializator;
import manager.Worker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) throws ParserException {
        ProductCollection.setFileName(args[0]);
        Parser.fillCollection(ProductCollection.getFileName());


        try (ServerSocket server = new ServerSocket(8765)) {

            System.out.println("Server started");

            while(true) {
                try (
                        Socket socket = server.accept();

                        OutputStream out = socket.getOutputStream();
                        DataOutputStream writer = new DataOutputStream(out);

                        InputStream in = socket.getInputStream();
                        DataInputStream reader = new DataInputStream(in);
                ) {
                    System.out.println("Подключился клиент");
                    Worker worker = new Worker();
                    while (true){

                        int len = reader.readInt();
                        byte[] data = new byte[len];
                        if (len > 0) {
                            reader.readFully(data);
                        }

                        CommandToSer commandAndArg = (CommandToSer) Serializator.deserialization(data);
                        System.out.println(commandAndArg.getCommand());
                        if (commandAndArg.getCommand().equals("exit"))
                        {
                            writer.write(worker.work("save",commandAndArg.getArg()));
                            writer.flush();
                            writer.close();
                            reader.close();
                            break;
                        }

                        byte[] response = worker.work(commandAndArg.getCommand(),commandAndArg.getArg());
                        writer.writeInt(response.length);
                        writer.write(response);
                        writer.flush();


                        /*String request = reader.readLine();
                        System.out.println("Request: " + request);
                        receiver.runCommand(request + " a");

                        String response = "Hello from server: " + request.toString();

                        writer.write(response);
                        writer.newLine();
                        writer.flush();
                        */



                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
