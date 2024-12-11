package Ejercicio1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Thread hilo = new Thread(() -> {
            System.out.println("Hola desde un hilo: " + Thread.currentThread().getName());
        });
        hilo.start();
        System.out.println("Hola desde el hilo principal: " + Thread.currentThread().getName());
    */
        ExecutorService executorService = Executors.newFixedThreadPool(3); //Iniciamos 3 hilos (pool)

       /* Runnable tarea = () -> {
            System.out.println("Tarea ejecutada por: " + Thread.currentThread().getName());
        };
        for(int i = 0; i < 5; i++) {
            executorService.execute(tarea);
        }


        executorService.shutdown(); //Indicamos que no hay más tareas para ejecutar
        */

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //Callable Devuelve un valor
        Callable<Integer> tarea = () ->{
            Thread.sleep(2000);
            return 42;
        };

        Future<Integer> future = executorService1.submit(tarea);
        System.out.println("Realizando operaciones.");
        Integer result = future.get();

        System.out.println("Resultado de la tarea: " + result);
        executorService1.shutdown();
    }
}