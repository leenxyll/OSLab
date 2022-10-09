// 64050001 นางสาวกชนิกา แย้มศรวล
import java.util.Arrays;

public class Lab_MatrixMul{
    public static void main(String[] args) {
        int[][] inputA = {{5, 6, 7}, {4, 8, 9}};
        int[][] inputB = {{6, 4}, {5, 7}, {1, 1}};

        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);

        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;

        MyData matC = new MyData(matC_r, matC_c);

        // q4 construct 2D array for each "thread" with respect to each cell in matC, 
        // then start each thread
        Thread cal = new Thread(new MatrixMulThread(0, 0, matA, matB, matC));
        cal.start();
        Thread cal1 = new Thread(new MatrixMulThread(1, 1, matA, matB, matC));
        cal1.start();

        // q5 join each thread
        try{
            cal.join();
            cal1.join();
        }
        catch(Exception e){
            System.out.println(e);
        }

        matC.show();
    }
}
class MatrixMulThread implements Runnable{
    int processing_row;
    int processing_col;
    MyData datA; 
    MyData datB;
    MyData datC;
    MatrixMulThread(int tRow, int tCol, MyData a, MyData b, MyData c){
        // Q1 code here
        processing_row = tRow;
        processing_col = tCol;
        datA = a;
        datB = b;
        datC = c;

    }
    /* q2 */ public void run(){
        // q3
        for(int i = 0; i < datA.data.length; i++) {
            for(int j = 0; j < datB.data.length; j++){
                if(j == 0) datC.data[processing_row][i] -= 9;
                datC.data[processing_row][i] += datA.data[processing_row][j] * datB.data[j][i];
            }
        }
        
        // System.out.println("perform sum of multiplication of assigned row and col");
    }
}
class MyData{
    int[][] data;

    MyData(int[][] m){
        data = m;
    }
    MyData(int r, int c){
        data = new int[r][c];
        for(int[] aRow : data){
            Arrays.fill(aRow, 9);
        }
    }
    void show(){
        System.out.println(Arrays.deepToString(data));
    }
}

