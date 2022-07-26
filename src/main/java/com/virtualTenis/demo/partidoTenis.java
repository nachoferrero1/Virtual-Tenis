package com.virtualTenis.demo;



import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.abs;

public class partidoTenis {
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		String jugadorUno ;
		String jugadorDos ;
		String nombreDelTorneo ;
		int numeroDeSets = 0;
		int probabilidadJugadorUno = 0;
		int probabilidadJugadorDos = 0;
		String seguirJugando = "si";

		//ESCRIBIR ALGO POR CONSOLA
		System.out.println("Bienvenido a Virtual Tennis");


		//PEDIR DATOS DE TEXTO Y NUMERICOS
		System.out.print("ingresar nombre del primer jugador ");
		jugadorUno = entrada.nextLine();
		System.out.println("");

		System.out.print("ingresar nombre del segundo jugador ");
		jugadorDos = entrada.nextLine();
		System.out.println("");

		System.out.print("ingrese nombre del torneo ");
		nombreDelTorneo = entrada.nextLine();
		System.out.println("");

		System.out.print("ingrese cuantos Sets va a jugar, 3 o 5 ");
		numeroDeSets = entrada.nextInt();
		System.out.println("");

		System.out.print("ingrese la probabilidad de que el jugador uno gane el juego ");
		probabilidadJugadorUno = entrada.nextInt();
		System.out.println("");

		System.out.print("ingrese la probabilidad de que el jugador Dos gane el juego ");
		probabilidadJugadorDos = entrada.nextInt();
		System.out.println("");

		while(seguirJugando.equals("si")){
			jugar(jugadorUno, jugadorDos,  nombreDelTorneo,  numeroDeSets,
			 probabilidadJugadorUno,  probabilidadJugadorDos);

			//arrays con resultados

			//PEDIR REVANCHA
			System.out.print("queres jugar la revancha, SI O NO?");
			seguirJugando = entrada.next().toLowerCase();
			System.out.println("");

		}
		System.out.print("Game Over");

	}

	public static void jugar(String jugadorUno, String jugadorDos, String nombreDelTorneo, int numeroDeSets,
	int probabilidadJugadorUno, int probabilidadJugadorDos){

		//INICIO DEL JUEGO
		int juegosGanados1 = 0;
		int juegosGanados2 = 0;
		int matchJugados = 0;
		int setsGanadosJugador1 = 0;
		int setsGanadosJugador2 = 0;
		int setsParaGanar = 0;
		if (numeroDeSets == 5){
			 setsParaGanar = 3;
		} else if (numeroDeSets == 3) {
			 setsParaGanar = 2;
		} else {
			System.out.println("ingrese 3 o 5");
			System.exit(0);
		}
		//  3 o 5 sets
		//  1 set = 6 juegos ganados
		//  1 juego ganado = 3 puntos
		//abs(juegosGanados1 - juegosGanados2) < 2

		//condicion de juego
		while(setsGanadosJugador1 < setsParaGanar && setsGanadosJugador2 < setsParaGanar){

			while (juegosGanados1 < 6 && juegosGanados2 < 6){
				int probabilidadUno = ((int)(Math.random() * 100) * probabilidadJugadorUno );
				int probabilidadDos = ((int)(Math.random() * 100) * probabilidadJugadorDos);
				if(probabilidadUno > probabilidadDos){
					juegosGanados1++;
					System.out.println("el saque corresponde a " + jugadorDos);
					System.out.println("el ganador de este punto es el jugador " + jugadorUno);
					System.out.println("Resultados parciales " + jugadorUno + " = " + juegosGanados1 + " / " + jugadorDos + " = " + juegosGanados2 );
					System.out.println("");
				} else {
					juegosGanados2++;
					System.out.println("el saque corresponde a " + jugadorUno);
					System.out.println("el ganador de este punto es el jugador " + jugadorDos);
					System.out.println("Resultados parciales " + jugadorUno + " = " + juegosGanados1 + " y " + jugadorDos + " = " + juegosGanados2 );
					System.out.println("");
				}
			}

			//Limite de 6 puntos
			if (juegosGanados1 == 6){
				setsGanadosJugador1++;
			} else {
				setsGanadosJugador2++;
			}

			System.out.println("Resultados parciales de Sets " + jugadorUno + " = " + setsGanadosJugador1 + " / " + jugadorDos + " = " + setsGanadosJugador2 );
			System.out.println("");

			juegosGanados1 = 0;
			juegosGanados2 = 0;

		}

		if (setsGanadosJugador1 == setsParaGanar){
			System.out.println("Felicitaciones " + jugadorUno + "Obtuviste el primer puesto en la copa" + nombreDelTorneo);
		} else {
			System.out.println("Felicitaciones " + jugadorDos + "Obtuviste el primer puesto en la copa" + nombreDelTorneo);
		}


	}
}



