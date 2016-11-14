package br.com.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatRun {

	private static String NICKNAME = "";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int status = -1;

		try {
			ChatServer chServer = (ChatServer) Naming.lookup("//localhost/conectar");
			ChatClient client = new ChatClientImpl();

			onLine(chServer, client);

			chServer.desconectar(client, NICKNAME);
			System.exit(0);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void onLine(ChatServer chServer, ChatClient client) throws RemoteException {

		String msg = "";
		//scanner.nextLine();
		System.out.println("Name: ");
		NICKNAME = scanner.nextLine();

		chServer.conectar(client, NICKNAME);
		((ChatClientImpl) client).setNickName(NICKNAME);
		System.out.println("Digite \"bye\" para sair!");

		whoIsOnLine(chServer);
		System.out.println(NICKNAME + ": ");
		
		while (!msg.equals("bye")) {
			msg = scanner.nextLine();
			chServer.falar(NICKNAME, msg);
		}
	}

	private static void whoIsOnLine(ChatServer chServer) {
		String[] naSessao = chServer.naSessao();

		System.out.println("Online: ↓");
		for (int i = 0; i < naSessao.length; i++) {
			System.out.println(naSessao[i]);
		}
		System.out.println("----------------------");

	}
}
