import java.util.Random;
import static java.lang.Math.abs;

public class MatrixTesting {
    public static void main(String[]args){
        long startTime = System.nanoTime();
        Test();
        long endTime = System.nanoTime();
        System.out.format("finished in %d milliseconds%n",(endTime - startTime)/1000000);
    }
    private static void Test(){
        Random rand = new Random();
        int m = abs(rand.nextInt()%1999)+1;//num of row
        int n = abs(rand.nextInt()%1999)+1;//num of columns
        System.out.format("%dx%d Matrix%n", m, n);
        int[][] k = new int[m][n];
        for(int i  =0;i<m;i++){
            for(int j = 0;j<n;j++){
                k[i][j] = abs(rand.nextInt()%100);
            }
        }
        Matrix matrix = new Matrix(k);
        int r = abs(rand.nextInt()%9)+1;
        Matrix m2 = MatrixScalarMultiply(matrix, r);
        Matrix m3 = MatrixAdd(matrix, m2);
        Matrix m4 = Transpose(m3);
        Matrix m5 = MatrixMultiply(matrix, m4);
        Matrix m6 = m5.inverse();
    }
    private static Matrix MatrixAdd(Matrix a, Matrix b){
        Matrix m = new Matrix(a.values);
        if (a.m == b.m && a.n == b.n){
            for(int i  =0;i<a.m;i++){
                for(int j = 0;j<a.n;j++){
                    m.values[i][j] = a.values[i][j]+b.values[i][j];
                }
            }
            return m;
        }
        return null;
    }
    private static Matrix MatrixScalarMultiply(Matrix a, int x){
        Matrix m = new Matrix(a.values);
        for(int i  =0;i<a.m;i++){
            for(int j = 0;j<a.n;j++){
                m.values[i][j] = a.values[i][j]*x;
            }
        }
        return m;
    }
    private static Matrix MatrixMultiply(Matrix a, Matrix b){
        if(a.n==b.m) {
            int m = a.m;
            int n = b.n;
            Matrix matrix = new Matrix(a.m,b.n,0);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //for each value in the resulting matrix
                    for (int k = 0;k<a.n;k++){
                        matrix.values[i][j] = matrix.values[i][j] + a.values[i][k] * b.values[k][j];
                    }
                }
            }
            return matrix;
        }
        return null;
    }
    private static Matrix Transpose(Matrix a){
        Matrix t = new Matrix(a.n, a.m, 0);
        for(int i  =0;i<t.m;i++){
            for(int j = 0;j<t.n;j++){
                t.values[i][j] = a.values[j][i];
            }
        }
        return t;
    }
}
