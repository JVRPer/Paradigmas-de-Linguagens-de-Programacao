public class Concateca {
    public Concateca(){

        long startTime = System.nanoTime();
        String result = "";
        for(int i = 0; i < 100; i++){
            result += "a";
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        
        System.out.println("Tempo de execução: " + duration + " em nanosegundos concatenacao simples");
        System.out.println(result);

        public void rodar(int quantidade){
            
        };
        
    }
}