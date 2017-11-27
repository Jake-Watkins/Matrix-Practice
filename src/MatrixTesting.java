import java.util.Random;
import static java.lang.Math.abs;

public class MatrixTesting {
    public static void main(String[]args){
        Random rand = new Random();
        int m = abs(rand.nextInt()%9)+1;
        int n = abs(rand.nextInt()%9)+1;
        n = m;
        int x= 0;
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
        Matrix m4 = Transpose(matrix);
        Matrix m5 = MatrixMultiply(matrix, m4);
        System.out.println("m1\n"+matrix);
        System.out.println("m2\n"+m2);
        System.out.println("m3\n"+m3);
        System.out.println("m4\n"+m4);
        System.out.println("m5\n"+m5);
        System.out.println(matrix.inverse());
        System.out.println(MatrixMultiply(matrix, matrix.inverse()));
    }
    public static Matrix MatrixAdd(Matrix a, Matrix b){
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
    public static Matrix MatrixScalarMultiply(Matrix a, int x){
        Matrix m = new Matrix(a.values);
        for(int i  =0;i<a.m;i++){
            for(int j = 0;j<a.n;j++){
                m.values[i][j] = a.values[i][j]*x;
            }
        }
        return m;
    }
    public static Matrix MatrixMultiply(Matrix a, Matrix b){
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
    public static Matrix Transpose(Matrix a){
        Matrix t = new Matrix(a.n, a.m, 0);
        for(int i  =0;i<t.m;i++){
            for(int j = 0;j<t.n;j++){
                t.values[i][j] = a.values[j][i];
            }
        }
        return t;
    }
}
