public class Append {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 100; i++){
            sb.append("a");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        
        System.out.println("Tempo de execução: " + duration + " em nanosegundos by StringBuilder");
        System.out.println(sb);
    }
}
